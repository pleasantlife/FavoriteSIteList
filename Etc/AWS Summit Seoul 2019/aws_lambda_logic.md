# AWS Lambda 내부 동작 방식 및 활용 방법 자세히 살펴보기
 - 람다는 어떻게 만들어졌을까?
 - 람다 트러블 슈팅!


## 람다 서비스를 직접 만든다면??!!
 - Front End Invoke : 동기, 비동기 호출을 모두 관장 
 - Counting Service : 사용자가 얼마나 많은 API 요청을 하는지 모니터링하고 제한기능 제공
 - Worker Manager : 실제 Container의 상태를 관리하고 API 요청을 가용 가능한 Container로 중계
 - Worker : 고객 함수(코드)가 안전하게 실행되는 실제 Container 환경
 - Placement Service : Worker에 Sandbox 구성을 자원 활용률이 높고, 고객 서비스 영향이 없도록 관리

### 람다 서비스를 위해 필요한 기능
 - Load Balancing
 - Auto Scaling
 - Handling Failures : 항상 가용한 호스트 사용
 - Isolation : workload(==function==code)는 항상 안전한 환경에서 실행

## 트러블 슈팅 람다

### Container 당 하나의 connection만 사용
 - Connection Pool SIze = 1로 설정
 = Handler 밖에 Global section에 DB Connect 객체를 생성하여 재활용

 ### Concurrency 제한
  - 스로틀링을 통해 함수 Concurrency 제한
  - 장점 : Lambda의 동시 실행은 account와 function 레벨 모두 제한 가능(AWS Support로 Account 제한 요청해야 함)

## 트레이싱

 ### 트레이싱이 필요한 이유
  - 서버리스 아키텍쳐/어플리케이션 개발 시 디버그 편의성

## 람다 커스텀 런타임 사용

