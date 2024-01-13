package com.hoonjin.study.spring.rest1.admin;

import com.fasterxml.jackson.annotation.JsonFilter;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonFilter("UserInfo")
public class AdminUser {
    private Integer id;

    @Size(min = 2, message = "name은 두글자 이상 입력해 주세요.")
    private String name;

    @Past(message = "joinDate는 미래 날짜로 등록할 수 없습니다.")
    private Date joinDate;

    private String password;

    private String ssn;
}
