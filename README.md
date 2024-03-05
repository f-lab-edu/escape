# escape
방탈출 커뮤니티

---
## 개발 환경
> - 개발자 환경
>   - IDE: IntelliJ IDEA
>   - OS: Mac OS
> - Server
>   - CentOS 7
>   - JDK 17
>   - MySQL 8.0
>   - Spring Boot 3
>     - JPA

---

## 빌드 및 실행하기
### 터미널 환경
- Git, Java 는 설치되어 있다고 가정한다.
```
// 프로젝트 clone
$ git clone https://github.com/f-lab-edu/escape.git
$ cd escape

// 서브모듈 clone - 보안 설정 파일
$ git clone --recurse-submodules https://github.com/boradol/escape-properties.git ./src/main/resources/config/

// 빌드
$ ./gradlew clean build

// 실행
$ java -jar build/libs/escape-0.0.1-SNAPSHOT.jar
```

## 요구사항
[요구사항 정리 Notion 링크](https://tangy-orchid-a37.notion.site/F-lab-d818c53177b744a89cc28450884af99a?pvs=4)

### 서버구성
NCP(Naver Cloud Platform)를 활용한다.
1. 어플리케이션 서버
   - [MICRO]1vCPU, 1GB Mem[g1], 50GB HDD
   - CentOS 7
1. DB 서버
   - Cloud DB for MySQL (MySQL 8.0.25)
1. Jenkins 서버
   - [Standard] 2vCPU, 4GB Mem, 50GB Disk [g1]
   - CentOS 7
     - Jenkins 2.440.1
     - Java 17
