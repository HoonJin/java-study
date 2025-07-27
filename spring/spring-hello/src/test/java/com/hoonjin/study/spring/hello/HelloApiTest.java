package com.hoonjin.study.spring.hello;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

// 어플리케이션을 실행시키지 않은 상태에선 테스트 불가
class HelloApiTest {

    @Test
    void helloApi() {
        // http localhost:8080/hello?name=Spring // HTTPie
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/app/hello?name={name}", String.class, "Spring");

        // status code 200
        assertThat(response.getStatusCode())
            .isEqualTo(HttpStatus.OK);
        // header(content-type) text/plain
        assertThat(response.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE))
            .startsWith(MediaType.TEXT_PLAIN_VALUE); // charset 도 있어서 startsWith 를 사용
        // body Hello Spring!
        assertThat(response.getBody())
            .isEqualTo("*Hello Spring!*");
    }

    @Test
    void failsHelloApi() {
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/app/hello?name={name}", String.class, "");

        assertThat(response.getStatusCode())
            .isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}