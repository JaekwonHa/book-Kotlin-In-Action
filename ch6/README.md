<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [6장 코틀린 타입 시스템](#6%EC%9E%A5-%EC%BD%94%ED%8B%80%EB%A6%B0-%ED%83%80%EC%9E%85-%EC%8B%9C%EC%8A%A4%ED%85%9C)
  - [6.1 널 가능성](#61-%EB%84%90-%EA%B0%80%EB%8A%A5%EC%84%B1)
    - [6.1.1 널이 될 수 있는 타입: ? (nullable type)](#611-%EB%84%90%EC%9D%B4-%EB%90%A0-%EC%88%98-%EC%9E%88%EB%8A%94-%ED%83%80%EC%9E%85--nullable-type)
    - [6.1.2 타입의 의미](#612-%ED%83%80%EC%9E%85%EC%9D%98-%EC%9D%98%EB%AF%B8)
    - [6.1.3 안전한 호출 연산자: ?. (Safe Calls)](#613-%EC%95%88%EC%A0%84%ED%95%9C-%ED%98%B8%EC%B6%9C-%EC%97%B0%EC%82%B0%EC%9E%90--safe-calls)
    - [6.1.4 엘비스 연산자: ?: (Elvis Operation)](#614-%EC%97%98%EB%B9%84%EC%8A%A4-%EC%97%B0%EC%82%B0%EC%9E%90--elvis-operation)
    - [6.1.5 안전한 캐스트: as? (Safe Casts)](#615-%EC%95%88%EC%A0%84%ED%95%9C-%EC%BA%90%EC%8A%A4%ED%8A%B8-as-safe-casts)
    - [6.1.6 널 아님 단언: !! (not-null assertion)](#616-%EB%84%90-%EC%95%84%EB%8B%98-%EB%8B%A8%EC%96%B8--not-null-assertion)
    - [6.1.7 let 함수](#617-let-%ED%95%A8%EC%88%98)
    - [6.1.8 나중에 초기화할 프로퍼티: lateinit](#618-%EB%82%98%EC%A4%91%EC%97%90-%EC%B4%88%EA%B8%B0%ED%99%94%ED%95%A0-%ED%94%84%EB%A1%9C%ED%8D%BC%ED%8B%B0-lateinit)
    - [6.1.9 nullable type 확장](#619-nullable-type-%ED%99%95%EC%9E%A5)
    - [6.1.10 타입 파라미터의 널 가능성](#6110-%ED%83%80%EC%9E%85-%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0%EC%9D%98-%EB%84%90-%EA%B0%80%EB%8A%A5%EC%84%B1)
    - [6.1.11 널 가능성과 자바](#6111-%EB%84%90-%EA%B0%80%EB%8A%A5%EC%84%B1%EA%B3%BC-%EC%9E%90%EB%B0%94)
      - [플랫폼 타입](#%ED%94%8C%EB%9E%AB%ED%8F%BC-%ED%83%80%EC%9E%85)
      - [상속](#%EC%83%81%EC%86%8D)
  - [6.2 코틀린의 원시 타입](#62-%EC%BD%94%ED%8B%80%EB%A6%B0%EC%9D%98-%EC%9B%90%EC%8B%9C-%ED%83%80%EC%9E%85)
    - [6.2.1 원시 타입: Int, Boolean 등](#621-%EC%9B%90%EC%8B%9C-%ED%83%80%EC%9E%85-int-boolean-%EB%93%B1)
    - [6.2.2 널이 될 수 있는 원시 타입: Int?, Boolean? 등](#622-%EB%84%90%EC%9D%B4-%EB%90%A0-%EC%88%98-%EC%9E%88%EB%8A%94-%EC%9B%90%EC%8B%9C-%ED%83%80%EC%9E%85-int-boolean-%EB%93%B1)
    - [6.2.3 숫자 변환](#623-%EC%88%AB%EC%9E%90-%EB%B3%80%ED%99%98)
      - [원시 타입 리터럴](#%EC%9B%90%EC%8B%9C-%ED%83%80%EC%9E%85-%EB%A6%AC%ED%84%B0%EB%9F%B4)
    - [6.2.4 Any, Any?](#624-any-any)
    - [6.2.5 Unit](#625-unit)
    - [6.2.6 Nothing](#626-nothing)
  - [6.3 컬렉션과 배열](#63-%EC%BB%AC%EB%A0%89%EC%85%98%EA%B3%BC-%EB%B0%B0%EC%97%B4)
    - [6.3.1 널 가능성과 컬렉션](#631-%EB%84%90-%EA%B0%80%EB%8A%A5%EC%84%B1%EA%B3%BC-%EC%BB%AC%EB%A0%89%EC%85%98)
    - [6.3.2 읽기 전용과 변경 가능한 컬렉션](#632-%EC%9D%BD%EA%B8%B0-%EC%A0%84%EC%9A%A9%EA%B3%BC-%EB%B3%80%EA%B2%BD-%EA%B0%80%EB%8A%A5%ED%95%9C-%EC%BB%AC%EB%A0%89%EC%85%98)
    - [6.3.3 코틀린 컬렉션과 자바](#633-%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%BB%AC%EB%A0%89%EC%85%98%EA%B3%BC-%EC%9E%90%EB%B0%94)
    - [6.3.4 컬렉션을 플랫폼 타입으로 다루기](#634-%EC%BB%AC%EB%A0%89%EC%85%98%EC%9D%84-%ED%94%8C%EB%9E%AB%ED%8F%BC-%ED%83%80%EC%9E%85%EC%9C%BC%EB%A1%9C-%EB%8B%A4%EB%A3%A8%EA%B8%B0)
    - [6.3.5 객체의 배열과 원시 타입의 배열](#635-%EA%B0%9D%EC%B2%B4%EC%9D%98-%EB%B0%B0%EC%97%B4%EA%B3%BC-%EC%9B%90%EC%8B%9C-%ED%83%80%EC%9E%85%EC%9D%98-%EB%B0%B0%EC%97%B4)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# 6장 코틀린 타입 시스템

다루는 내용

* ?
* ?.
* ?:
* as?
* !!
* let
* lateinit
* 플랫폼 타입
* Any, Unit, Nothing
* 읽기 전용 컬렉션, 변경 가능 컬렉션
* 배열, 원시타입 배열

## 6.1 널 가능성

### 6.1.1 널이 될 수 있는 타입: ? (nullable type)

코틀린과 자바의 가장 중요한 차이점은 코틀린 타입 시스템은 널이 될 수 있는 타입을 명시적으로 지원합니다.

코틀린에서 모든 타입은 널이 될 수 없고, 명시적으로 뒤에 ? 를 붙여야 합니다.

nullable type 의 경우 변수.메소드() 처럼 메소드를 직접 호출할 수 없고, not null type 의 변수에 대입하거나, 인자로 넘길 수 없습니다.

null 검사를 명시적으로 코드에 추가하면 not null type 처럼 사용할 수 있습니다.

```kotlin
fun strLenSafe(s: String?): Int =
    if (s != null) s.length else 0 // s!!.length 가 아니라 s.length 로 호출
```

### 6.1.2 타입의 의미

타입은 어떤 값들이 가능한지와 그 타입에 대해 수행할 수 있는 연산의 종류를 결정합니다.

자바에서 String 타입의 변수는 String 이나 null 두 가지 종류의 값이 가능하지만, 이 두 종류는 할 수 있는 일이 완전히 다르며, isinstanceof 의 결과도 null 은 String 이
아닙니다.

> NullPointerException 오류를 다루는 다른 방법
>
> NPE 를 피하기 위해서 자바에서도 많은 도구들이 지원됩니다. @Nullable, @NotNull 어노테이션이나 인텔리J 의 코드 검사기 등의 도움을 받을 수 있지만 이는 표준 자바 컴파일 절차가 아니고, 모든 코드 베이스에 어노테이션을 추가하는 것도 쉽지 않은 일 입니다.
>
> 다른 방법은 null 을 절대 쓰지 않는 것으로, 자바 8의 Optional 을 사용하는 것인데, 이것도 코드가 지저분해지고 래퍼가 추가되는 단점이 있고, 전체 에코시스템에 일관성있게 활용하기 어렵다는 단점이 있습니다.

Runtime 에는 not null type 이나 nullable type 이나 객체는 같습니다. 이는 nullable type 이 not null type 을 감싼 래퍼 타입이 아님을 위미하며, 이를 처리하는데
별도의 실행 시점 부가 비용이 들지는 않습니다.

### 6.1.3 안전한 호출 연산자: ?. (Safe Calls)

코틀린에서는 nullable type 에 대한 함수 호출시 null 이 아닐때만 수행되는 코드를 쉽게 작성할 수 있는 방법은 제공합니다.

```kotlin
// 아래 두 코드는 동일
s?.toUpperCase()
if (s != null) s.toUpperCase() else null
```

연쇄 호출도 가능합니다.

```kotlin
fun Person.countryName(): String {
    val country = this.company?.address?.country
    return if (country != null) country else "Unknown"
}
```

### 6.1.4 엘비스 연산자: ?: (Elvis Operation)

코틀린은 null 대신 사용할 디폴트 값을 지정할 때 편리한 연산자를 제공합니다.

```kotlin
fun foo(s: String?) {
    val t: String = s ?: ""
}
```

코틀린에서는 return 이나 throw 연산도 식입니다. 따라서 엘비스 연산자의 우항에 return, throw 연산도 넣을 수 있습니다.

```kotlin
class Address(val streetAddress: String, val city: String)
class Company(val name: String, val address: Address?)
class Person(val name: val company: String?)

fun printShippingLabel(person: Person) {
    val address = person.company?.address
        ?: throw IllegalArgumentException("No address")
    with(addrees) {
        println(streetAddress)
        println("$city")
    }
}
```

### 6.1.5 안전한 캐스트: as? (Safe Casts)

as? 연산자는 어떤 값을 지정한 타입으로 캐스트합니다. as? 는 값을 대상 타입을 변환할 수 없으면 null 을 반홥니다.

```kotlin
class Person(val firstName: String, val lastName: String) {
    override fun equals(o: Any?): Boolean {
        val otherPerson = o as? Person ?: return false
        return otherPerson.firstName == firstName && otherPerson.lastName == lastName
    }
}
```

### 6.1.6 널 아님 단언: !! (not-null assertion)

느낌표를 이중(!!)으로 사용하면 어떤 값이든 널이 될 수 없는 타입 (강제로) 변경할 수 있습니다.

not-null assertion 이 코드상 깔끔해보이지 않는 해법일 수 있지만, 상황에 따라 좋은 방법일 수도 있습니다.

어떤 함수가 값이 널인지 검사한 다음에 다른 함수를 호출한다고 해도 컴파일러는 이를 알지 못합니다. 확실히 널이 아닌 값을 받는다면, 널 검사를 생략하기 위해서 단언문을 사용할 수 있습니다.

여러 !! 단언문을 한 줄에 쓰게되면 어디서 예외가 발생했는지 알기 어렵습니다.

### 6.1.7 let 함수

nullable type 의 변수를 not null type 의 인자로 넘길 수는 없습니다.

let 함수는 자신을 수신 객체로 하여 인자로 전달받은 람다에게 넘깁니다.

```kotlin
// 아래 두 코드는 동일
if (email != null) sendEmailTo(email)
email?.let { email -> sendEmailTo(email) }
```

### 6.1.8 나중에 초기화할 프로퍼티: lateinit

객체 인스턴스를 일단 생성한 다음에 나중에 초기화하는 프레임워크가 많습니다.

코틀린에서는 클래스 안의 널이 될 수 없는 프로퍼티를 생성자 밖에서 초기화할 수 없습니다.

nullable type 을 쓰게되면 해당 프로퍼티를 쓰는 모든 곳에서 null check 를 해야합니다.

lateinit 변경자를 붙이면 프로퍼티를 나중에 초기화할 수 있습니다.

```kotlin
class MyService {
    fun performAction(): String = "foo"
}
class MyTest {
    private lateinit var myService: MyService
    @Before fun setUp() {
        myService = MyService()
    }
    @Test fun testAction() {
        Assert.assertEquals("foo", myService.performAction())
    }
}
```

### 6.1.9 nullable type 확장

nullable type 에 대해서 확장 함수를 정의하면 null 값을 다루는 강력한 도구로 활용할 수 있습니다.

null 인 변수에 대해서 메서드를 호출해도 확장 함수인 메서드에서 알아서 null 을 처리할 수 있고, 이런 처리는 확장 함수에서만 가능합니다.

일반 멤버 호출은 객체 인스턴스를 통해서 디스패치되므로, 그 인스턴스가 널이 될 수 없습니다.

예를 들어 코틀린에서는 isNullOrEmpty(), isNullOrBlank() 등의 함수가 있습니다.

```kotlin
fun verifyUserInput(input: String?) {
    if (input.isNullOrBlank()) {
        println("Please fill in the required fields")
    }
}
```

nullable type 이라도 safe call 없이 확장 함수를 호출할 수 있습니다.

nullable type 확장 함수 내에서는 this 가 null 이 될 수 있어서 명시적으로 null check 를 해야 합니다. 자바에서는 null 이였다면 메서드가 호출되지도 않았을 것 입니다.

### 6.1.10 타입 파라미터의 널 가능성

코틀린에서는 함수나 클래스의 모든 타입 파라미터(T)는 기본적으로 널이 될 수 있습니다. (nullable type 으로 취급됩니다)

null 이 아님을 확실히 하려면 타입 상한 upper bound 를 지정해야합니다.

```kotlin
fun <T> printHashCode(t: T) {
    println(t?.hasCode()) // t 가 nullable 이므로 safe call 해야함
}

fun <T: Any> printHashCode(t: T) {
    println(t.hashCode()) // T 는 not null type
}
```

### 6.1.11 널 가능성과 자바

코틀린은 자바 상호운영성을 강조하는 언어입니다. 코틀린에서 null 을 다루는 타입과 자바는 어떻게 호환될 수 있을까요.

자바코드의 @Nullable, @NotNull 어노테이션을 참고합니다. 또한 코틀린은 JSR-305 표준, 안드로이드, 젯브레인스 도구들이 지원하는 어노테이션들을 이해할 수 있습니다.

이런 어노테이션이 소스코드에 없는 경우 자바의 타입은 코틀린의 "플랫폼 타입"이 됩니다.

#### 플랫폼 타입

플랫폼 타입은 코틀린이 널 관련 정보를 알 수 없는 타입을 말합니다. 그 타입을 nullable, not null type 어느 것으로 처리해도 되고, 이 책임은 개발자에게 있습니다.

```java
public class Person {
    private final String name;
    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
```

위의 코드에서 getName이 null 을 리턴할지 아닐지는 알 수 없습니다. 따라서 코틀린 코드에서 위 코드를 사용한다면 개발자가 직접 처리 방식을 결정해야 합니다.

#### 상속

코틀린에서 자바 메서드를 오버라이드할 때 그 메서드의 파라미터와 반환 타입을 널이 될 수 있는 타입을 선언할지 널이 될 수 없는 타입을 선언할지 결정해야 합니다.

```java
interface StringProcessor {
    void process(String value);
}
```

```kotlin
class StringPrinter : StringProcessor {
    override fun process(value: String) {
        println(value)
    }
}
class NullableStringPrinter : StringProcessor {
    override fun process(value: String?) {
        println(value)
    }
}
```

코틀린 컴파일러는 위와 같은 두가지 구현을 모두 받아들입니다.

구현된 메서드는 코틀린, 자바 모두에서 호출될 수 있으므로 주의해야 합니다. not null type 으로 선언한 메서드를 자바 코드가 호출할때 null 을 넘기면 예외가 발생하게 됩니다.

## 6.2 코틀린의 원시 타입

코틀린에서는 원시 타입과 래퍼 타입을 구분하지 않습니다. 잠시 후 그 이유를 살펴보겠습니다.

### 6.2.1 원시 타입: Int, Boolean 등

코틀린에서는 래퍼 타입을 따로 구분하지 않습니다. 실행 시점에 가장 효율적인 방식으로 표현되며, 대부분의 경우에는 Int 타입은 int 타입으로 컴파일되고 이런 경우가 불가능한 경우 (컬렉션의 타입 파라미터로 넘기는 경우) java.lang.Integer 타입으로 들어갑니다.

* Byte, Short, Int, Long
* Float, Double
* Char
* Boolean

### 6.2.2 널이 될 수 있는 원시 타입: Int?, Boolean? 등

null 참조는 자바의 참조 타입 변수에만 대입할 수 있기 때문에 코틀린에서 nullable 원시 타입을 사용하면 자바의 래퍼 타입으로 컴파일 됩니다.

제네릭 클래스의 경우 래퍼 타입을 사용합니다. 이는 JVM은 타입 인자로 원시 타입을 허용하지 않기 때문입니다.

원시 타입의 대규모 컬렉션을 효과적으로 저장해야 한다면, 서드파티 라이브러리나 배열을 사용해야 합니다.

### 6.2.3 숫자 변환

코틀린과 자바의 큰 차이점은 코틀린에서는 한 타입의 숫자를 다른 타입의 숫자로 자동변환하지 않습니다.

반드시 명시적으로 toByte(), toShort(), toChar(), toInt(), toLong() 을 호출해주어야 합니다.

코틀린은 개발자의 혼란을 피하기 위해 타입 변환을 명시하기로 했고, 특히 박스 타입을 비교하는 경우 주의해야 합니다.

```kotlin
val x = 1
val list = listOf(1L, 2L, 3L)

println(x in list) // false

println(x.toLong() in list) // true
```

#### 원시 타입 리터럴
* L 접미사가 붙은 Long 타입 리터럴: 123L
* 표준 부동소수점 표기법을 사용한 Double 타입 리터럴: 0.12, 2.0, 1.2e10, 1.2e-10
* f나 F 접미사가 붙은 Float 타입 리터럴: 123.4f, .456f, 1e3f
* 0x 나 0X 접두사가 붙은 16진 리터럴: 0xCAFEBABE, 0xbcdL
* 0b 나 0B 접두사가 붙은 2진 리터럴: 0b000000101

### 6.2.4 Any, Any?

코틀린에서는 Any, Any? 가 모든 타입의 조상 타입입니다.

Any 타입은 java.lang.Object 에 대응합니다.

모든 코틀린 클래스에 있는 toString, equals, hashCode 세가지 메서드는 Any 에 정의된 메서드를 상속한 것입니다. 하지만 java.lang.Object 에 있는 다른 메서드 (wait, notify 등) 는 Any 에서 사용할 수 없습니다. 사용하기 위해서는 java.lang.Object 타입으로 캐스트해야 합니다.

### 6.2.5 Unit

코틀린 Unit 타입은 자바 void 와 같은 기능을 합니다.

Unit 과 void 의 차이점은, Unit 은 모든 기능을 갖는 일반적인 타입이며, void 와 달리 Unit 은 타입 인자로도 쓸 수 있습니다.

### 6.2.6 Nothing

코틀린에는 결코 성공적으로 값을 돌려주는 일이 없으므로 '반환 값' 이라는 개념 자체가 의미 없는 함수가 일부 존재합니다. (예를 들어 테스트 함수에서 fail 하는 경우)

Nothing 타입은 아무 값도 포함하지 않습니다. 따라서 Nothing 은 함수의 반환 타입이나 반환 타입으로 쓰일 타입 파라미터로만 쓸 수 있습니다. 다른 용도로 사용하는 경우 그 변수에 아무 값도 저장할 수 없으므로 의미가 없습니다.

```kotlin
fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}

val address = company.address ?: fail("No address") // fail 은 정상종료 되지 않는 함수이므로, address 값은 널인 경우가 없음을 알 수 있다
```

## 6.3 컬렉션과 배열

### 6.3.1 널 가능성과 컬렉션

유용한 코틀린 표준 라이브러리
* String.toIntOrNull()
* filterNotNull()

### 6.3.2 읽기 전용과 변경 가능한 컬렉션

코틀린 컬렉션과 자바 컬렉션의 중요한 차이점은 코틀린에서는 컬렉션 안의 데이터에 접근하는 인터페이스와 컬렉션 안의 데이터를 변경하는 인터페이스를 분리했다는 점입니다.

kotlin.collections.Collection 인터페이스에는 데이터를 읽는 여러 다른 연산을 수행할 수 있지만, 원소를 추가하거나 제거하는 메서드가 없습니다.

컬렉션의 데이터를 수정하려면 kotlin.collections.MutableCollection 인터페이스를 사용해야 합니다.

MutableCollection 은 Collection 인터페이스를 확장하여 원소를 추가하거나 삭제하거나 원소를 모두 지우는 등의 메서드를 제공합니다.

주의할 점은, 같은 컬렉션 객체를 가리키는 다른 타입의 참조들이 있을 수 있습니다. (읽기 전용과 변경 가능 컬렉션)

이런 상황에서 이 컬렉션을 참조하는 다른 코드를 호출하거나, 병렬 실행하면 컬렉션을 사용하는 중에 내용이 변경되는 상황이 생길 수 있습니다. 이때 ConcurrentModificationException 이나 다른 오류가 발생할 수 있습니다. 따라서 읽기 전용 컬렉션이 항상 thread safe 하지 않다는 점을 명심해야 합니다.

다중 스레드 환경에서 데이터를 다루는 경우에는 데이터를 적절히 동기화하거나, 동시 접근을 허용하는 데이터 구조를 사용해야 합니다.

### 6.3.3 코틀린 컬렉션과 자바

|컬렉션 타입|읽기 전용 타입|변경 가능 타입|
|--------|-----------|----------|
|List|listOf|mutableListOf, arrayListOf|
|Set|setOf|mutableSetOf, hasSetOf, LinkedSetOf, sortedSetOf|
|Map|mapOf|mutableMapOf, hasMapOf, linkedMapOf, sortedMapOf|

모든 코틀린 컬렉션은 자바 컬렉션과 동일한데, 읽기 전용과 변경 가능 컬렉션은 어떻게 구현된 것일까요.

java.util.Collection 을 파라미터로 받는 자바 메서드에는 Collection 이나 MutableCollection 모두 인자로 넘길 수 있습니다. 자바는 읽기 전용 컬렉션과 변경 가능 컬렉션을 구분하지 않습니다.

이로 인해 코틀린에서는 읽기 전용일지라도 자바 코드 내에서는 컬렉션의 내용을 변경할 수 있습니다. 따라서 플랫폼 타입과 같이, 컬렉션을 어떤 타입으로 정의할지는 개발자에게 책임이 있습니다.

자바쪽에서 컬렉션을 변경할 여지가 있다면 그냥 변경 가능 컬렉션으로 정의하는게 좋을 수도 있습니다.

### 6.3.4 컬렉션을 플랫폼 타입으로 다루기

자바쪽에서 선언한 컬렉션 타입의 변수를 코틀린에서는 플랫폼 타입으로 봅니다. 플랫폼 타입인 컬렉션은 변경 가능성을 알 수 없습니다. 

보통은 어느 것으로 다루든 상관 없을 수 있으나, 컬렉션 타입이 시그니처에 들어간 자바 메서드 구현을 오버라이드 하려는 경우 어떤 코틀린 컬렉션 타입을 사용할지 잘 결정해야 합니다.

* 컬렉션이 널이 될 수 있는가?
* 컬렉션의 원소가 널이 될 수 있는가?
* 오버라이드하는 메서드가 컬렉션을 변경할 수 있는가?

### 6.3.5 객체의 배열과 원시 타입의 배열

코틀린에서 배열을 만드는 방법

* arrayOf()
* arrayOfNulls()
* Array<T>() { i -> ... }

코틀린에서 원시 타입의 배열을 만드는 방법

* IntArray()
* intArrayOf()
* IntArray() { i -> ... }
* toIntArray()

컬렉션에서 사용할 수 있는 모든 확장 함수를 배열에서도 사용할 수 있습니다.
