# Droid Knights 2019

## 1. 동적 맵 프레임워크와 인터렉션 구현하기 - 정승욱(Grab/ medium.com/@jsuch2362)

### Grab 앱이 제공하는 맵
- 구글, 히어(by 노키아), 티맵

### Map SDK 초기화 구분(순서대로)
 - 기본 객체 초기화(context 전달, 리소스 경로 설정 등)
 - 리소스 다운로드(오프라인 지원을 위해)
 - 엔진 초기화
 - 초기화 완료 후 맵뷰 생성
 - 구글은 맵뷰 내에서 위의 과정을 모두 처리 (개발자 입장에서 굉장히 편하다!)

### SDK 초기화 조건
 - Application내에서 한번만 동작 
  > 화면 전환때마다 초기화시 에셋 다운로드 시도 가능
  > 불필요한 컴퓨팅 리소스 최소화
 - 에러시 다음 동작에 대한 영향도를 낮출 것
  > Fallback 동작 지원
 - 맵별 다양한 초기화 단계를 지원할 수 있어야 함
  > SDK 별로 다양화 지원

### 맵 SDK 초기화 구현    
 - MapAssetDownloader : 맵 리소스 다운로드
 - MapEngine : 맵 SDK 초기화
 - MapProvider : 맵뷰 바인딩 (다양한 인터렉션을 공통적으로 제공하기 위해 각 맵의 SDK 초기화를 Facade로 구성)

### SDK 초기화 해제
 - Map 타입을 바꿀 수 있으므로, Map SDK 초기화를 해제할 필요가 있다.(리소스)
 - swtichMap 오퍼레이터 : 상위에서 변경된 내용이 있을 경우, 새로운 Observe를 받아보게 함.
 - 도중에 오류가 발생했을 때 doOnError()를 통해 에러 체크, onErrorResumeNext()를 통해 에러시 로직 지정.

### 맵 인터렉션 관리하기 (화면에 어떻게 그려줄 것이냐! 제스쳐에 대한 반응은!)
 - 그랩에서는 인터렉션별로 구분해서 관리
 - 인터렉션의 종류
  > 카메라 액션(맵 이동 감지/맵 이동 지시)
  > 마커 관리(내 위치, 픽업 위치, 도착 위치, 추천 POI)
  > 테마 : 도로 색상 등
  > 폴리곤 : 경로 그리기
  > 맵 패딩 (맵이 들어가는 공간 구성)
  > 기타

### 맵 인터렉션 다이어그램  
 - MyMarkerBehavior -> MapInteractor -> MapView(Library)
 - Beheavior에서 Interactor에 어떻게 전달할 것인가? : MapBehaviorController 도입!
 - Behavior의 모든 정보를 Controller에 넣어서 캐싱하고 Behavior의 생명주기를 Controller가 관리하도록 함.

### 다른 곳에 응용하기 
 - 실시간 AB 테스트
  > AB테스트 변화 감지
  > AB 값 변화에 대응
 - 쇼핑 앱에서 장바구니 관리
  > Engine에서 카트 관리
  > Provider에서 리스트 제공
 - 상위단에서 데이터를 관리할 수 있음(가장 기본적인 활용) 
  > App Scope에서는 데이터 관리
  > Activity Scope에서는 상태에 따른 화면 관리(SingleTon으로 전달받은 정보를 활용)

### 주의 사항
 - 에러처리! (중간에 터지면 하위로직까지 다 터진다.)
 - init과 deInit처리
 - Clean Architecture 구현

### 질문
 - Fragment가 달라도 Behavior를 같은걸 들고 있을 수도 있을텐데?
  > 구글맵에서는 구글맵만을 위한 오브젝트를 던져주기 때문에 Interactor를 매핑하여 SDK에 종속된 Object들과 교류.
 - 맵 연산에 대한 리소스 관리는?
  > 따로 Callback을 달아서 불필요한 연산 없애기는 하지만, 맵 제조사가 얼마나 관리를 잘 하느냐에 달려있음.



 
