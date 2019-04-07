# Droid Knights 2019

## 2. Master of Android Theme - Yusuke Knishi(Github/@konifar)


### Android Theme Overview
 - Style과 기술적으로는 같다.
 - 다만 테마는 글로벌, 스타일은 로컬!

### 테마의 문제점 
 - 안드로이드 스튜디오가 가진 테마가 너무 많다!
 - 안드로이드 내의 attributes가 너무 많다!

### 그래서!
 - 테마 적용
  > 우리가 어떤 테마를 가져와야 하나?
  > 어떻게 테마를 상속받고 관리하나?
  >
 - Theme Attributes 
  > 어떤 어트리뷰트가 어디에 영향을 미치나?
  > AppCompat과 Material 요소에 대한 attribute를 어디에서 모두 찾을 수 있을까?


### Apply Theme
 - themes.xml에서 테마 등록.
  >dot 스타일(Theme.AppCompat.Light)
  >parent 스타일
  <parent = Theme.AppCompat.Light>
 - 테마 네임 룰
  > Prefix.Theme(Library)name.Backgroundbrightness.(없을 수도 있음)Actionbarbrightness.Bridge
  > 예시 : Theme.AppCompat.Light.DarActionBar

 - 코드상에서 테마 변경하기 
  > 액티비티 : setTheme() 메소드 사용
  > 프래그먼트 : contextThemeWrapper 이용
 
 - DaynightMode 
  > values 폴더와 values-night 폴더가 별도로 존재
  > setLocalNightMode(mode)로 코드상에서 변경 가능

### THeme Attributes
 - Android Framework, AppCompat, MaterialComponents에서 Attributes들을 찾을 수 있지만 어려워!
 
 ### 카테고리별 attributes 분류
  - Colors
  - Drawables
  - Text Apperances
  - Shape apperaances
  - Widget Styles
  - Themes
  - Window configurations


