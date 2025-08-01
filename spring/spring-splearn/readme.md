[토비의 클린 스프링 - 도메인 모델 패턴과 헥사고날 아키텍처 Part 1](https://www.inflearn.com/course/%ED%86%A0%EB%B9%84-%ED%81%B4%EB%A6%B0%EC%8A%A4%ED%94%84%EB%A7%81-%EB%8F%84%EB%A9%94%EC%9D%B8%EB%AA%A8%EB%8D%B8%ED%8C%A8%ED%84%B4-%ED%97%A5%EC%82%AC%EA%B3%A0%EB%82%A0-part1)

# 도메인 모델

## 도메인 모델 만들기

1. 듣고 배우기
2. '중요한 것'들 찾기 (개념 식별)
3. '연결 고리' 찾기 (관계 정의)
4. '것'들을 설명하기 (속성 및 기본 행위 명시)
5. 그려보기 (시각화)
6. 이야기 하고 다듬기 (반복)

## Splearn 도메인

* 스프런은 회원이 강의를 수강하는 온라인 서비스이다.
* 스프런은 스프링 프레임워크의 철학을 바탕으로 개발되고 운영되며 발전하는 학습 생태계를 목표로 한다.
  이 생태계를 구성하는 핵심 구성 요소는 학습(성장)하는 회원이다.
  * 그래서 이름이 Spring + Learner = Splearn
  * 유사한 이름으로 인프런이 있다.
* 스프런에서 활동하기 위해서는 회원으로 등록해야 한다.
  * 다만, 회원이 되기 전에도 스프런에 대한 소개와 강의 정보를 살펴볼 수 있다.
  * 강의를 수강하기 위해서는 등록을 완료하고 활동 가능한 회원이 되어야 한다.
  * 등록 신청을 한 뒤 정해진 요건을 충족하면 등록이 완료된다.
  * 등록을 완료한 경우에 프로필 주소, 자기 소개를 등록하거나 수정할 수 있다.
    * 프로필 주소는 알파벳과 숫자로 구성된 15자리 이내의 중복되지 않은 값
    * 탈퇴한 회원의 프로필 주소와 자기 소개는 수정할 수 없다.
  * 등록 시간, 등록 완료 시간, 탈퇴 시간을 저장한다.
* 원하는 회원은 자신이 가진 지식과 경험을 강의라는 형태로 다른 회원에게 제공하는 강사가 될 수도 있다.
  * 회원이 최초로 강사가 되려면 강사 신청과 승인 과정을 거치도록 한다.
  * 승인된 강사는 강의를 생성하고 검수를 거쳐 강의를 공개할 수 있다.
  * 공개된 강의는 회원에게 노출되고, 회원은 이 강의를 수강할 수 있다.
* 수강은 강의를 학습하는 것을 말한다. "내가 수강한 강의는 a이다. 나는 b 강의 수강중이다."
  * 수강을 위해서는 먼저 수강 신청이 필요하다.
  * 수강 신청은 강의의 수강 요건에 따라서 신청을 해야 하고 이후 추가 절차가 요구될 수 있다.
  * 일부 강의는 수강 신청과 동시에 수강이 가능하다.
  * 어떤 강의는 수강 신청후 강의비 결제를 완료해야 수강이 가능하다.
  * 강사는 강의 수강 기간의 제한을 둘 수도 있다.
* 강의는 영상, 문서와 같은 컨텐츠를 가진 하나 이상의 수업으로 구성 된다.
  * 수업은 갯수가 많을 수 있다. 그래서 수업은 다시 섹션으로 구분한다.
  * 하나의 강의는 여러 개의 섹션과 각 섹션에 속한 수업으로 구성된다.
  * 수업과 섹션은 학습 순서를 가진다.
  * 학습 진도는 매 수업 단위로 기록된다.
  * 강의의 모든 수업의 학습을 마치고 수업 진도가 100%에 도달하면 강의 수강을 완료한 것이다.

## Splearn 도메인 모델

---
### [회원 애그리거트]

### 회원 (Member)
_Aggregate Root Entity_
#### 속성
- `id`: `Long`
- `email`: 이메일 - ID
- `nickname`: 닉네임
- `passwordHash`: 비밀번호 해시
- `status`: `MemberStatus` 회원 상태
- `detail`: `MemberDetail` 1:1 관계
#### 행위
- `static register()`: 회원 등록: email, nickname, password, passwordEncoder
- `activate()`: 등록을 완료 시킨다
- `deactivate()`: 탈퇴한다
- `verifyPassword()`: 비밀번호를 검증한다
- `changeNickname()`: 닉네임을 변경한다
- `changePassword()`: 비밀번호를 변경한다
- `updateInfo()`: 회원 상세 정보를 수정한다
#### 규칙
- 회원 등록 후 상태는 등록 대기 상태
- 일정 조건을 만족하면 등록 완료가 된다
- 등록 대기 상태에서만 등록 완료가 될 수 있다
- 등록 완료 상태에서 탈퇴할 수 있다
- 등록 완료 상태에서만 회원 정보를 수정할 수 있다.
- 회원의 비밀번호는 해시를 만들어서 저장한다
- 프로필 주소는 중복을 허용하지 않는다. 기존 프로필 주소를 제거할 수는 있다.

#### 회원 상세(MemberDetail)
_Entity_
- `id`: `Long`
- `profile`: 프로필 주소, 모든 회원이 고유한 프로필 주소를 가져야 한다.
- `introduction`: 자기 소개
- `registeredAt`: 등록 일시
- `activatedAt`: 등록 완료 일시
- `deactivatedAt`: 탈퇴 일시
#### 행위
- `static create()`: 회원 등록. 현재 시간을 등록 일시로 저장한다.
- `activate()`: 등록 완료와 관련된 작업 수행
- `deactivate()`: 탈퇴와 관련된 작업 수행
- `updateInfo()`: 프로필 주소와 자기 소개를 수정한다
#### 규칙


### 회원 상태(MemberStatus)
_Enum_
#### 상수
- `PENDING`: 등록 대기
- `ACTIVE`: 등록 완료
- `DEACTIVATED`: 탈퇴

### DuplicateEmailException
_Exception_

### 비밀번호 인코더(PasswordEncoder)
_Domain Service_
#### 행위
- `encode(String password)`: 비밀번호를 해시로 인코딩한다
- `matches(String password, String hash)`: 비밀번호가 일치하는지 확인

### 프로필 주소(Profile)
_Value Object_
#### 속성
- address: 프로필 주소
---

### 이메일 주소(Email)
_Value Object_
#### 속성
- address: 이메일 주소
---

### 강사

### 강의

### 수업

### 수강

### 섹션

### 진도

---

# Splearn 용어사전
| **한국어** | **영어**     | **설명**                                     |
|---------|------------|--------------------------------------------|
| 회원      | Member     | 스프런 서비스를 이용하는 사용자로 강의를 수강할 수 있다            |
| 강사      | Instructor | 강의를 만들고 제공하는 회원. 회원은 신청 과정을 통해서 강사가 될 수 있다 |
| 강의      | Course     | 특정한 주제를 학습하도록 설계된 교육과정. 여러 개의 수업으로 구성.     |
| 수업      | Lesson     | 강의를 구성하는 학습 단위. 영상과 문서 등으로 구성된다.           |
| 수강      | Enrollment | 회원이 강의를 학습하는 것. 수강 신청을 통해서 수강할 수 있다.       |
| 섹션      | Section    | 강의를 세부 주제별로 나눈 중간 단위                       |
| 진도      | Progress   | 하나의 강의 내에서 얼마나 학습을 완료했는지를 나타내는 학습 상태 정보    |

---

# Splearn 개발 가이드

## 아키텍처
- 헥사고날 아키텍처
- 도메인 모델 패턴

### 계층
- Domain Layer
- Application Layer
- Adapter Layer

> 외부(Actor) -> 어댑터 -> 어플리케이션 -> 도메인

## 패키지
- domain
- application
  - required
  - provided
- adapter
  - webapi
  - persistence
  - integration
  - security
