Efficent and Testable MVVM : 레이니스트 김범준


1. 안드로이드에 존재하는 아키텍처
 - MVC, MVP, VIPER, MVI, MVVM

2. MVVM
 - Model View ViewModel
 - MVP에서는 프레젠터가 뷰에 대한 의존성을 가지고 있으나
   데이터바인딩을 통해 뷰에 대한 의존성 제거.
 1) 뷰모델은 뷰의 추상황디ㅏ.
  - 사용자의 행동에 따라 항상 같은 결과가 나타나게 된다.
  - 아웃풋은 뷰의 상태와 라우트 로직으로 나뉘게 된다.
 2) 뷰와 뷰모델은 n:M의 관계
  - 재사용성의 용이
 3) View는 ViewModel에 bindable하다.
  - 뷰와 뷰모델을 서로 연결하는 것
  - 사용자의 행동에 의해 입력을 받았을 때 (View -> ViewModel)
  - 사용자의 행동에 따른 View의 상태를 변경시켜야 할 때 
 
 4) 결론
  - 뷰에 대한 의존성 제거로 효과적으로 역할과 책임을 분담 가능
  - 단독테스트 가능하여 테스트의 용이성 증가
  - 개발자가 상태를 관리해야 하는 위험 / 보일러플레이트코드 감소

3. MVVM을 어떻게 구현할 것인가?
  - 클린 아키텍처 지향
  - Koin을 사용하여 IOC(Inversion Of Control)구현 (in Kotlin)
  - Spek을 사용하여 행동 주도 결과 테스트를 작성 (in kotlin)

4. Koin?
  - Dagger보다 사용하기 쉽고 가벼움  
  - 제어의 역전을 구현할 수 있게 도와주는 라이브러리
  - 코틀린으로 구현되어 있음
  - 간편한 사용 방법을 지원, AAC 지원
  - 제어의 역전을 Service Locator 방식으로 구현 (Runtime에서 에러 확인 가능)
