코루틴 적용 및 ReactiveX(RxJava)와 비교 : 김태환 요기요


코루틴? : Kotlin coroutines

subroutines?
 - 정말 자주 쓰는 함수! 언어별로 불리는 이름이 다양해서 서브루틴으로 통칭함.
 - subroutine의 return이 불러지기 전까진 함수의 다음줄이 실행되지 않는다.

coroutine?  
 - 여러개의 엔트리포인트를 허용하는 subroutine
 - 언제든 일시 정지하고 다시 실행 가능
 - event loops, iterators, 무한 리스트, 파이프 같은 것을 구현하는데에 적합

RxJava vs coroutines
 
 RxJava
 - Observable과 Streams
 - 기존 Thread보다 간단한 코드로 처리
 - stream을 통해 데이터 처리 용이
 - Thread간 교체 간단
 - RxJava를 활용한 수 많은 라이브러리 활용 가능 == 예제도 많고, 문서가 잘 되어 있다.

 - 러닝 커브가 높음 == 학습비용이 높다.

 Kotlin routines
  - 처음 학습 비용이 낮다.
  - 아직은 부족한 라이브러리 (직접 만들 수 있고, 문서도 잘 되어 있다)
  - 다양한 언어에서 제공하던 주요 라이브러리 제공
  - Kotlin으로 할 수 있는 다양한 platform 제공


 Blocking과 non-BLocking in Kotlin
  Thread.sleep() : Thread 처리 전까지 Main Thread가 멈춘다
  delay : 별도의 coroutine에서 동작하여 멈추지 않고 넘어간다
 
 run BLocking
  - delay를 이용해 non-blocking을 할 수 있음
  - 안드로이드에서 runBlocking을 UI에서 잘못 사용하면 멈추는 현상 발생

  coroutine 사용시 주의점
   - Activity/Fragment 라이프사이클에 따라야 함
   - onDestroy()에서 cancel하도록 코드 추가
   