package com.hoonjin.study.spring.rest1.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hoonjin.study.spring.rest1.post.Post;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties({"password", "ssn"})
@Schema(description = "사용자 엔티티")
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Schema(title = "사용자 id", description = "자동생성값")
    private Integer id;

    @Schema(title = "사용자 이름", description = "이름")
    @Size(min = 2, message = "name은 두글자 이상 입력해 주세요.")
    private String name;

    @Schema(title = "사용자 등록일자", description = "등록일. 입력하지 않을시 현재일자.")
    @Past(message = "joinDate는 미래 날짜로 등록할 수 없습니다.")
    private Date joinDate;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String ssn;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;

    public User(Integer id, String name, Date joinDate, String password, String ssn) {
        this.id = id;
        this.name = name;
        this.joinDate = joinDate;
        this.password = password;
        this.ssn = ssn;
    }
}
