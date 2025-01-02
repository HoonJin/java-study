package com.hoonjin.study.spring.msa.userservice.service;

import com.hoonjin.study.spring.msa.userservice.dto.UserDto;
import com.hoonjin.study.spring.msa.userservice.jpa.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();

    UserDto getUserDetailsByEmail(String userName);
}
