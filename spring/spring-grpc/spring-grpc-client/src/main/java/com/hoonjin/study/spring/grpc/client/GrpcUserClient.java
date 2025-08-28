package com.hoonjin.study.spring.grpc.client;

import com.hoonjin.study.spring.grpc.proto.user.CreateUserRequest;
import com.hoonjin.study.spring.grpc.proto.user.GetUserRequest;
import com.hoonjin.study.spring.grpc.proto.user.UserResponse;
import com.hoonjin.study.spring.grpc.proto.user.UserServiceGrpc;
import io.grpc.Channel;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GrpcUserClient {

    private final UserServiceGrpc.UserServiceBlockingStub blockingStub;

    public GrpcUserClient(Channel channel) {
        this.blockingStub = UserServiceGrpc.newBlockingStub(channel);
    }

    public UserResponse getUser(long id) {
        GetUserRequest request = GetUserRequest.newBuilder()
            .setId(id)
            .build();
        return blockingStub.getUser(request);
    }

    private UserResponse createUser(String name, String email) {
        CreateUserRequest createRequest = CreateUserRequest.newBuilder()
            .setName(name)
            .setEmail(email)
            .build();
        return blockingStub.createUser(createRequest);
    }

    @PostConstruct
    public void runTests() {
        // 1. 사용자 조회 테스트
        log.info("=== 사용자 조회 테스트 ===");
        UserResponse user = getUser(1);
        log.info("조회된 사용자: ID {}, 이름 {}, 이메일 {}",
            user.getId(), user.getName(), user.getEmail());

        // 2. 사용자 생성 테스트
        log.info("\n=== 사용자 생성 테스트 ===");
        UserResponse newUser = createUser("박철수", "park@example.com");
        log.info("생성된 사용자: ID {}, 이름 {}, 이메일 {}",
            newUser.getId(), newUser.getName(), newUser.getEmail());
    }
}
