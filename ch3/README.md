<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [함수 정의와 호출](#%ED%95%A8%EC%88%98-%EC%A0%95%EC%9D%98%EC%99%80-%ED%98%B8%EC%B6%9C)
  - [3.1 코틀린에서 컬렉션 만들기](#31-%EC%BD%94%ED%8B%80%EB%A6%B0%EC%97%90%EC%84%9C-%EC%BB%AC%EB%A0%89%EC%85%98-%EB%A7%8C%EB%93%A4%EA%B8%B0)
  - [3.2 함수를 호출하기 쉽게 만들기](#32-%ED%95%A8%EC%88%98%EB%A5%BC-%ED%98%B8%EC%B6%9C%ED%95%98%EA%B8%B0-%EC%89%BD%EA%B2%8C-%EB%A7%8C%EB%93%A4%EA%B8%B0)
    - [3.2.1 이름 붙인 인자](#321-%EC%9D%B4%EB%A6%84-%EB%B6%99%EC%9D%B8-%EC%9D%B8%EC%9E%90)
    - [3.2.2 디폴트 파라미터 값](#322-%EB%94%94%ED%8F%B4%ED%8A%B8-%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0-%EA%B0%92)
    - [3.2.3 정적인 유틸리티 클래스 없애기: 최상위 함수와 프로퍼티](#323-%EC%A0%95%EC%A0%81%EC%9D%B8-%EC%9C%A0%ED%8B%B8%EB%A6%AC%ED%8B%B0-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%97%86%EC%95%A0%EA%B8%B0-%EC%B5%9C%EC%83%81%EC%9C%84-%ED%95%A8%EC%88%98%EC%99%80-%ED%94%84%EB%A1%9C%ED%8D%BC%ED%8B%B0)
  - [3.3 메서드를 다른 클래스에 추가: 확장 함수와 확장 프로퍼티](#33-%EB%A9%94%EC%84%9C%EB%93%9C%EB%A5%BC-%EB%8B%A4%EB%A5%B8-%ED%81%B4%EB%9E%98%EC%8A%A4%EC%97%90-%EC%B6%94%EA%B0%80-%ED%99%95%EC%9E%A5-%ED%95%A8%EC%88%98%EC%99%80-%ED%99%95%EC%9E%A5-%ED%94%84%EB%A1%9C%ED%8D%BC%ED%8B%B0)
    - [3.3.1 임포트와 확장 함수](#331-%EC%9E%84%ED%8F%AC%ED%8A%B8%EC%99%80-%ED%99%95%EC%9E%A5-%ED%95%A8%EC%88%98)
    - [3.3.2 자바에서 확장 함수 호출](#332-%EC%9E%90%EB%B0%94%EC%97%90%EC%84%9C-%ED%99%95%EC%9E%A5-%ED%95%A8%EC%88%98-%ED%98%B8%EC%B6%9C)
    - [3.3.3 확장 함수로 유틸리티 함수 정의](#333-%ED%99%95%EC%9E%A5-%ED%95%A8%EC%88%98%EB%A1%9C-%EC%9C%A0%ED%8B%B8%EB%A6%AC%ED%8B%B0-%ED%95%A8%EC%88%98-%EC%A0%95%EC%9D%98)
    - [3.3.4 확장 함수는 오버라이드 할 수 없다](#334-%ED%99%95%EC%9E%A5-%ED%95%A8%EC%88%98%EB%8A%94-%EC%98%A4%EB%B2%84%EB%9D%BC%EC%9D%B4%EB%93%9C-%ED%95%A0-%EC%88%98-%EC%97%86%EB%8B%A4)
    - [3.3.5 확장 프로퍼티](#335-%ED%99%95%EC%9E%A5-%ED%94%84%EB%A1%9C%ED%8D%BC%ED%8B%B0)
  - [3.4 컬렉션 처리: 가변 길이 인자, 중위 함수 호출, 라이브러리 지원](#34-%EC%BB%AC%EB%A0%89%EC%85%98-%EC%B2%98%EB%A6%AC-%EA%B0%80%EB%B3%80-%EA%B8%B8%EC%9D%B4-%EC%9D%B8%EC%9E%90-%EC%A4%91%EC%9C%84-%ED%95%A8%EC%88%98-%ED%98%B8%EC%B6%9C-%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC-%EC%A7%80%EC%9B%90)
    - [3.4.1 자바 컬렉션 API 확장](#341-%EC%9E%90%EB%B0%94-%EC%BB%AC%EB%A0%89%EC%85%98-api-%ED%99%95%EC%9E%A5)
    - [3.4.2 가변 인자 함수](#342-%EA%B0%80%EB%B3%80-%EC%9D%B8%EC%9E%90-%ED%95%A8%EC%88%98)
    - [3.4.3 중위 호출과 구조 분해 선언](#343-%EC%A4%91%EC%9C%84-%ED%98%B8%EC%B6%9C%EA%B3%BC-%EA%B5%AC%EC%A1%B0-%EB%B6%84%ED%95%B4-%EC%84%A0%EC%96%B8)
  - [3.5 문자열과 정규식 다루기](#35-%EB%AC%B8%EC%9E%90%EC%97%B4%EA%B3%BC-%EC%A0%95%EA%B7%9C%EC%8B%9D-%EB%8B%A4%EB%A3%A8%EA%B8%B0)
    - [3.5.1 문자열 나누기](#351-%EB%AC%B8%EC%9E%90%EC%97%B4-%EB%82%98%EB%88%84%EA%B8%B0)
    - [3.5.2 정규식과 3중 따옴표로 묶은 문자열](#352-%EC%A0%95%EA%B7%9C%EC%8B%9D%EA%B3%BC-3%EC%A4%91-%EB%94%B0%EC%98%B4%ED%91%9C%EB%A1%9C-%EB%AC%B6%EC%9D%80-%EB%AC%B8%EC%9E%90%EC%97%B4)
    - [3.5.3 여러 줄 3중 따옴표 문자열](#353-%EC%97%AC%EB%9F%AC-%EC%A4%84-3%EC%A4%91-%EB%94%B0%EC%98%B4%ED%91%9C-%EB%AC%B8%EC%9E%90%EC%97%B4)
  - [3.6 코드 다듬기: 로컬 함수와 확장](#36-%EC%BD%94%EB%93%9C-%EB%8B%A4%EB%93%AC%EA%B8%B0-%EB%A1%9C%EC%BB%AC-%ED%95%A8%EC%88%98%EC%99%80-%ED%99%95%EC%9E%A5)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# 함수 정의와 호출

다루는 내용
- 파라미터에 이름 붙이기, 디폴트 파라미터, 가변 인자
- 최상위 함수, 최상위 프로퍼티
- 확장 함수, 확장 프로퍼티
- 스프레드 연산자 *
- 중위 호출 (infix call), to
- 구조 분해
- 3중 따옴표 문자열
- 로컬 함수

## 3.1 코틀린에서 컬렉션 만들기

코틀린의 컬렉션은 표준 자바 컬렉션을 사용합니다. 하지만 코틀린에서는 자바보다 더 많은 컬렉션의 기능을 사용할 수 있습니다.

```kotlin
// .javaClass 는 자바의 getClass() 에 해당하는 메서드
println(set.javaClass)
class java.util.HashSet

// last(), max() 등 자바에서는 없는 컬렉션 메서드를 제공
val strings = listOf("first", "second", "fourteenth")
println(strings.last())
val numbers = setOf(1,2,3)
println(numbers.max())
```

## 3.2 함수를 호출하기 쉽게 만들기

코틀린에서는 함수 호출을 쉽게 해주기 위한 몇가지 기능들을 제공합니다.

### 3.2.1 이름 붙인 인자

함수의 파라미터 타입이 동일한 파라미터가 연속되는 메서드가 있다면, 각각의 파라미터가 무엇을 의미하는지 알기 어렵습니다.

### 3.2.2 디폴트 파라미터 값

자바에서는 디폴트 파라미터 값을 제공하지 않습니다. 따라서 자바에서 코틀린 함수를 자주 호출해야 한다면 @JvmOverloads 어노테이션을 붙여서 마지막 파라미터부터 하나씩 생략한 오버로딩한 자바 메서드를 추가해줍니다.

### 3.2.3 정적인 유틸리티 클래스 없애기: 최상위 함수와 프로퍼티

자바에서는 모든 코드를 클래스의 메서드로 작성해야합니다. 하지만 실제로는 어느한 클래스에 포함시키지 어려운 코드들이 생기게 되고, 다양한 정적 메서드들을 담당하는 클래스들이 생깁니다. (JDK 의 Collections 클래스)

코틀린에서는 클래스 밖에 함수를 정의할 수 있고, 이런 최상위 함수들은 다른 패키지에서도 사용이 가능합니다.

자바에서는 최상위 함수들은 클래스 내부의 정적 메서드로 컴파일 됩니다.

함수와 마찬가지로 프로퍼티도 최상위 수준에 정의할 수 있고, 상수를 정의할때 유용합니다.

자바에서는 최상위 프로퍼티들은 접근자 메서드(getter, setter)를 통해 접근됩니다. const val 로 선언하면 public static final 필드가 됩니다.

## 3.3 메서드를 다른 클래스에 추가: 확장 함수와 확장 프로퍼티

확장 함수 extension function 이란 어떤 클래스의 멤버 메서드처럼 사용할 수 있지만, 실제 선언은 그 클래스의 밖에서 이뤄진 함수입니다.

```kotlin
// lastChar() 메서드는 자바의 String 에는 없는 메서드이지만, 코틀린에서는 확장 함수를 통해 String 클래스의 메서드를 추가할 수 있습니다.
package strings
fun String.lastChar(): Char = this.get(this.length - 1)
println("Kotlin".lastChar())

fun String.lastChar(): Char = get(length - 1) // this 는 생략 가능
```

이때 String 을 수신 객체 타입 receiver type, this 를 수신 객체 receiver object 라고 부릅니다.

### 3.3.1 임포트와 확장 함수

다른 클래스나 함수에서 확장 함수를 사용하기 위해서는 import 가 필요합니다.

import 할때는 이름을 변경해줄 수 있습니다.

````kotlin
import strings.lastChar as last
val c = "Kotlin".last()
````

### 3.3.2 자바에서 확장 함수 호출

자바에서 확장 함수는 수신 객체를 첫 번째 인자로 받는 정적 메서드입니다.

```java
char c = StringUtilKt.lastChar("Java");
```

### 3.3.3 확장 함수로 유틸리티 함수 정의

유틸리티 함수를 확장 함수로 선언하면 편리합니다.

확장 함수는 정적 메서드와 같은 특징을 가지므로, 확장 함수를 하위 클래스에서 오버라이드할 수는 없습니다.

### 3.3.4 확장 함수는 오버라이드 할 수 없다

일반적인 객체지향에서의 메서드 오버라이드는 아래와 같이 '동적'으로 결정됩니다.

```kotlin
open class View {
    open fun click() = println("View clicked")
}
class Button: View() {
    override fun click() = println("Button clicked")
}

>> val view: View = Button()
>> view.click()
Button clicked
```

확장 함수는 클래스의 일부가 아니고, 첫번째 인자가 수신 객체인 정적 자바 메서드로 컴파일되기 때문에 '정적'으로 결정됩니다.

```kotlin
fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")

>> val view: View = Button()
>> view.showOff()
I'm a view!
```

```java
>> View view = new Button()
>> ExtensionKt.showOff(view)
I'm a view!
```

어떤 클래스의 확장 함수와 시그니처가 같은 멤버 함수가 있다면, 멤버 함수의 우선순위가 더 높습니다. 따라서 클래스에 어떤 멤버 함수를 추가할때, 그 시그니처와 동일한 확장 함수를 쓰고 있는 외부 팀이 있다면, 재컴파일하는 순간 추가된 멤버 함수를 사용하게 됩니다.

### 3.3.5 확장 프로퍼티

확장 함수와 같이 확장 프로퍼티도 선언이 가능합니다. 프로퍼티라는 이름이긴 하지만 상태를 저장할 방법은 없기 때문에 상태를 가질 수는 없습니다.

또한 뒷받침하는 필드가 없어서 기본 게터 구현을 제공할 수 없으므로 게터는 반드시 정의해야 하고, 초기화 코드도 사용할 수 없습니다.

```kotlin
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }
```

## 3.4 컬렉션 처리: 가변 길이 인자, 중위 함수 호출, 라이브러리 지원

* vararg 키워드를 사용하여 가변 길이 인자를 정의 할 수 있습니다.
* 중위 함수 호출 infix call 을 사용하면 인자가 하나뿐인 메서드를 간편하게 호출할 수 있습니다. (to)
* 구조 분해 선언 destructuring declaration 을 사용하면 복합적인 값을 분해해서 여러 변수에 나눌 수 있습니다.

### 3.4.1 자바 컬렉션 API 확장

이전에 last(), max() 와 같은 함수들을 보았는데, 이는 모두 코틀린의 확장 함수였습니다.

### 3.4.2 가변 인자 함수

```kotlin
fun listOf<T>(vararg values: T): List<T> { ... }

val list = listOf(2,3,4,5,6)
```

이미 배열에 들어있는 원소들을 가변 길이 인자로 넘길때는 스프레드 연산자 * 를 붙이면 편리합니다.

```kotlin
fun main(args: Array<String>) {
    val list = listOf("args: ", *args)
}
```

### 3.4.3 중위 호출과 구조 분해 선언

mapOf 함수를 사용할때 to 키워드를 사용하여 key, value 쌍을 넣어줄 수 있습니다. to 라는건 일반 메서드를 뜻하며 중위 호출 infix call 이라는 특별한 방식으로 동작합니다.

to 메서드는 Pair 인스턴스를 반환합니다.

```kotlin
val map = mapOf(1 to "one", 2 to "tow")

1.to("one")
1 to "one"

// infix 변경자를 사용
infix fun Any.to(other: Any) = Pair(this, other)
```

Pair 객체 혹은 루프에서도 아래와 같이 구조 분해를 적용할 수 있습니다.

```kotlin
val (number, name) = 1 to "one"

fun ((index, element) in collection.withIndex()) {
    println("$index: $element")
}
```

## 3.5 문자열과 정규식 다루기

### 3.5.1 문자열 나누기

자바의 split() 함수는 사용하기 불편한 경우가 있었는데, 코틀린에서는 다양한 파라미터를 받는 split() 확장 함수를 제공해줍니다.

```kotlin
"12.345-6.A".split("\\.|-".toRegex()) // toRegex() 로 정규식 객체를 만들어 파라미터로 전달
"12.345-6.A".split(".", ",") // 구분자를 가변 인자로 여러개 전달
"12.345-6.A".split('.', ',') // 문자열 대신 문자를 전달
```

### 3.5.2 정규식과 3중 따옴표로 묶은 문자열

유용한 String 확장 함수
* .substringBeforeLast("/")
* .substringAfterLast("/")

3중 따옴표 문자열에서는 역슬래시를 포함한 어떤 문자도 이스케이프할 필요가 없습니다. 일반 문자열에서 정규식을 작성하는 경우 마침표 기호를 이스케이프하려면 \\. 라고 써야하지만, 3중 따옴표에서는 \. 라고 쓰면 됩니다.

### 3.5.3 여러 줄 3중 따옴표 문자열

3중 따옴표 문자열은 줄 바꿈을 표현하는 아무 문자열도 그대로 들어갑니다.

또한 문자열 템플릿을 사용할 수 있지만, $ 문자를 표현하기 위해서는 """${'$'}99.9""" 처럼 문자열 템플릿 안에서 표현해주어야 합니다.

## 3.6 코드 다듬기: 로컬 함수와 확장

코드에 중복을 제거하기 위해서 로컬 함수와 확장 함수를 다양한 방법으로 사용할 수 있습니다.

[1_local_function.kts](1_local_function.kts)
