package com.hoonjin.study.spring.grpc.server;

import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.grpc.server.service.GrpcService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static com.hoonjin.study.spring.grpc.server.UserProto.*;

@GrpcService
public class UserGrpcService extends UserServiceGrpc.UserServiceImplBase {
    
    private static final Logger logger = LoggerFactory.getLogger(UserGrpcService.class);
    
    // 간단한 인메모리 저장소
    private final Map<Long, UserResponse> users = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    
    public UserGrpcService() {
        // 초기 데이터 추가
        users.put(1L, UserResponse.newBuilder()
                .setId(1)
                .setName("홍길동")
                .setEmail("hong@example.com")
                .setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build());
        
        users.put(2L, UserResponse.newBuilder()
                .setId(2)
                .setName("김영희")
                .setEmail("kim@example.com")
                .setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build());
    }
    
    @Override
    public void getUser(GetUserRequest request, StreamObserver<UserResponse> responseObserver) {
        logger.info("GetUser 요청: ID {}", request.getId());
        
        UserResponse user = users.get(request.getId());
        
        if (user != null) {
            responseObserver.onNext(user);
        } else {
            // 사용자를 찾을 수 없는 경우
            responseObserver.onError(
                io.grpc.Status.NOT_FOUND
                    .withDescription("사용자를 찾을 수 없습니다: " + request.getId())
                    .asRuntimeException()
            );
            return;
        }
        
        responseObserver.onCompleted();
    }
    
    @Override
    public void createUser(CreateUserRequest request, StreamObserver<UserResponse> responseObserver) {
        logger.info("CreateUser 요청: 이름 {}, 이메일 {}", request.getName(), request.getEmail());
        
        long newId = idGenerator.getAndIncrement();
        
        UserResponse newUser = UserResponse.newBuilder()
                .setId(newId)
                .setName(request.getName())
                .setEmail(request.getEmail())
                .setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build();
        
        users.put(newId, newUser);
        
        responseObserver.onNext(newUser);
        responseObserver.onCompleted();
    }
    
    @Override
    public void getUsersStream(GetUsersRequest request, StreamObserver<UserResponse> responseObserver) {
        logger.info("GetUsersStream 요청: 페이지 {}, 사이즈 {}", request.getPage(), request.getSize());
        
        // 스트리밍으로 사용자 목록 전송
        users.values().forEach(user -> {
            try {
                // 스트리밍 효과를 위해 잠시 대기
                Thread.sleep(500);
                responseObserver.onNext(user);
                logger.info("사용자 전송: {}", user.getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                responseObserver.onError(e);
            }
        });
        
        responseObserver.onCompleted();
    }
}