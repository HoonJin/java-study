package com.hoonjin.study.spring.rest1.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.Date;

@Data
@AllArgsConstructor
//@JsonIgnoreProperties({"password", "ssn"})
public class User {
    private Integer id;

    @Size(min = 2, message = "name은 두글자 이상 입력해 주세요.")
    private String name;

    @Past(message = "joinDate는 미래 날짜로 등록할 수 없습니다.")
    private Date joinDate;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String ssn;
}
