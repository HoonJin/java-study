package com.hoonjin.study.spring.splearn.adapter.webapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hoonjin.study.spring.splearn.adapter.webapi.dto.MemberRegisterResponse;
import com.hoonjin.study.spring.splearn.application.member.provided.MemberRegister;
import com.hoonjin.study.spring.splearn.application.member.required.MemberRepository;
import com.hoonjin.study.spring.splearn.domain.member.Member;
import com.hoonjin.study.spring.splearn.domain.member.MemberFixture;
import com.hoonjin.study.spring.splearn.domain.member.MemberRegisterRequest;
import com.hoonjin.study.spring.splearn.domain.member.MemberStatus;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.assertj.MvcTestResult;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;

import static com.hoonjin.study.spring.splearn.AssertThatUtils.isEqualsTo;
import static com.hoonjin.study.spring.splearn.AssertThatUtils.notNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@RequiredArgsConstructor
class MemberApiTest {
    final MockMvcTester mvcTester;
    final ObjectMapper objectMapper;
    final MemberRepository memberRepository;
    @Autowired
    private MemberRegister memberRegister;

    @Test
    void register() throws JsonProcessingException, UnsupportedEncodingException {
        MemberRegisterRequest request = MemberFixture.createMemberRegisterRequest();
        String requestJson = objectMapper.writeValueAsString(request);

        MvcTestResult result = mvcTester.post()
            .uri("/api/members")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestJson)
            .exchange();

//        result.assertThat()
        assertThat(result)
            .hasStatusOk()
            .bodyJson()
            .hasPathSatisfying("$.memberId", notNull())
            .hasPathSatisfying("$.email", isEqualsTo(request.email()));

        var response = objectMapper.readValue(result.getResponse().getContentAsString(), MemberRegisterResponse.class);
        Member member = memberRepository.findById(response.memberId()).orElseThrow();

        assertThat(member.getEmail().address()).isEqualTo(request.email());
        assertThat(member.getNickname()).isEqualTo(request.nickname());
        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
    }

    @Test
    void duplicateEmail() throws JsonProcessingException {
        MemberRegisterRequest request = MemberFixture.createMemberRegisterRequest();
        memberRegister.register(request);

        String requestJson = objectMapper.writeValueAsString(request);
        MvcTestResult result = mvcTester.post()
            .uri("/api/members")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestJson)
            .exchange();

        result.assertThat()
            .apply(print())
            .hasStatus(HttpStatus.CONFLICT);
    }

}
