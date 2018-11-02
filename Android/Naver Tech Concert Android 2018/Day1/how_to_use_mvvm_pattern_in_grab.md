Grab에서는 어떻게 MVVM을 사용하고 있는가? : Grab 정승욱 (GDE Singapore)

0. MVVM과 Grab 아키텍처
 1) 5월 드로이드 나이츠 강연 : MVVM에 대해 이해한다고 전제하고 내용을 공유 => 폭망!
 2) MVVM에 대한 한글 예시(블로그)가 잘못되어있음 => MVVM에 대한 이해를 잘못하고 있음.

1. ViewModeL?
 - i/o 17에서 Architecture Component 데뷔
 - MVVM은 AAC의 ViewModel과 연관성이 없다. 
 
 1) 구글에서의 의미
   - Activity/Fragment의 Lifecycle 의존성 낮추는 것
   - LiveData는 Repository로부터 데이터 변화 반응/적용
  => View에 필요한 데이터를 관리하기 위함

 2) MVVM에서의 의미
    - View와 ViewModel의 연결 최소화
    - View는 화면 정보의 변화를 ViewModel에 전달(하되 최소화)
    - View는 XML 이지만 Activity/Fragment가 아니다
    - 결국 데이터바인딩이 필요하다. == MVVM의 핵심은 데이터바인딩

  3) MVVM을 올바로 이해하려면?
    - 구글 문서가 아니라 마이크로소프트 닷넷 문서를 확인해야 함
    - MVVM

2. RxLifecycle

3. View 변화 감지
 - ResourceProvider
 - RxLifecycle
 - Activity Result : ResultManager

4. Activity의 역할! 
 - 데이터바인딩을 하고, MVVM을 실천하니 껍데기만 남은 Activity
 - View에 대해 다시 생각하기

5. 정리
- View는 XML
- Databinding은 MVVM 구현의 필수요소
- 감지하기 어려운 뷰의 변화는 ViewUseCase
- LifeCycle과 Result(setResult)의 처리를 위한 접근 필요




