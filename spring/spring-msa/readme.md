[Spring Cloud로 개발하는 마이크로서비스 애플리케이션(MSA)](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%81%B4%EB%9D%BC%EC%9A%B0%EB%93%9C-%EB%A7%88%EC%9D%B4%ED%81%AC%EB%A1%9C%EC%84%9C%EB%B9%84%EC%8A%A4/dashboard)

## create docker images
```shell
### in root of project
### APP_NAME=spring-msa-gateway
$ ./gradlew :clean :spring:spring-msa:${APP_NAME}:build -x test
$ docker build -t ${APP_NAME} spring/spring-msa --build-arg PATH=${APP_NAME}
```

## docker compose for infra
```shell
$ docker compose up -d
$ docker exec -it kafka bash
### in docker shell
$ cd /opt/kafka/bin
# topic 생성
$ ./kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092
# 토픽 리스트 조회
$ ./kafka-topics.sh --list --bootstrap-server localhost:9092
# 프로듀서 콘솔 실행
$ ./kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092
# 다른 창에서 컨슈머 콘솔 실행 (시작부터 읽어오기)
$ ./kafka-console-consumer.sh --topic quickstart-events --bootstrap-server localhost:9092 --from-beginning
# 토픽 삭제
$ ./kafka-topics.sh --delete --topic quickstart-events --bootstrap-server localhost:9092
```

## usage
```shell
$ curl -X 'POST' \
  'http://localhost:8000/user-service/users' \
  -H 'Content-Type: application/json' \
  -d '{
  "email": "string@string.com",
  "name": "string",
  "pwd": "stringst"
}'

$ curl -XPOST http://localhost:8000/user-service/login -H 'Content-Type: application/json' \
  -d '{
  "email": "string@string.com",
  "password": "stringst"
}'

$ curl -v http://localhost:8000/user-service/users -H 'Content-Type: application/json' \
  -H 'Authorization: Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiI1OTA2ZGU5Zi1lMDVkLTRkN2MtOTQ2ZS1jZDA3NDU3ZGI1YTgiLCJleHAiOjE3MzYyMTczMTUsImlhdCI6MTczNjEzMDkxNX0.7Rd4lrzJBbbxQo0xl0X_XPwtFSB68XXxk91WV5ZNHeO_6fktDH3TZkCf-g1gsGZc'

$ curl -XPOST -v http://localhost:8000/order-service/5906de9f-e05d-4d7c-946e-cd07457db5a8/orders -H 'Content-Type: application/json' \
  -H 'Authorization: Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiI1OTA2ZGU5Zi1lMDVkLTRkN2MtOTQ2ZS1jZDA3NDU3ZGI1YTgiLCJleHAiOjE3MzYyMTczMTUsImlhdCI6MTczNjEzMDkxNX0.7Rd4lrzJBbbxQo0xl0X_XPwtFSB68XXxk91WV5ZNHeO_6fktDH3TZkCf-g1gsGZc' \
  -d '{
  "productId": "CATALOG-001",
  "qty": "5",
  "unitPrice": "1500"
}'
```
