<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [Appendix-B 코틀린 코드 문서화](#appendix-b-%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%BD%94%EB%93%9C-%EB%AC%B8%EC%84%9C%ED%99%94)
  - [B.1 코틀린 문서화 주석 작성](#b1-%EC%BD%94%ED%8B%80%EB%A6%B0-%EB%AC%B8%EC%84%9C%ED%99%94-%EC%A3%BC%EC%84%9D-%EC%9E%91%EC%84%B1)
  - [B.2 API 문서 생성](#b2-api-%EB%AC%B8%EC%84%9C-%EC%83%9D%EC%84%B1)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# Appendix-B 코틀린 코드 문서화

## B.1 코틀린 문서화 주석 작성

코틀린 문서화 주석의 형식은 JavaDoc 처럼 KDoc 이라고 부릅니다.

케이독은 /** 으로 시작하고, 자바독과 다르게 HTML 이 아니라 Markdown 문서 작성 형식을 사용합니다.

```kotlin
/**
 * 두 수 [a] 와 [b] 의 합계를 계산한다.
 */
fun sum(a: Int, b: Int) = a + b
```

선언을 참조하고 싶다면 각괄호 사이에 이름을 넣습니다. 소스코드에 임포트된 상태라면 짧은 이름을 그냥 사용해도 되지만 임포트 되지 않은 상태라면 완전한 이름을 사용해야 합니다.

인용한 이름과 연결하는 링크에 이름을 붙이고 싶다면 각괄호를 2번 사용해야 합니다.

[an example][com.mycompnay.SomthingTest.simple] 처럼 첫번째는 표시할 링크, 두번째는 가리키려는 대상의 이름

```kotlin
/**
 * 복잡한 연산을 수행한다.
 * 
 * @param true 이면 연산을 원격에서 실행한다.
 * @return 연산을 수행한 결과
 * @throws IOException (원격 연결에 실패 시)
 * @sample com.mycompany.SomethingTest.simple
 */
fun somethingComplicated(remote: Boolean): ComplicatedResult { ... }
```

@ 으로 시작하는 태그를 사용할 수 있습니다.

자바독에는 없는 개념에 대한 새로운 태그도 지원합니다. @receiver 태그는 확장 함수나 프로퍼티의 수신 객체를 문서화하는 태그입니다.

## B.2 API 문서 생성

코틀린의 문서 생성 도구는 도카 Dokka 입니다. https://github.com/kotlin/dokka

커맨드라인에서 도카를 실행할 수도 있고, 빌드 스크립트를 통해서 실행할 수도 있습니다.
