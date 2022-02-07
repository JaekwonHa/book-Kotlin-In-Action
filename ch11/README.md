<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [11장 DSL 만들기](#11%EC%9E%A5-dsl-%EB%A7%8C%EB%93%A4%EA%B8%B0)
  - [11.1 API 에서 DSL 로](#111-api-%EC%97%90%EC%84%9C-dsl-%EB%A1%9C)
    - [11.1.1 영역 특화 언어라는 개념](#1111-%EC%98%81%EC%97%AD-%ED%8A%B9%ED%99%94-%EC%96%B8%EC%96%B4%EB%9D%BC%EB%8A%94-%EA%B0%9C%EB%85%90)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# 11장 DSL 만들기

다루는 것

* 수신 객체 지정 람다
* invoke 관례

## 11.1 API 에서 DSL 로

클래스에 있는 코드 중 대부분은 다른 클래스와 상호작용 합니다. 이런 상호작용을 이해하기 쉽고 명확하게 표현할 수 있어야 프로젝트를 계속 유지 보수할 수 있습니다.

깔끔한 코드를 작성하기 위해서 코틀린이 제공해주는 기능은 많습니다.

|일반 구문|간결한 구문|사용한 언어 특성|
|-------|--------|------------|
StringUtil.capitalizes(s)|s.capitalize()|확장 함수
1.to("one")|1 to "one"|중위 호출
set.add(2)|set += 2|연산자 오버로딩
map.get("key")|map["key"]|get 메서드에 대한 관례
file.use({ f -> f.read() })|file.use { it.read() }|람다를 괄호 밖으로 빼내는 관례
sb.append("yes"), sb.append("no")|with(sb) -> { append("yes"), append("no") }|수신 객체 지정 람다

코틀린 DSL 은 간결한 구문을 제공하는 기능과 구문을 확장하는 여러 메서드 호출을 조합함으로써 API 에 비해 더 표현력을 더 풍부하게 합니다.

```kotlin
// DSL 예시
val yesterday = 1.days.ago

fun createSimpleTable() = createHTML().
    table {
        tr {
            td { +"cell" }
        }
    }
```

### 11.1.1 영역 특화 언어라는 개념

우리는 컴퓨터가 발명된 초기부터 "범용 프로그래밍 언어"와 "영역 특화 언어"를 구분해왔습니다.

가장 익숙한 DSL 은 SQL 과 정규표현식일 것입니다. 이 두 언어는 데이터베이스 조작과 문자열 조작이라는 특정 작업에 가장 적합합니다.

DSL 은 범용 프로그래밍 언어와 달리 더 선언적 declarative 합니다. 범용 프로그래밍 언어는 명령적 imperative 합니다. 명령적 언어는 연산을 완수하기 위해 필요한 각 단계를 순서대로 정확히 기술하고, 각각 최적화 해야 합니다. DSL 은 원하는 결과를 기술하기만 하면 그 결과를 달성하기 위해 필요한 세부 실행은 엔진에 맡기고, 엔진이 최적화를 수행합니다.

DSL 의 단점은 범용 프로그래밍 언어로 만든 호스트 애플리케이션과 함께 조합하기 어렵다는 점 입니다. DSL 은 자체 문법이 있기 때문에 다른 언어의 프로그램 안에서 직접 포함시킬 수 없어서, DSL 로 작성한 프로그램을 별도의 파일이나 문자 리터럴로 저장해야 했습니다. 하지만 이런 방법은 컴파일 시점에 검증을 하거나 디버깅 하거나 IDE 기능을 사용하기 어려워 집니다.

이런 문제를 해결하기 위해 내부 internal DSL 이라는 개념이 유명해지고 있습니다.
