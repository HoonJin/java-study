package com.hoonjin.study.java.thread.executor.test;

import java.util.List;
import java.util.concurrent.*;

import static com.hoonjin.study.java.util.MyLogger.log;
import static com.hoonjin.study.java.util.ThreadUtils.sleep;

public class NewOrderService {

    public void order(String orderNo) {
        try (ExecutorService service = Executors.newFixedThreadPool(3)) {
            InventoryWork inventoryWork = new InventoryWork(orderNo);
            ShippingWork shippingWork = new ShippingWork(orderNo);
            AccountingWork accountingWork = new AccountingWork(orderNo);

            List<Future<Boolean>> futures = service.invokeAll(List.of(inventoryWork, shippingWork, accountingWork));
            boolean result = futures.parallelStream().allMatch(f -> {
                try {
                    return f.get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
            if (result) {
                log("모든 주문 처리가 성공적으로 완료되었습니다.");
            } else {
                log("일부 작업이 실패했습니다.");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    static class InventoryWork implements Callable<Boolean> {
        private final String orderNo;
        public InventoryWork(String orderNo) {
            this.orderNo = orderNo;
        }
        public Boolean call() {
            log("재고 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }
    static class ShippingWork implements Callable<Boolean> {
        private final String orderNo;
        public ShippingWork(String orderNo) {
            this.orderNo = orderNo;
        }
        public Boolean call() {
            log("배송 시스템 알림: " + orderNo);
            sleep(1000);
            return true;
        }
    }
    static class AccountingWork implements Callable<Boolean> {
        private final String orderNo;
        public AccountingWork(String orderNo) {
            this.orderNo = orderNo;
        }
        public Boolean call() {
            log("회계 시스템 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }
}
