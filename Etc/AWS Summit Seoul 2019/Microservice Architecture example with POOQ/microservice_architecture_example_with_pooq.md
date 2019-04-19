#국내 미디어 고객사의 AWS 활용 사례 - POOQ서비스 그리고 마이크로서비스 아키텍처, 콘텐츠연합플랫폼
 - 콘텐츠연합플랫폼 박영순 부장

## POOQ 서버 아키텍처에 대한 소개 
 - 2017년 1분기부터 전체 서비스를 AWS로 사용
 - 2018년 1분기 Kubernetes 기반으로 마이크로 서비스 운영 시작
 - 현재 API 서버와 Streaming 서버를 따로 두고 운영중 

## Kubernetes 도입 전 이슈들
 - 배포 이슈 : 한 번 배포하는데 30분. 문제가 생겨서 원복하려면 또 30분 소요.
 - 배포 이슈 : 너무 많은 어플리케이션들이 얽혀있어서 하나의 어플리케이션만 업데이트해도 매번 전체적인 QA를 진행해야 함.
 - 오토스케일링 이슈 : '방송' 특성상 서비스 이용량의 변화속도가 너무 빨라 Auto Scaling으로 대응하기 어려움
 - 버전 관리 이슈 : 모바일, IPTV, 크롬캐스트, 스마트TV, 태블릿, PC 등 다양한 디바이스를 지원하기 위해 API를 유지하여 운영에 많은 자원 투입

## 마이크로 서비스 솔루션 선정 
 - T2 Unlimited + Auto scaling group / Docker Swarm / Kubernetes 중 1개 솔루션 사용 검토
 - Kubernetes 최종 선택

## API 게이트웨이 솔루션 선정
 - API 서비스 개수 분리 필요
 - GET/POST와 같은 HTTP 메소드 구분 지원, 자동화를 위한 HTTP REST API 지원 필요
 - AWS API Gateway / Nginx / Nginx ingress / Kong 중 1개 솔루션 검토
 - Kong 최종 선택 

## 콘텐츠 데이터 이용 구조
 - Kettle을 이용하여 사전에 분산된 Collection을 생성함으로 RDBMS 부하 감소
 - Redis Cache를 사용하여 반응속도를 향상 시키고, MongoDB의 부하도 감소

## 소스 관리 및 CI/CD
 - Github에 올리면서 너무 많은 레포지토리 사용
 - 프로젝트 개수가 증가하면서 Github + Jenkins 구조 개선이 필요
 - 커스텀이 가능하고 AWS VPC 내부에서 사용가능한 Gitlab Pipeline으로 교체

## Staging 환경 구성
 - 별도의 DNS 서버 구축
 - Nginx Proxy로 CloudFront 동작 구성

## 여유 Node 준비
 - Node 증설에는 5~10분 정도 소요되는데, 서비스 이용량의 변화속도에 대응하기 어려운 시간이라 미리 여유 있는 Node를 만들어둠
 - 낮은 우선순위를 가지는 Pod를 이용

## 로그 수집 및 분석
 - ELK (ElasticSearch + Logstatsh + Kibana) 구성하여 사용

## 기타 구성에서의 문제 해결
 - Kops의 Github 프로젝트 문서가 잘 되어 있어 해당 문서를 최대한 따라감

## 관제 포인트
 - 오픈소스인 Prometheus 이용하여 502 Bad Gateway 응답코드 발생 건수 감시

## POD 자원할당 변경
 - 고용량/소수의 POD 사용에서, 저용량/다수의 POD 사용으로 변경

## EC2 모델 변경
 - 메모리에 최적화된 R타입 모델로 변경

## DNS 사용 개선
 - 내부 API Gateway 연결에 Kubernetes Cluster Domain 사용 구조로 변경
 - 내부 ELB 및 Route53 미사용으로 응답속도 및 안정성 향상

## Pod 생성 실패 이슈 대응
 - Gitlab Group 변경 Deploymenet의 신규 Pod 생성 실패 : Container 빌드 및 Deployment 재 배포
 - Node.JS Deployment 신규 Pod 생성 실패 : npm start 명령어를 node index.js로 변경 후 재 배포

## 향후 업그레이드 예정 내역
 - Kubernetes 업그레이드 : CloudFront의 Origin 변경, 서비스 무정지로 업그레이드 진행 (주간 업그레이드 가능!)
 - Amazon EKS 도입 : 신규 기능을 위해 최신 버전 사용
 - Istio 도입 : 모든 서비스 API 입력과 출력에 대한 상태 수집 및 제어
 - Auto Scaling 조건 다양화
 - StatefulSets 운영 분리
 - Node 운영 방법 변경 : AWS Farget, Spot를 같이 사용하여 운영의 유연성 확보
 - 
