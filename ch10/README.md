<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [10장 어노테이션과 리플렉션](#10%EC%9E%A5-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98%EA%B3%BC-%EB%A6%AC%ED%94%8C%EB%A0%89%EC%85%98)
  - [10.1 어노테이션 선언과 적용](#101-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98-%EC%84%A0%EC%96%B8%EA%B3%BC-%EC%A0%81%EC%9A%A9)
    - [10.1.1 어노테이션 적용](#1011-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98-%EC%A0%81%EC%9A%A9)
    - [10.1.2 어노테이션 대상](#1012-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98-%EB%8C%80%EC%83%81)
    - [10.1.3 어노테이션을 활용한 JSON 직렬화 제어](#1013-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98%EC%9D%84-%ED%99%9C%EC%9A%A9%ED%95%9C-json-%EC%A7%81%EB%A0%AC%ED%99%94-%EC%A0%9C%EC%96%B4)
    - [10.1.4 어노테이션 선언](#1014-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98-%EC%84%A0%EC%96%B8)
    - [10.1.5 메타어노테이션: 어노테이션을 처리하는 방법 제어](#1015-%EB%A9%94%ED%83%80%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98%EC%9D%84-%EC%B2%98%EB%A6%AC%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95-%EC%A0%9C%EC%96%B4)
    - [10.1.6 어노테이션 파라미터로 클래스 사용](#1016-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98-%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0%EB%A1%9C-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%82%AC%EC%9A%A9)
    - [10.1.7 어노테이션 파라미터로 제네릭 클래스 받기](#1017-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98-%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0%EB%A1%9C-%EC%A0%9C%EB%84%A4%EB%A6%AD-%ED%81%B4%EB%9E%98%EC%8A%A4-%EB%B0%9B%EA%B8%B0)
  - [10.2 리플렉션: 실행 시점에 코틀린 객체 내부 관찰](#102-%EB%A6%AC%ED%94%8C%EB%A0%89%EC%85%98-%EC%8B%A4%ED%96%89-%EC%8B%9C%EC%A0%90%EC%97%90-%EC%BD%94%ED%8B%80%EB%A6%B0-%EA%B0%9D%EC%B2%B4-%EB%82%B4%EB%B6%80-%EA%B4%80%EC%B0%B0)
    - [10.2.1 코틀린 리플렉션 API: KClass, KCallable, KFunction, KProperty](#1021-%EC%BD%94%ED%8B%80%EB%A6%B0-%EB%A6%AC%ED%94%8C%EB%A0%89%EC%85%98-api-kclass-kcallable-kfunction-kproperty)
      - [KClass](#kclass)
      - [KCallable](#kcallable)
      - [KFunctionN](#kfunctionn)
      - [KPropertyN](#kpropertyn)
    - [10.2.2 리플렉션을 사용한 객체 직렬화 구현](#1022-%EB%A6%AC%ED%94%8C%EB%A0%89%EC%85%98%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%9C-%EA%B0%9D%EC%B2%B4-%EC%A7%81%EB%A0%AC%ED%99%94-%EA%B5%AC%ED%98%84)
    - [10.2.3 어노테이션을 활용한 직렬화 제어](#1023-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98%EC%9D%84-%ED%99%9C%EC%9A%A9%ED%95%9C-%EC%A7%81%EB%A0%AC%ED%99%94-%EC%A0%9C%EC%96%B4)
    - [10.2.4 JSON 파싱과 객체 역직렬화](#1024-json-%ED%8C%8C%EC%8B%B1%EA%B3%BC-%EA%B0%9D%EC%B2%B4-%EC%97%AD%EC%A7%81%EB%A0%AC%ED%99%94)
    - [10.2.5 최종 역직렬화 단계: callBy() 리플렉션을 사용해 객체 만들기](#1025-%EC%B5%9C%EC%A2%85-%EC%97%AD%EC%A7%81%EB%A0%AC%ED%99%94-%EB%8B%A8%EA%B3%84-callby-%EB%A6%AC%ED%94%8C%EB%A0%89%EC%85%98%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%B4-%EA%B0%9D%EC%B2%B4-%EB%A7%8C%EB%93%A4%EA%B8%B0)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# 10장 어노테이션과 리플렉션

다루는 것

* 어노테이션, 메타어노테이션
* 사용 지점 대상
  * property, field, get, set, receiver, param, setparam, delegate, file
* 리플렉션
* KClass, KCallable, KFunction, KProperty

지금까지 살펴본 여러 코틀린의 특성은 함수나 클래스 이름을 소스코드에서 정확하게 알고 있어야만 사용할 수 있었습니다. 어노테이션과 리플렉션을 사용하면 미리 알지 못하는 임의의 클래스를 다룰 수 있습니다.

어노테이션으로 라이브러리가 요구하는 의미를 클래스에게 부여할 수 있고, 리플렉션으로 실행 시점에 컴파일러 내부 구조를 분석할 수 있습니다.

어노테이션과 리플렉션의 사용법을 보여주는 예제로 JSON 직렬화, 역직렬화 라이브러리인 JKid 를 구현해봅니다.

## 10.1 어노테이션 선언과 적용

### 10.1.1 어노테이션 적용

코틀린에서는 자바와 같은 방법으로 어노테이션을 사용할 수 있습니다. 적용 대상 앞에 @ + 어노테이션 이름 형태로 이뤄집니다.

```kotlin
@Deprecated("Use removeAt(index) instead.", ReplaceWith("removeAt(index)"))
fun remove(index: Int) {}
```

자바와 코틀린에서 @Deprecated 의 의미는 동일하지만, 위 예제를 보면 replaceWith 파라미터에 옛 버전을 대신 할 수 있는 패턴을 제시할 수 있습니다. 인텔리J는 경고 메시지 뿐만 아니라 자동으로 새로운 API 버전에 맞는 코드로 퀵 픽스를 제시해주기도 합니다.

어노테이션 인자를 지정하는 방법에서 자바와 약간 다른 점들이 있습니다.

* 클래스를 어노테이션 인자로 지정할때는 ::class 를 클래스 명 뒤에 붙여야 합니다.
* 다른 어노테이션을 인자로 지정할때는 @ 를 붙이지 않습니다. 위 ReplaceWith 는 어노테이션입니다.
* 배열을 인자로 지정할때는 arrayOf() 로 묶어야 합니다.

어노테이션 인자는 컴파일 시점에 알 수 있어야 합니다. 프로퍼티를 어노테이션 인자로 사용하려면 `const` 변경자를 붙여 상수로 취급해줘야 합니다.

> const 프로퍼티는 최상위나 object 안에 선언해야하며, 원시타입이나 String 으로 초기화해야 합니다.

### 10.1.2 어노테이션 대상

코틀린 소스코드를 컴파일하면 한 요소가 여러 자바 선언을 만들어내는 경우들이 많습니다. 예를 들어 코틀린 프로퍼티는 자바 필드와 게터 메소드 선언을 만들어 냅니다. 프로퍼티가 변경 가능하다면 자바 세터 메소드와 세터 파라미터가 추가되며, 주 생성자에서 프로퍼티를 선언하면 이런 접근자 메소드와 파라미터 외에 자바 생성자 파라미터도 만들어 냅니다.

따라서 어노테이션을 붙일때는 실제로 자바(결과물)의 어떤 부분에 어노테이션을 붙이는건지 명시할 필요가 있습니다.

`@get:Rule` 사용 지점 대상:어노테이션 대상 으로 구분하여 어노테이션을 적용할 수 있습니다. @Rule 어노테이션을 프로퍼티 게터에 적용하라는 의미입니다.

자바의 어노테이션을 붙이게 되면 기본적으로 프로퍼티의 필드에 붙습니다.

사용 지점 대상 use-site target 을 지정할때 지원하는 목록입니다.

* property 프로퍼티 전체. 자바 어노테이션에는 이 사용 지점 대상을 사용할 수 없습니다.
* field 프로퍼티에 의해 생성되는 (뒷받침하는) 필드
* get 프로퍼티 게터
* set 프로퍼티 세터
* receiver 확장 함수나 프로퍼티의 수신 객체 파라미터
* param 생성자 파라미터
* setparam 세터 파라미터
* delegate 위임 프로퍼티의 위임 인스턴스를 담아둔 필드
* file 파일 안에 선언된 최상휘 함수와 프로퍼티를 담아두는 클래스

file 대상은 파일의 최상위 수준에만 적용할 수 있습니다. 예를 들어 @JvmName 어노테이션은 파일에 있는 최상위 선언을 담는 클래스 이름을 변경해줍니다. `@file:JvmName("StringFunctions`

> 자바 API 를 어노테이션으로 제어하기
> 
> 코틀린은 어노테이션으로 자바 바이트코드로 컴파일하는 방법과 코틀린 선언을 자바에 노출하는 방법을 제어할 수 있습니다.
> 
> @Volatile, @Strictfp 어노테이션은 자바의 volatile, strictfp 키워드를 그대로 대신합니다.
> 
> @JvmName, @JvmStatic, @JvmOverloads, @JvmField 등의 어노테이션이 있습니다.

|Java|Kotlin|
|----|------|
|@Override|	override|
|volatile|	@Volatile|
|strictfp|	@Strictfp|
|synchronized|	@synchronized|
|transient|	@Transient|
|throws|	@Throws|

### 10.1.3 어노테이션을 활용한 JSON 직렬화 제어

직렬화란 객체를 저장장치에 저장하거나 네트워크를 통해 전송하기 위해 텍스트나 이진형식으로 변환하는 것입니다. 역직렬화는 텍스트나 이진 형식으로 저장된 데이터를 원래 겍체로 만들어 줍니다.

> 제이키드 JKid 라이브러리와 소스코드와 연습문제
> 
> https://manning.com/books/kotlin-in-action, http://github.com/yole/jkid

```kotlin
data class Person(val name: String, val age: Int)
val person = Person("Alice", 29)
println(serialize(person))
{"age": 29, "name": "Alice"}

val json = """{"age": 29, "name": "Alice"}"""
println(deserialize<Person>(json))
Person(name=Alice, age=29)
```

`@JsonExclude`, `@JsonName` 어노테이션을 사용하여 직렬화, 역직렬화를 제어할 수도 있습니다.

### 10.1.4 어노테이션 선언

어노테이션 선언하는 방법을 보겠습니다.

```kotlin
annotation class JsonExclude // @JsonExclude 는 아무 파라미터도 없습니다.
annotation class JsonName(val name: String)
```

```java
public @interface JsonName {
    String value();
}
```

코틀린에서는 name 프러포티를 사용했지만, 자바에서는 value 를 사용했다는 점을 유의합니다. 자바에서는 value 를 제외한 모든 애트리뷰트에 이름을 명시해야 합니다. 코틀린에서는 일반적인 생성자 호출과 같습니다.

### 10.1.5 메타어노테이션: 어노테이션을 처리하는 방법 제어

어노테이션에도 어노테이션을 붙일 수 있습니다. 이를 메타어노테이션이라고 합니다. ANNOTATION_CLASS 를 사용하여 생성할 수 있습니다.

```kotlin
@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class BindingAnnotation

@BindingAnnotation
annotation class MyBinding
```

> @Retention 어노테이션
> 
> @Retention 은 정의 중인 어노테이션을 클래스를 소스 수준에서만 유지할지, .class 파일에 저장할지, 실행 시점에 리플렉션을 사용해 접근할 수 있게 할지를 지정하는 어노테이션입니다.
> 
> 자바 컴파일러는 기본적으로 어노테이션을 .class 파일에는 저장하지만 런타임에는 사용할 수 없습니다.
> 코틀린에서는 기본적으로 @Retention 을 RUNTIME 으로 지정합니다.

### 10.1.6 어노테이션 파라미터로 클래스 사용

정적인 데이터를 인자로 받는 어노테이션 정의를 보았습니다. 이번에는 클래스 참조를 파라미터로 하는 어노테이션 클래스 정의를 보겠습니다.

```kotlin
annotation class DeserializeInterface(val targetClass: KClass<out Any>)

interface Company { val name: String }
data class CompanyImpl(override val name: String): Company
data class Person(
    val name: String
    @DeserializeInterface(CompanyImpl::class) val company: Company
)
```

company 타입이 인터페이스인 Company 이기 때문에 out 변경자 없이 KClass<Any> 라고 쓰면 CompanyImpl::class 를 인자로 넘길 수 없고, 오직 Any::class 만 넘길 수 있습니다. out 키워드가 있으면 모든 코틀린 타입 T 에 대해서 KClass<T> 가 KClass<out Any> 의 하위 타입이 됩니다. (공변성)

### 10.1.7 어노테이션 파라미터로 제네릭 클래스 받기

제네릭 클래스, 타입 파라미터가 있는 클래스를 어노테이션 파라미터로 받는 예제를 보겠습니다.

```kotlin
interface ValueSerializer<T> {
    fun toJsonValue(value: T): Any?
    fun fromJsonValue(value: Any?): T
}

data class Person(
    val name: String,
    @CustomSerializer(DateSerializer::class) val birthDate: Date
)
```

이때 CustomSerializer 어노테이션은 ValueSerializer 클래스를 인자로 받습니다. 이때 ValueSerializer 클래스의 타입 파라미터를 알 수는 없으므로, 스타 프로젝션 * 을 사용할 수 있습니다.

그런데 이때 CustomSerializer 가 ValueSerializer 를 구현하는 클래스만 인자로 받아야 합니다. 이를 위해서 아래와 같이 선언할 수 있습니다.

```kotlin
annotation class CustomSerializer(
    val serializerClass: KClass<out ValueSerializer<*>>
)
```

이처럼 클래스를 인자로 받아야 하는 경우, 어노테이션 파라미터 타입을 `KClass<out 허용할 클래스 이름>` 을 쓰면 됩니다. 제네릭 클래스라면 `KClass<out 허용할 클래스 이름<*>>` 라고 씁니다.

## 10.2 리플렉션: 실행 시점에 코틀린 객체 내부 관찰

리플렉션은 실행 시점에 객체의 프로퍼티와 메서드에 접근할 수 있게 해주는 방법입니다.

보통은 실제로 존재하는 클래스, 메서드, 프로퍼티에 접근하고, 컴파일러는 그런 이름이 실제로 존재하는 선언인지를 컴파일 타임에 찾아내어 선언이 실제함을 보장해줍니다.

하지만 타입과 관계없이 객체를 다뤄야 하는 경우나 런타임에만 메서드나 프로퍼티 이름ㅇ르 알 수 있는 경우가 있습니다. (JSON 직렬화 라이브러리와 같이)

코틀린에서는 자바 API, 코틀린 API 2가지를 사용하여 리플렉션을 사용할 수 있습니다. (java.lang.reflect, kotlin.reflect)

코틀린 API는 자바에는 없는 프로퍼티나 nullable 타입과 같은 코틀린 고유 개념에 대한 리플렉션도 제공합니다. 하지만 자바 API 를 완벽히 대체할 수 있는 복잡한 기능은 제공하지는 않습니다.

### 10.2.1 코틀린 리플렉션 API: KClass, KCallable, KFunction, KProperty

<img src="book-contents/assets/kotlin-reflect" witdh=300 height=400>

#### KClass

MyClass:class 라고 쓰면 KClass 인스턴스를 얻을 수 있습니다. 클래스 안의 모든 선언을 조회, 접근 할 수 있습니다.

실행 시점에 객체의 클래스를 얻으려면 .javaClass, 코틀린 클래스를 얻으려면 .javaClass.kotlin 확장 프로퍼티로 접근 가능합니다.

[1_KClass.kts](1_KClass.kts)

```kotlin
package kotlin.reflect

interface KClass<T : kotlin.Any> : kotlin.reflect.KDeclarationContainer, kotlin.reflect.KAnnotatedElement, kotlin.reflect.KClassifier {
    val constructors: kotlin.collections.Collection<kotlin.reflect.KFunction<T>>

    val members: kotlin.collections.Collection<kotlin.reflect.KCallable<*>>

    val nestedClasses: kotlin.collections.Collection<kotlin.reflect.KClass<*>>

    val objectInstance: T?

    val qualifiedName: kotlin.String?

    @kotlin.SinceKotlin val sealedSubclasses: kotlin.collections.List<kotlin.reflect.KClass<out T>>

    val simpleName: kotlin.String?

    @kotlin.SinceKotlin val supertypes: kotlin.collections.List<kotlin.reflect.KType>

    @kotlin.SinceKotlin val typeParameters: kotlin.collections.List<kotlin.reflect.KTypeParameter>
    
    ...
}
```

#### KCallable

KCallable 은 함수와 프로퍼티의 공통 상위 인터페이스입니다. call 메서드를 통해 함수나 프로퍼티의 게터를 호출할 수 있습니다.

```kotlin
interface KCallable<out R> {
    fun call(vararg args: Any?): R
    ...
}

fun foo(x: Int) = println(x)

>>> val kFunction = ::foo
>>> kFunction.call(42)
```

call 호출 시에는 넘긴 인자의 개수와 원래 함수에 정의된 파라미터가 맞아야 하고, 맞지 않으면 런타임 예외가 발생합니다.

#### KFunctionN

이런 문제를 피하기 위해 KFunction1, KFunction2 등의 타입을 사용할 수도 있습니다. `::foo` 는 `KFunction1<Int, Unit>` 을 반환합니다.

KFunctionN 은 함수를 호출하기 위해 invoke 메서드를 사용합니다. invoke 메서드는 인자 개수나 타입이 맞지 않으면 컴파일 에러가 발생합니다.

따라서 인자 타입과 반환 타입을 모두 알고 있다면 invoke 가 좋지만, 모든 타입의 함수에 적용하려면 call 메서드가 좋습니다. 이때 타입 안정성을 보장하지는 않습니다.

> 언제 그리고 어떻게 KFunctionN 인터페이스가 정의되는가?
> 
> 이런 함수 타입들은 컴파일러가 생성한 합성 타입 synthetic compiler-generated type 입니다.
> 
> kotlin.reflect 패키지에서 이런 타입을 찾을 수 없는데, 이는 컴파일러가 생성한 합성 타입을 사용하기 때문입니다.

#### KPropertyN

KCallable 의 call 메서드는 프로퍼티의 게터를 호출합니다. 다른 방법은 KPropertyN 의 get 메서드를 호출하는 것 입니다.

최상위 프로퍼티는 KProperty0 인터페이스의 인스턴스로 표현되며, 인자가 없는 get 메서드가 있습니다.

```kotlin
val counter = 0

>>> val kProperty = ::counter
>>> kProperty.setter.call(21)   // 리플렉션을 통해 세터를 호출하면서 21을 인자로 넘깁니다.
>>> println(kProperty.get())    // get 을 통해 프로퍼티 값을 가져옵니다.
```

멤버 프로퍼티는 KProperty1 인스턴스입니다. 인자 1개인 get 메서드가 있고, 인자로는 프로퍼티를 얻고자 하는 객체 인스턴스를 넘깁니다.

최상위 수준이나 클래스 안에 정의된 프로퍼티만 리플렉션으로 접근할 수 있고, 함수의 로컬 변수에는 접근할 수 없습니다. 함수 안에서 로컬 변수 x 에 대해 ::x 로 변수에 대한 참조를 얻으려고 하면 "References to variables aren't supported yet" 오류가 발생합니다.

### 10.2.2 리플렉션을 사용한 객체 직렬화 구현

### 10.2.3 어노테이션을 활용한 직렬화 제어

### 10.2.4 JSON 파싱과 객체 역직렬화

### 10.2.5 최종 역직렬화 단계: callBy() 리플렉션을 사용해 객체 만들기
