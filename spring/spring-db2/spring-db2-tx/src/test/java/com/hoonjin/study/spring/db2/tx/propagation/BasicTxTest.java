package com.hoonjin.study.spring.db2.tx.propagation;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
public class BasicTxTest {

    @Autowired
    PlatformTransactionManager transactionManager;

    @TestConfiguration
    static class Config {

        @Bean
        public PlatformTransactionManager transactionManager(DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }
    }

    @Test
    void commit() {
        log.info("start transaction");
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        log.info("start commit");
        transactionManager.commit(status);
        log.info("commit is done");
    }

    @Test
    void rollback() {
        log.info("start transaction");
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        log.info("start rollback");
        transactionManager.rollback(status);
        log.info("rollback is done");
    }

    @Test
    void doubleCommit() {
        log.info("start transaction 1");
        TransactionStatus status1 = transactionManager.getTransaction(new DefaultTransactionDefinition());

        log.info("start commit 1");
        transactionManager.commit(status1);

        log.info("start transaction 2");
        TransactionStatus status2 = transactionManager.getTransaction(new DefaultTransactionDefinition());

        log.info("start commit 2");
        transactionManager.commit(status2);
    }

    @Test
    void commitAndRollback() {
        log.info("start transaction 1");
        TransactionStatus status1 = transactionManager.getTransaction(new DefaultTransactionDefinition());

        log.info("start commit 1");
        transactionManager.commit(status1);

        log.info("start transaction 2");
        TransactionStatus status2 = transactionManager.getTransaction(new DefaultTransactionDefinition());

        log.info("start rollback 2");
        transactionManager.rollback(status2);
    }

    @Test
    void innerCommit() {
        log.info("start external transaction");
        TransactionStatus outer = transactionManager.getTransaction(new DefaultTransactionDefinition());
        log.info("outer.isNewTransaction()={}", outer.isNewTransaction());

        log.info("start internal transaction");
        TransactionStatus inner = transactionManager.getTransaction(new DefaultTransactionDefinition());
        // o.s.j.d.DataSourceTransactionManager     : Participating in existing transaction
        log.info("inner.isNewTransaction()={}", inner.isNewTransaction()); // 내부 트랜잭션은 외부 트랜잭션에 포함되어 있음

        log.info("commit internal transaction");
        transactionManager.commit(inner);

        log.info("commit external transaction");
        transactionManager.commit(outer); // commit 은 외부 트랜잭션이 실행되는 시점에 한다. // 즉 내부 transaction commit 은 의미 없음

        Assertions.assertThat(outer.isNewTransaction()).isTrue();
        Assertions.assertThat(inner.isNewTransaction()).isFalse();
    }

    @Test
    void outerRollback() {
        log.info("start external transaction");
        TransactionStatus outer = transactionManager.getTransaction(new DefaultTransactionDefinition());

        log.info("start internal transaction");
        TransactionStatus inner = transactionManager.getTransaction(new DefaultTransactionDefinition());

        log.info("commit internal transaction");
        transactionManager.commit(inner);

        log.info("rollback external transaction");
        transactionManager.rollback(outer);
    }

    @Test
    void innerRollback() {
        log.info("start external transaction");
        TransactionStatus outer = transactionManager.getTransaction(new DefaultTransactionDefinition());

        log.info("start internal transaction");
        TransactionStatus inner = transactionManager.getTransaction(new DefaultTransactionDefinition());

        log.info("rollback internal transaction");
        transactionManager.rollback(inner);
        // o.s.j.d.DataSourceTransactionManager     : Participating transaction failed - marking existing transaction as rollback-only

        log.info("commit external transaction");
        Assertions.assertThatThrownBy(() -> transactionManager.commit(outer))
                .isInstanceOf(UnexpectedRollbackException.class);
        // o.s.j.d.DataSourceTransactionManager     : Global transaction is marked as rollback-only but transactional code requested commit
    }

    @Test
    void innerRollbackRequiresNew() {
        log.info("start external transaction");
        TransactionStatus outer = transactionManager.getTransaction(new DefaultTransactionDefinition());
        log.info("outer.isNewTransaction()={}", outer.isNewTransaction());

        log.info("start internal transaction");
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus inner = transactionManager.getTransaction(definition);
        // 기존 외부 트랜잭션을 suspend 하고 새 트랜잭션을 만들어냄
        // o.s.j.d.DataSourceTransactionManager     : Suspending current transaction, creating new transaction with name [null]
        log.info("inner.isNewTransaction()={}", inner.isNewTransaction());

        // 내부 트랜잭션에서 롤백이 일어나더라도 외부 트랜잭션에 영향을 주지 않음
        log.info("rollback internal transaction");
        transactionManager.rollback(inner);
        // o.s.j.d.DataSourceTransactionManager     : Resuming suspended transaction after completion of inner transaction

        log.info("commit external transaction");
        transactionManager.commit(outer);

        Assertions.assertThat(outer.isNewTransaction()).isTrue();
        Assertions.assertThat(inner.isNewTransaction()).isTrue();
    }
}
