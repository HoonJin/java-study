package com.hoonjin.study.spring.grpc.client;

import io.grpc.Channel;
import io.grpc.stub.StreamObserver;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class AsyncUserClient {

    private final UserServiceGrpc.UserServiceStub asyncStub;

    public AsyncUserClient(Channel channel) {
        this.asyncStub = UserServiceGrpc.newStub(channel);
    }

    public void getUserStream(int page, int size) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        UserProto.GetUsersRequest getUsersRequest = UserProto.GetUsersRequest.newBuilder()
            .setPage(page)
            .setSize(size)
            .build();

        asyncStub.getUsersStream(getUsersRequest, new StreamObserver<>() {
            @Override
            public void onNext(UserProto.UserResponse user) {
                log.info("스트림으로 받은 사용자: ID {}, 이름 {}, 이메일 {}",
                    user.getId(), user.getName(), user.getEmail());
            }

            @Override
            public void onError(Throwable throwable) {
                log.error("스트리밍 오류: ", throwable);
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                log.info("스트리밍 완료");
                latch.countDown();
            }
        });

        latch.await(30, TimeUnit.SECONDS);
    }

    @PostConstruct
    public void runStreamTest() throws InterruptedException {
        log.info("=== 스트리밍 테스트 ===");
        getUserStream(1, 10);
    }
}
