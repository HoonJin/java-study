package com.hoonjin.study.spring.msa.userservice.dto;

import com.hoonjin.study.spring.msa.userservice.vo.ResponseOrder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private Date createdAt;

    private String decryptedPwd;

    private String encryptedPwd;

    private List<ResponseOrder> orders;
}
