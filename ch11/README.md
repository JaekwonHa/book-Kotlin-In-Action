<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [11장 DSL 만들기](#11%EC%9E%A5-dsl-%EB%A7%8C%EB%93%A4%EA%B8%B0)
  - [11.1 API 에서 DSL 로](#111-api-%EC%97%90%EC%84%9C-dsl-%EB%A1%9C)
    - [11.1.1 영역 특화 언어라는 개념](#1111-%EC%98%81%EC%97%AD-%ED%8A%B9%ED%99%94-%EC%96%B8%EC%96%B4%EB%9D%BC%EB%8A%94-%EA%B0%9C%EB%85%90)
    - [11.1.2 내부 DSL](#1112-%EB%82%B4%EB%B6%80-dsl)
    - [11.1.3 DSL 의 구조](#1113-dsl-%EC%9D%98-%EA%B5%AC%EC%A1%B0)
    - [11.1.4 내부 DSL HTML 만들기](#1114-%EB%82%B4%EB%B6%80-dsl-html-%EB%A7%8C%EB%93%A4%EA%B8%B0)
    - [11.2 구조화된 API 구축: DSL 에서 수신 객체 지정 DSL 사용](#112-%EA%B5%AC%EC%A1%B0%ED%99%94%EB%90%9C-api-%EA%B5%AC%EC%B6%95-dsl-%EC%97%90%EC%84%9C-%EC%88%98%EC%8B%A0-%EA%B0%9D%EC%B2%B4-%EC%A7%80%EC%A0%95-dsl-%EC%82%AC%EC%9A%A9)
    - [11.2.2 수신 객체 지정 람다를 HTML 빌더 안에서 사용](#1122-%EC%88%98%EC%8B%A0-%EA%B0%9D%EC%B2%B4-%EC%A7%80%EC%A0%95-%EB%9E%8C%EB%8B%A4%EB%A5%BC-html-%EB%B9%8C%EB%8D%94-%EC%95%88%EC%97%90%EC%84%9C-%EC%82%AC%EC%9A%A9)
    - [11.2.3 코틀린 빌더: 추상화와 재사용을 가능하게 하는 도구](#1123-%EC%BD%94%ED%8B%80%EB%A6%B0-%EB%B9%8C%EB%8D%94-%EC%B6%94%EC%83%81%ED%99%94%EC%99%80-%EC%9E%AC%EC%82%AC%EC%9A%A9%EC%9D%84-%EA%B0%80%EB%8A%A5%ED%95%98%EA%B2%8C-%ED%95%98%EB%8A%94-%EB%8F%84%EA%B5%AC)
  - [11.3 invoke 관례를 사용한 더 유연한 블록 중첩](#113-invoke-%EA%B4%80%EB%A1%80%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%9C-%EB%8D%94-%EC%9C%A0%EC%97%B0%ED%95%9C-%EB%B8%94%EB%A1%9D-%EC%A4%91%EC%B2%A9)
    - [11.3.1 invoke 관례: 함수처럼 호출할 수 있는 객체](#1131-invoke-%EA%B4%80%EB%A1%80-%ED%95%A8%EC%88%98%EC%B2%98%EB%9F%BC-%ED%98%B8%EC%B6%9C%ED%95%A0-%EC%88%98-%EC%9E%88%EB%8A%94-%EA%B0%9D%EC%B2%B4)
    - [11.3.2 invoke 관례와 함수형 타입](#1132-invoke-%EA%B4%80%EB%A1%80%EC%99%80-%ED%95%A8%EC%88%98%ED%98%95-%ED%83%80%EC%9E%85)
    - [11.3.3 DSL의 invoke 관례: 그레이들에서 의존관계 정의](#1133-dsl%EC%9D%98-invoke-%EA%B4%80%EB%A1%80-%EA%B7%B8%EB%A0%88%EC%9D%B4%EB%93%A4%EC%97%90%EC%84%9C-%EC%9D%98%EC%A1%B4%EA%B4%80%EA%B3%84-%EC%A0%95%EC%9D%98)
  - [11.4 실전 코틀린 DSL](#114-%EC%8B%A4%EC%A0%84-%EC%BD%94%ED%8B%80%EB%A6%B0-dsl)
    - [11.4.1 중위 호출 연쇄: 테스트 프레임워크의 should](#1141-%EC%A4%91%EC%9C%84-%ED%98%B8%EC%B6%9C-%EC%97%B0%EC%87%84-%ED%85%8C%EC%8A%A4%ED%8A%B8-%ED%94%84%EB%A0%88%EC%9E%84%EC%9B%8C%ED%81%AC%EC%9D%98-should)
    - [11.4.2 원시 타입에 대한 확장 함수 정의: 날짜 처리](#1142-%EC%9B%90%EC%8B%9C-%ED%83%80%EC%9E%85%EC%97%90-%EB%8C%80%ED%95%9C-%ED%99%95%EC%9E%A5-%ED%95%A8%EC%88%98-%EC%A0%95%EC%9D%98-%EB%82%A0%EC%A7%9C-%EC%B2%98%EB%A6%AC)
    - [11.4.3 멤버 확장 함수: SQL을 위한 내부 DSL](#1143-%EB%A9%A4%EB%B2%84-%ED%99%95%EC%9E%A5-%ED%95%A8%EC%88%98-sql%EC%9D%84-%EC%9C%84%ED%95%9C-%EB%82%B4%EB%B6%80-dsl)
    - [11.4.4 안코: 안드로이드 UI를 동적으로 생성하기](#1144-%EC%95%88%EC%BD%94-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-ui%EB%A5%BC-%EB%8F%99%EC%A0%81%EC%9C%BC%EB%A1%9C-%EC%83%9D%EC%84%B1%ED%95%98%EA%B8%B0)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# 11장 DSL 만들기

다루는 것

* 수신 객체 지정 람다
* 일반 함수 타입, 확장 함수 타입
* invoke 관례
* 코틀린 DSL: should, with, 1.days.ago, primaryKey, autoIncrement

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

### 11.1.2 내부 DSL

독립적인 문법 구조를 가진 외부 DSL 과 반대로 내부 DSL 은 범용 언어로 작성된 프로그램의 일부입니다.

두 접근 방법을 비교하기 위해 SQL 과 코틀린 Exposed 프레임워크를 비교해보겠습니다.

```sql
SELECT Country.name, COUNT(Customer.id)
    FROM Country
    JOIN Customer
    ON Country.id = Customer.country_id
GROUP BY Country.name
ORDER BY COUNT(Customer.id) DESC
    LIMIT 1
```

```kotlin
(Country join Customer)
    .slice(Country.name, Count(Customer.id))
    .selectAll()
    .groupBy(Country.name)
    .orderBy(Count(Customer.id), isAsc = false)
```

SQL 로 작성하는 경우 보통 최선의 수단은 SQL 을 문자열 리터럴에 넣고, 작성과 검증을 IDE가 도와주기를 바랬습니다. 두번째 버전은 코틀린으로 작성하지만 프로그램을 실행하면 SQL 이 생성됩니다.

### 11.1.3 DSL 의 구조

DSL과 API 사이에 잘 정의된 일반적 경계는 없지만, API에 없는 DSL의 특징이 있다면 "구조 또는 문법"입니다.

전형적인 라이브러리는 여러 메서드로 이루어지고, 한번에 하나씩 호출하여, 함수 호출 시퀀스에는 아무런 구조가 없으며 호출 사이에는 아무 맥락이 존재하지 않습니다. 이런 API를 명령-질의 command-query API 라고 합니다.

DSL의 메서드 호출은 DSL 문법 grammer에 의해 정해지는 더 커다란 구조입니다. 코틀린 DSL 에서는 보통 람다를 중첩시키거나, 메서드 호출을 연쇄시키는 방식으로 구조를 만듭니다. 이런 메서드를 조합하는 구조는 메서드 호출 하나에 모두 넘기는 것보다 훨씬 읽기 쉽습니다.

코틀린 DSL 의 몇가지 예시를 보겠습니다.

```kotlin
project.dependencies.add("compile", "junit:junit:4.11")
project.dependencies.add("compile", "com.google.inject:guide:4.1.0")
// -> 람다 중첩 구조를 만들어서 코드 중복을 제거합니다.
dependencies {
    compile("junit:junit:4.11")
    compile("com.google.inject:guide:4.1.0")
}

assertTrue(str.startsWith("kot"))
// -> 중위 호출 구문을 사용하여 가독성이 좋아집니다.
str should startWith("kot")
```

### 11.1.4 내부 DSL HTML 만들기

HTML 페이지를 생성하는 코틀린 DSL 입니다.

```kotlin
fun createAnotherTable() = createHTML().table {
    val numbers = mapOf(1 to "one", 2 to "two")
    for ((num, string) in numbers) {
        tr {
            td { +"$num" }
            td { +string }
        }
    }
}
```

```html
<table>
    <tr>
        <td>1</td>
        <td>one</td>
    </tr>
    <tr>
        <td>2</td>
        <td>two</td>
    </tr>
</table>
```

HTML 을 코틀린 DSL 로 작성함으로써 얻는 장점이 있습니다.

* 코틀린은 타입 안전성을 보장합니다. td 를 tr 에서만 사용할 수 있고, 그렇지 않으면 컴파일 되지 않습니다.
* 코틀린 코드를 그대로 사용할 수 있습니다. 표를 동적으로 생성할 수 있습니다.

### 11.2 구조화된 API 구축: DSL 에서 수신 객체 지정 DSL 사용

buildString 함수 예제를 통해 코틀린이 수신 객체 지정 람다를 어떻게 구현하는지 살펴봅니다.

```kotlin
// version 1. 람다를 인자로 받음. 인자가 일반 함수 타입
fun buildString(
    builderAction: (StringBuilder) -> Unit
): String {
    val sb = StringBuilder()
    builderAction(sb)
    return sb.toString()
}

val s = buildString {
    it.append("Hello, ")
    it.append("World!")
}
```

```kotlin
// version 2. 수신 객체 지정 람다를 사용. 인자가 확장 함수 타입
fun buildString(
    builderAction: StringBuilder.() -> Unit     // 수신 객체가 있는 함수 타입의 파라미터를 선언
): String {
    val sb = StringBuilder()
    sb.builderAction()                          // StringBuilder 인스턴스를 람다의 수신 객체로 넘긴다
    return sb.toString()
}

val s = buildString {
    this.append("Hello, ")
    append("World!")
}
```

version2 에서는 파라미터 타입을 일반 함수 타입 대신 확장 함수 타입을 사용했습니다. `String.(Int, Int) -> Unit` String 은 수신 객체 타입, (Int, Int) 는 파라미터 타입, Unit 은 반환 타입입니다.

확장 함수는 람다 본문 안에서 그 수신 객체를 특별한 수식자 없이 사용할 수 있습니다. builderAction(sb) -> sb.builderAction() 으로 사용할 수 있습니다.

또한 확장 함수는 확장 함수 타입의 변수에 담을 수 있습니다. 확장 함수 타입 변수는 마치 확장 함수처럼 호출하거나 인자로 넘길 수 있습니다.

```kotlin
// 수신 객체 지정 람다를 변수에 저장하기
val appendExcl : StringBuilder.() -> Unit = { this.append("!") }

val stringBuilder = StringBuilder("Hi")
stringBuilder.appendExcl()  // 확장 함수처럼 호출 가능
buildString(appendExcl)     // 인자로 넘기기 가능
```

소스 코드 상에서는 수신 객체 지정 람다는 일반 람다와 동일해 보입니다. 람다에 수신 객체가 있는지는 함수 타입을 봐야 합니다.

```kotlin
// version 3. 표준 라이브러리 구현
fun buildString(builderAction: StringBuilder.() -> Unit): String = 
    StringBuilder().apply(builderAction).toString()
```

* apply: 수신 객체 타입에 대한 확장 함수. 수신 객체를 묵시적 인자(this)로 받고, 수신 객체를 다시 반환
* with: 수신 객체를 첫번째 파라미터로 받음. 람다를 호출해 얻은 결과를 반환

```kotlin
val map = mutableMapOf(1 to "one")
map.apply { this[2] = "two" }
with(map) { this[3] = "three" }
```

### 11.2.2 수신 객체 지정 람다를 HTML 빌더 안에서 사용

HTML 을 만들기 위한 코틀린 DSL 을 보통 HTML 빌더라고 합니다. 코틀린의 빌더는 타입 안정성을 보장합니다.

```kotlin
fun createSimpleTable() = createHTML().
    table {
        tr {
            td { +"cell" }
        }
    }

// 수신 객체를 명시한 코드
fun createSimpleTable() = createHTML().
    table {
        (this@table).tr {
            (this@tr).td {
                +"cell"         // 묵시적 수신 객체를 사용하고 있다. this@td 로도 사용 가능
            }
        }
    }
```

table 에 전달된 수신 객체는 TABLE 이라는 타입이며, 그 안에 tr 메서드 정의가 있습니다. 마찬가지로 tr 함수는 TR 객체에 대한 확장 함수 타입의 람다를 받습니다. 이런 API 설계는 HTML 언어의 문법을 따르는 코드만을 작성할 수 있게 해줍니다.

```kotlin
// 간단한 HTML 빌더의 전체 구현
open class Tag(val name: String) {
    private val children = mutableListOf<Tag>()
    protected fun <T: Tag> doInit(child: T, init: T.() -> Unit) {
        child.init()
        children.add(child)
    }
    override fun toString() =
        "<$name>${children.joinToString("")}</$name>"
}

fun table(init: TABLE.() -> Unit) = TABLE().apply(init)

class TABLE: Tag("table") {
    fun tr(init: TR.() -> Unit) = doInit(TR(), init)    // TR 태그 인스턴스 초기화 후 TABLE 태그의 자식으로 등록
}
class TR: Tag("tr") {
    fun td(init: TD.() -> Unit) = doInit(TD(), init)    // TD 태그 인스턴스 초기화 후 TR 태그의 자식으로 등록
}
class TD: Tag("td")

fun createTable() = 
    table {
        tr {        // table 메서드의 첫번째 인자가 TABLE 클래스의 확장 함수이므로, 이 부분에서는 TABLE 클래스의 메서드를 사용할 수 있습니다 (TABLE 타입의 람다인셈)
            td {
            }
        }
    }

fun createAnotherTable() =
    table {
        for (i in 1..2) {
            tr {            // tr 이 호출될때마다 새 TR 인스턴스가 생김
                td {
                }
            }
        }
    }
```

### 11.2.3 코틀린 빌더: 추상화와 재사용을 가능하게 하는 도구

외부 DSL 인 SQL, HTML 을 별도 함수로 분리해 이름을 부여하기는 어렵습니다. 하지만 내부 DSL 을 사용하면 일반 코드와 마찬가지로 반복되는 내부 DSL 코드 조각을 새 함수로 묶어서 재사용할 수 있습니다.

부트스트랩 라이브러리의 예를 보겠습니다. 드랍다운 목록을 만들면서 반복되는 css, html 코드가 생길 수 있습니다. 이를 별도의 함수(dropdownButton 이라든지)로 추출하여 불필요한 세부사항을 감출 수 있습니다.

## 11.3 invoke 관례를 사용한 더 유연한 블록 중첩

invoke 관례를 사용하면 객체를 함수처럼 호출할 수 있습니다. 이미 함수 타입의 객체(Function1 등)를 함수처럼 호출하는 경우를 보았습니다. 마찬가지로 invoke 관례를 사용하면 함수처럼 호출할 수 있는 클래스를 정의할 수 있습니다.

invoke 관례를 남용하면 1() 과 같은 이해하기 어려운 코드가 생길 수 있습니다. 다만 DSL 에서는 invoke 관례가 아주 유용한 경우가 많습니다.

### 11.3.1 invoke 관례: 함수처럼 호출할 수 있는 객체

관례란 "특별한 이름이 붙은 함수를 일반 메서드 호출 구문으로 호출하지 않고, 더 간단한 다른 구문으로 호출해주는 기능"입니다.

invoke 관례도 foo[bar] -> foo.get(bar) 처럼 동작하는 것입니다. 다만 invoke 는 함수를 호출할때처럼 각괄호가 아니라 괄호를 사용합니다.

invoke 메서드 시그니처는 자유롭게 정의할 수 있으며, 여러 파라미터 타입 지원을 위해 오버로딩할 수도 있습니다.

### 11.3.2 invoke 관례와 함수형 타입

이 책의 앞부분에서 함수 타입의 변수를 호출할때 lambda.invoke() 처럼 invoke 를 호출했었습니다. 이제는 일반적인 람다 호출 방식(뒤에 괄호를 붙이는 방식)이 invoke 관례를 이용했다는 걸 알 수 있습니다.

인라인하는 람다를 제외한 모든 람다는 함수형 인터페이스(Function1 등)을 구현하는 클래스이고, 각 함수형 인터페이스에는 invoke 메서드가 있습니다.

```kotlin
interface Function2<in P1, in P2, out R> {
    operator fun invoke(p1: P1, p2: P2): R
}
```

람다를 함수처럼 호출하면 invoke 메서드 호출로 변환됩니다.

이런 사실은 복잡한 람다를 여러 메서드로 분리하면서도 여전히 분리 전의 람다처럼 외부에서 호출할 수 있는 객체를 만들 수 있습니다. 기존 람다를 여러 함수로 나누려면 함수 타입 인터페이스를 구현하는 클래스를 정의해야 하고, 기반 인터페이스는 FunctionN<P1,...PN, R> 타입이나 (P1,...PN) -> R 타입으로 명시해야 합니다.

```kotlin
data class Issue(
    val id: String, val project: String, val type: String, val priority: String, val description: String
)
class ImportantIssuesPredicate(val project: String): (Issue) -> Boolean {
    override fun invoke(issue: Issue): Boolean {
        return issue.project == project && issue.isImportant()
    }
    private fun Issue.isImportant(): Boolean {
        return type == "Bug" && (priority == "Major" || priority == "Critical")
    }
}

val i1 = Issue("IDEA-154446", "IDEA", "Bug", "Major", "Save settings failed")
val i2 = Issue("KT-12183", "Kotlin", "Feature", "Normal", "Intention")
val predicate = ImportantIssuesPredicate("IDEA")
for (issue in listOf(i1, i2)).filter(predicate) {   // 술어를 predicate 에게 넘긴다
    println(issue.id)
}
```

이 코드에서는 술어의 로직이 너무 복잡해서 한 람다로 표현하기 어렵습니다. 그래서 람다를 여러 메서드로 나누고, 각 메서드에 명확한 이름을 붙이는 리팩토링을 진행하였습니다.

이런 방법은 분리해 낸 메서드가 영향을 끼치는 영역을 최소화할 수 있다는 장점. 복잡한 로직을 여러 관심사로 깔끔하게 분리해낼 수 있다는 장점이 있습니다.

### 11.3.3 DSL의 invoke 관례: 그레이들에서 의존관계 정의

DSL 을 사용하다면 아래처럼 중첩된 블록 구조로 사용할때도, 넓게 펼쳐진 형태로 사용할때도 있습니다. 이런 유연성을 어떻게 제공할 수 있을까요

```kotlin
dependencies {
    compile("junit:junit:4.11")
}
dependencies.compile("junit:junit:4.11")
```

```kotlin
class DependencyHandler {
    fun compile(coordinate: String) {                   // compile 메서드를 제공
        println("Added dependency on $coordinate")
    }
    operator fun invoke(body: DependencyHandler.() -> Unit) {
        body()  // == this.body()
    }
}
```

## 11.4 실전 코틀린 DSL

테스팅, 다양한 날짜 리터럴, 데이터베이스 질의, 안드로이드 UI 구성 같은 다양한 주제가 있습니다.

### 11.4.1 중위 호출 연쇄: 테스트 프레임워크의 should

```kotlin
"kotlin" should startWith("kot")
"kotlin" should start with "kot"
"kotlin".should(start).with("kot")

object start    // start 객체를 넘김으로써 should를 오버로딩한 함수 중에서 적절한 함수를 선택할 수 있게 해줍니다.
infix fun String.should(x: start): StartWrapper = StartWrapper(this)
class StartWrapper(val value: String) {
    infix fun with(prefix: String) = 
        if(!value.startsWith(prefix))
            throw AssertionError()
        else
            Unit
}

// 다른 예시
"kotlin" should end with "in"
"kotlin" should have substring "otl"
// 위와 같은 지원을 위해 end, have 같은 싱글턴 객체를 받는 should 함수 오버로딩 버전이 더 존재합니다.
```

이런 예는 DSL 을 구성하는 방법 중 상대적으로 어려운 방법이지만, 결과는 아주 멋집니다. 중위 호출과 object 를 정의한 싱글턴 객체 인스턴스를 조합하면 DSL 에 상당히 복잡한 문법도 도입할 수 있고, DSL 구문을 깔끔하게 만들 수 있습니다. 또한 여전히 정적 타입 지정 언어라서 함수와 객체를 잘못 조합하면 컴파일에 실패합니다.

### 11.4.2 원시 타입에 대한 확장 함수 정의: 날짜 처리

```kotlin
val yesterday = 1.days.ago
val tomorrow = 1.days.fromNow

val Int.days: Period
    get() = Period.ofDays(this)
val Period.age: LocalDate
    get() = LocalDate.now() - this
val Period.fromNow: LocalDate
    get() = LocalDate.now() + this
```

### 11.4.3 멤버 확장 함수: SQL을 위한 내부 DSL

DSL 에서는 확장 함수가 중요한 역할을 하는 것을 보았는데, 클래스 안에 확장 함수와 확장 프로퍼티를 선언할 수도 있습니다. 이를 멤버 확장이라고 합니다.

익스포즈드에서 예시를 보겠습니다.

```kotlin
object Country: Table() {
    val id = integer("id").autoIncrement().primaryKey() // 각 메서드는 자신의 수신 객체를 다시 반환하기 때문에 메서드를 연쇄 호출할 수 있습니다.
    val name = varchar("name", 50)
}

class Table {
    fun integer(name: String): Column<Int>
    fun varchar(name: String, length: Int): Column<String>
    
    fun <T> Column<T>.primaryKey(): Column<T>
    fun Column<Int>.autoIncrement(): Column<T>
}
```

각 메서드는 자신의 수신 객체를 다시 반환하기 때문에 메서드를 연쇄 호출 할 수 있습니다.

이런 메서드들을 멤버 확장으로 정의하는 이유는, 메서드가 적용되는 범위를 제한하기 위함입니다. primaryKey, autoIncrement 라는 메서드는 Table 이라는 맥락이 없으면 아무 의미가 없습니다.

또한 수신 객체 타입을 제한하는 기능도 중요합니다. autoIncrement 를 `Column<Int>` 의 확장 함수로 정의하면서 자동 증가 칼럼이 될 수 있는 칼럼을 제한했습니다.

> 멤버 확장도 멤버다
> 
> 멤버 확장에는 확장성이 떨어진다는 단점이 있습니다. 멤버 확장은 어떤 클래스의 내부에 있기 때문에 기존 클래스의 소스코드를 손대지 않고 새로운 멤버 확장을 추가할 수는 없습니다.

```kotlin
val result = (Country join Customer)
    .select { Country eq "USA" }
```

위 예제에서 eq 는 확장 함수이자 중위 표기법으로 식을 적었다는 사실을 알 수 있습니다.

### 11.4.4 안코: 안드로이드 UI를 동적으로 생성하기
