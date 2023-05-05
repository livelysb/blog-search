# 블로그 검색 시스템

## 활용 기술

- Spring Boot 3.0.6
- Java 17
- JPA
- H2
- Kafka

## ERD

### 작업내용

#### 작업완료
- 멀티 모듈 구성 및 모듈간 의존성 제약
  - blog-search-api
  - blog-search-consumer
  - blog-search-domain
  - blog-search-infra

- API 설계 (스웨거를 통한 API docs 제공)
- 예외 처리 및 API 응답 일관화
- 엔티티 작성 (데이터 타입, 인덱스, 유니크 고려)
- 서비스 로직 개발
  - 검색횟수 저장 및 인기검색어 조회
#### 작업예정

- 서비스 로직 개발
  - 카카오, 네이버 API를 활용한 검색
- 동시성 이슈
  - 키워드 별로 검색된 횟수의 정확도
- 서킷브레이커 적용
  - 카카오 블로그 검색 API에 장애가 발생한 경우, 네이버 블로그 검색 API를 통해 데이터 제공

### 테스트
- 레포지토리 테스트
- 단위 테스트
- 통합 테스트

### External Library
