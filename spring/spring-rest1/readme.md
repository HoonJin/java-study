[이도원 - Spring Boot 3.x 를 이용한 RESTful Web Services 개발](https://www.inflearn.com/course/spring-boot-restful-web-services/dashboard)

* section2 회원 생성 & 삭제 테스트
  ```shell
  # 회원 생성
  curl -v -XPOST localhost:8080/users \
    -H 'Content-Type: application/json' \ 
    -d '{"name":"test"}'

  # 회원 삭제  
  curl -v -XDELETE localhost:8080/users/1
  ```