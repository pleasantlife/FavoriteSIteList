# Google I/O Recap 2018

# Google I/O 2018 최신기술 총정리

 ## 들어가기에 앞서.
 - 활성화된 기기가 2 billion
 - #IMAKEAPPS campaign : g.co/play/imakeapps
 - 영감이 떠오르면 1주일만에 앱으로!
 - 7,000명 이상 참석, 100건 발표, 200개의 세션비디오


# Android App Bundle
 - 앱 용량이 클수록 성공률은 낮아진다.

 - 안드로이드 앱 번들에 올리면 기기에 맞게 APK 최적화!


# 모바일 개발자를 위한 I/O 2018 : Android의 새로운 기능 소개 

    
    # 빠른 개발, 효율적인 배포, 

    ## Innovative Distribution

    - Android에서 앱 용량이 커질 수록 다운로드율은 낮아진다.
    - Android App Bundle을 통해 배포 용량을 줄일 수 있다.
    - App Bundle에 올리기만 하면, 자동으로 만들어줌.

    ## Faster Development

    - Android Jetpack : 라이브러리, 데이터 바인딩 등의 집합.
    - UI 흐름을 볼 수 있는 라이브러리가 안드로이드 스튜디오에 통합.

    ## Increased 

     - Android slices : 안드로이드 P에 포함된 기능.
     - Android P : App Actions 지정. actions.xml에 기록 하면 가능함.
     -  
    
    - 35%의 전문 개발자가 코틀린 사용중. 매달 증가추세.

    ## 코틀린

    - 70만명 이상 사용중
    - 스택에 1만 4천명
    - KotlinConf 2017 개최.
    - Kotlin Nights 
    - 전체 사용자의 2%가 국내 사용자.
    - 주로 모바일과 web back-end에 사용.
    - ios,windows,macOS : Kotlin/Native, front-end : Kotlin/JS


# Android P 최신 기능 소개

## Android P
 - 올해 가을(3분기) 출시 예정.

## Android P 하이라이트
 - Adaptive Battery : 머신러닝으로 기기의 배터리 성능 향상!
 - Adaptive Action : 머신러닝으로 사용자에게 더 나은 경험 제공!
 - Slices

### Adaptive Battery
 - Doze / Battery Saver + Background Restrictions(Android P) / App Standby Buckets(앱을 얼마나 많이 사용하는가, Android P)
 
 - Active / Working Set / Frequent / Rare 단계로 앱의 상태를 구분함.
 - High Priority FCM은 아예 못받는게 아니라, Rare에 걸려있는 앱들은 Normal Priority로 처리하게 됨.

 - Background Restricton : 유사한 앱에 비해 배터리 소모가 높은 앱(Bad Behavior)을 사용자가 선택해서 기능을 활성화. -> 앱실행은 가능하지만, 백그라운드에서 일어나는 모든 작업, Foreground 서비스 작동 안됨.
 - 내 앱이 배터리를 얼마나 잘 사용하는지는 'Android Vital'에서 확인 가능.

## App Actions & Slices

 - 굉장히 많은 안드로이드 앱의 기능을 사용하기 위해서는 앱을 실행해야 함. -> 앱의 주요 기능을 바로 실행시킬 수 있는 단축키를 단다면? -> App Actions!
 - 구글 검색, 모든 앱 보기 등의 특정 동작에 특정앱이 하는 일을 따로 버튼처럼 빼낼 수 있음.
 - Built-In Intents : 기존의 Intent와 유사. 사용자들이 할법한 Use-Case를 Intent로 정의하여 앱에서 사용할 수 있도록 함.
 - Slice : App Actions이 버튼 형태로만 제공한다면, 앱에서 제공하는 컨텐츠나 UI를 앱 밖에서 사용할 수 있게 함.
 - Slice는 위젯과 달리 템플릿을 제공. SliceProvider와 Builder를 이용해서 제작 가능. (노티피케이션과 유사.)


## Notification

 - MessagingStyle 지원. : 더 많은 공간, 더 자연스러운 애니메이션, 이미지와 스티커 지원
 - SmartReplies
 - Notification Blocking : Notification Channel을 여러개로 나누어 블로킹을 막아라!

## Display Cutout
 - 노치 공식 지원 : 이미 시장에 노치 디바이스가 많이 있고, 앞으로 더 늘어날 계획이기 때문.
 - 만약에 하드코딩된 상태바를 갖고 있다면 노치가 문제가 될 수 있음. -> 하드코딩 쓰지 마!
 - 기본적인 액티비티에는 문제가 없으나 풀 스크린은 컨텐츠가 잘릴 수 있음. -> Default 동작은 노치 높이만큼 디스플레이 컷아웃을 함.,].,,
 - WindowInsets
 - 에뮬레이터에서 노치 테스트 가능.

## Private API 사용 금지
## Google Play Target SDK Rules : Target APK 26이상만 신규 등록 가능(8월~), 기존앱 업데이트시 26이상만 업데이트 가능(11월~)
## 에뮬레이터 속도 향상.
## ChromeOS에서 Android Studio 구동 가능(예정)



# APP Bundle

## 앱 번들 포맷
 - Asset Targeting : 언어, 텍스처, 그래픽 API 버전
 - assets/<name>#<key>_<value>/ 형태의 xml 파일로 저장됨.

## Serving
 - Split apks : 롤리팝 때 도입. 하나의 APK로 여러개의 기기를!
 - 여러개의 apk를 만들필요 없이 하나만 만들면 플레이스토어에서 알아서 사용자에게 맞는 apk(언어, 사양, 해상도 등)를 찾아줌.

## Size Savings
 -  캐너리에서 앱 번들을 완전히 지원하고 있음.
 - Generated Signed APK를 만드는 것과 거의 동일하게 App Bundle을 만들 수 있음.
 - Gradle Android Plugin으로 자동화 배포도 가능?!
 - Bundle Explorer를 통해 용량을 얼마나 줄였는지 확인할 수 있다.


## Signed and ready for publishing
 - Bundle에서 split에 대한 금지사항을 설정할 수도 있음.
 - 테스트는 어떻게 할 수 있나? : apk를 안드로이드 스튜디오로 바로 만들 수 있다.
 - 최종사용자버전의 apk를 만들고 싶다면 : BundleTool 사용

## Modularzation

 - 몇명이나 사용하느냐, 이 기능이 공간을 얼마나 차지하느냐, 로딩시간이 있어도 괜찮은 기능인가의 여부를 판단해야함.


# 빠르고 세련된 안드로이드

## Layout Inspector 통합
## Systrace : 안드로이드 스튜디오내에서 프로파일링 관련 작업 수행
## Memory Tracking : DDMS 시스템에서 관리하던 대신, 따로 분리되어 안드로이드 스튜디오에 통합.
## Layout Design : XML을 하드코딩 하던 대신 툴을 적극 활용해야 함.(Coordinator Layout) 
## Kotlin : Java보다 간결해진 코드. ( Style & Interop guide : https://android.github.io/kotlin-guides), LINT로 검증 가능.

## Layout
 - AbsoluteLayout 절대 쓰지말 것! (다양한 해상도를 모두 대응하기 어려움.)
 - LinearLayout : 간단한 경우에 한해 OK.
 - ConstraintLayout 2.0 출시 예정(애니메이션 적용까지 가능해질 것)

## 액티비티
 - 액티비티는 가능하다면 하나만 만들 것!
 - Navigation Component를 활용할 것. (최근 릴리즈)

## Architecture

 - Architecture Library를 통해 어떤 아키텍처를 사용하는게 좋은지 가이드를 제공.(강제는 아님!)
 - LifeCycle Components를 통해 Lifecycle 상태를 받을 수 있음. (LifeCycleOwner)

## Android Jetpack

  - 라이브러리와 툴에 대한 가이드라인
  - AndroidX : Android Extension. 안드로이드 Support Library의 발전 단계. 세분화하여 사용 가능. 메이저 버전간의 호환 100%.
  - AndroidX의 마이그레이션은 안드로이드 스튜디오 3.2 캐너리 내의 Refactor 메뉴에서 제공.
  - Jetifier : 기존의 서브파티 라이브러리도 AndroidX에서 사용 가능하도록 변경해줌.
