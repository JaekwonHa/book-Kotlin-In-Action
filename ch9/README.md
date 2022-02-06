<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [9장 제네릭스](#9%EC%9E%A5-%EC%A0%9C%EB%84%A4%EB%A6%AD%EC%8A%A4)
  - [9.1 제네릭 타입 파라미터](#91-%EC%A0%9C%EB%84%A4%EB%A6%AD-%ED%83%80%EC%9E%85-%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0)
    - [9.1.1 제네릭 함수와 프로퍼티](#911-%EC%A0%9C%EB%84%A4%EB%A6%AD-%ED%95%A8%EC%88%98%EC%99%80-%ED%94%84%EB%A1%9C%ED%8D%BC%ED%8B%B0)
    - [9.1.2 제네릭 클래스 선언](#912-%EC%A0%9C%EB%84%A4%EB%A6%AD-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%84%A0%EC%96%B8)
    - [9.1.3 타입 파라미터 제약](#913-%ED%83%80%EC%9E%85-%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0-%EC%A0%9C%EC%95%BD)
    - [9.1.4 타입 파라미터를 널이 될 수 없는 타입으로 한정](#914-%ED%83%80%EC%9E%85-%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0%EB%A5%BC-%EB%84%90%EC%9D%B4-%EB%90%A0-%EC%88%98-%EC%97%86%EB%8A%94-%ED%83%80%EC%9E%85%EC%9C%BC%EB%A1%9C-%ED%95%9C%EC%A0%95)
  - [9.2 실행 시 제네릭스의 동작: 소거된 타입 파라미터와 실체화된 타입 파라미터](#92-%EC%8B%A4%ED%96%89-%EC%8B%9C-%EC%A0%9C%EB%84%A4%EB%A6%AD%EC%8A%A4%EC%9D%98-%EB%8F%99%EC%9E%91-%EC%86%8C%EA%B1%B0%EB%90%9C-%ED%83%80%EC%9E%85-%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0%EC%99%80-%EC%8B%A4%EC%B2%B4%ED%99%94%EB%90%9C-%ED%83%80%EC%9E%85-%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0)
    - [9.2.1 실행 시점의 제네릭: 타입 검사와 캐스트](#921-%EC%8B%A4%ED%96%89-%EC%8B%9C%EC%A0%90%EC%9D%98-%EC%A0%9C%EB%84%A4%EB%A6%AD-%ED%83%80%EC%9E%85-%EA%B2%80%EC%82%AC%EC%99%80-%EC%BA%90%EC%8A%A4%ED%8A%B8)
    - [9.2.2 실체화한 타입 파라미터를 사용한 함수 선언](#922-%EC%8B%A4%EC%B2%B4%ED%99%94%ED%95%9C-%ED%83%80%EC%9E%85-%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%9C-%ED%95%A8%EC%88%98-%EC%84%A0%EC%96%B8)
    - [9.2.3 실체화된 타입 파라미터로 클래스 참조 대신](#923-%EC%8B%A4%EC%B2%B4%ED%99%94%EB%90%9C-%ED%83%80%EC%9E%85-%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0%EB%A1%9C-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%B0%B8%EC%A1%B0-%EB%8C%80%EC%8B%A0)
    - [9.2.4 실체화된 타입 파라미터의 제약](#924-%EC%8B%A4%EC%B2%B4%ED%99%94%EB%90%9C-%ED%83%80%EC%9E%85-%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0%EC%9D%98-%EC%A0%9C%EC%95%BD)
      - [타입 파라미터 사용 가능한 경우](#%ED%83%80%EC%9E%85-%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0-%EC%82%AC%EC%9A%A9-%EA%B0%80%EB%8A%A5%ED%95%9C-%EA%B2%BD%EC%9A%B0)
      - [타입 파라미터 사용할 수 없는 경우](#%ED%83%80%EC%9E%85-%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0-%EC%82%AC%EC%9A%A9%ED%95%A0-%EC%88%98-%EC%97%86%EB%8A%94-%EA%B2%BD%EC%9A%B0)
  - [9.3 변성: 제네릭과 하위 타입](#93-%EB%B3%80%EC%84%B1-%EC%A0%9C%EB%84%A4%EB%A6%AD%EA%B3%BC-%ED%95%98%EC%9C%84-%ED%83%80%EC%9E%85)
    - [9.3.1 변성이 있는 이유: 인자를 함수에 넘기기](#931-%EB%B3%80%EC%84%B1%EC%9D%B4-%EC%9E%88%EB%8A%94-%EC%9D%B4%EC%9C%A0-%EC%9D%B8%EC%9E%90%EB%A5%BC-%ED%95%A8%EC%88%98%EC%97%90-%EB%84%98%EA%B8%B0%EA%B8%B0)
    - [9.3.2 클래스, 타입, 하위 타입](#932-%ED%81%B4%EB%9E%98%EC%8A%A4-%ED%83%80%EC%9E%85-%ED%95%98%EC%9C%84-%ED%83%80%EC%9E%85)
    - [9.3.3 out 공변성: 하위 타입 관계를 유지](#933-out-%EA%B3%B5%EB%B3%80%EC%84%B1-%ED%95%98%EC%9C%84-%ED%83%80%EC%9E%85-%EA%B4%80%EA%B3%84%EB%A5%BC-%EC%9C%A0%EC%A7%80)
    - [9.3.4 in 반공변성: 뒤집힌 하위 타입 관계](#934-in-%EB%B0%98%EA%B3%B5%EB%B3%80%EC%84%B1-%EB%92%A4%EC%A7%91%ED%9E%8C-%ED%95%98%EC%9C%84-%ED%83%80%EC%9E%85-%EA%B4%80%EA%B3%84)
    - [9.3.5 사용 지점 변성: 타입이 언급되는 지점에서 변성 지정](#935-%EC%82%AC%EC%9A%A9-%EC%A7%80%EC%A0%90-%EB%B3%80%EC%84%B1-%ED%83%80%EC%9E%85%EC%9D%B4-%EC%96%B8%EA%B8%89%EB%90%98%EB%8A%94-%EC%A7%80%EC%A0%90%EC%97%90%EC%84%9C-%EB%B3%80%EC%84%B1-%EC%A7%80%EC%A0%95)
    - [9.3.6 스타 프로젝션: 타입 인자 대신 * 사용](#936-%EC%8A%A4%ED%83%80-%ED%94%84%EB%A1%9C%EC%A0%9D%EC%85%98-%ED%83%80%EC%9E%85-%EC%9D%B8%EC%9E%90-%EB%8C%80%EC%8B%A0--%EC%82%AC%EC%9A%A9)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# 9장 제네릭스

다루는 것

* 제네릭 함수, 프로퍼티, 클래스
* 타입 파라미터 T
* upper bound : , where
* 타입 소거
* 실체화된 타입 파라미터 reified
* 선언 지점 변성, 사용 지점 변성
* 공변성, 반공변성, 무공변성, out, in
* 스타 프로젝션 *

## 9.1 제네릭 타입 파라미터

제네릭스를 사용하면 타입 파라미터를 받는 타입을 정의할 수 있고, 제네릭 타입의 인스턴스를 생성할때는 타입 파라미터를 구체적인 타입 인자로 치환해야 합니다.

### 9.1.1 제네릭 함수와 프로퍼티

```kotlin
fun <T> List<T>.slice(indices: IntRange): List<T>
```

타입 파라미터의 실제 타입은 컴파일러에 의해 추론될 수 있습니다.

제네릭 함수와 마찬가지로 제네릭 확장 프로퍼티를 선언할 수 있습니다. 일반 프로퍼티에는 타입 파라미터를 사용할 수 없습니다.

```kotlin
val <T> List<T>.penultimate: T
    get() = this[size - 2]
```

> 확장 프로퍼티만 제네릭하게 만들 수 있습니다.
> 
> ```kotlin
> val <T> x: T = TODO()
> ERROR: type parameter of a property must be used in its receiver type
> ```

### 9.1.2 제네릭 클래스 선언

```kotlin
interface List<T> {
    operator fun get(index: Int): T
    ...
}
```

제네릭 클래스, 인터페이스를 확장, 구현하는 클래스를 정의하려면 기반 타입의 제네릭 파라미터에 대한 타입 인자를 지정해야 합니다. 구체적인 타입일 수도 있고, 타입 파라미터로 받은 것을 그대로 넘길 수도 있습니다.

```kotlin
class StringList: List<String> {
    override fun get(index: Int): String = ...
}
class ArrayList<T>: List<T> {
    override fun get(index: Int): T = ...
}
```

심지어 클래스가 자기 자신을 타입 인자로 참조할 수도 있습니다.

```kotlin
interface Comparable<T> {
    fun compareTo(other: T): Int
}
class String: Comparable<String> {               // 자기 자신을 타입으로 참조
    override fun compareTo(other: String): Int = ...
}
```

### 9.1.3 타입 파라미터 제약

제네릭 타입의 타입 파라미터에 상한 upper bound 를 지정할 수 있습니다.

```kotlin
fun <T : Number> List<T>.sum(): T // <T extends Number> T sum(List<T> list)
```

```kotlin
fun <T : Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}
```

first > second 는 코틀린 연산자 관례에 따라 first.compareTo(second) > 0 으로 컴파일됩니다. 따라서 Comparable 의 구현체 타입으로 제한할 수 있습니다.

여러개의 제약을 두려면 where 키워드를 사용할 수 있습니다.

```kotlin
fun <T> ensureTrailingPeriod(seq: T)
    where T : CharSequence, T : Appendable {
        if (!seq.endsWith('.')) {               // CharSequence 인터페이스의 메서드 호출
            seq.append('.')                     // Appendable 인터페이스의 메서드 호출
        }
    }
```

### 9.1.4 타입 파라미터를 널이 될 수 없는 타입으로 한정

상한을 정하지 않은 타입 파라미터는 Any? 를 상한으로 정한 파라미터와 같습니다.

[1_nullable_type_parameter.kts](1_nullable_type_parameter.kts)

not null type 만 타입 인자로 받기 위해서는 Any? 대신 Any 를 상한으로 정해야 합니다. 혹은 다른 null 이 될 수 없는 타입을 상한으로 지정해도 됩니다.

## 9.2 실행 시 제네릭스의 동작: 소거된 타입 파라미터와 실체화된 타입 파라미터

JVM 의 제네릭스는 보통 타입 소거 type erasure 를 사용합니다. 실행 시점에는 제네릭 클래스의 인스턴스에 타입 인자 정보가 들어있지 않다는 뜻입니다.

이장에서는 타입 소거가 어떤 이점이 있고, 이런 제약을 어떻게 우회할 수 있을지 알아보겠습니다.

### 9.2.1 실행 시점의 제네릭: 타입 검사와 캐스트

타입 인자 정보가 지워지기 때문에 List<String> 객체를 만들고 문자열을 추가하더라도 실행 시점에는 그 객체를 오직 List 로만 볼 수 있습니다. 그 List 객체가 어떤 타입의 원소를 저장하는지 실행 시점에는 알 수 없습니다.

List<String> 이나 List<Int> 나 실행 시점에는 같은 타입의 객체입니다. 그럼에도 불구하고 보통은 List<String> 에는 문자열만, List<Int> 에는 정수만 들어있다고 가정할 수 있는데, 이는 컴파일러가 올바른 타입의 값만 각 리스트에 넣도록 보장해주기 떄문입니다.

타입 인자를 따로 저장하지 않기 때문에 실행 시점에 타입 인자를 검사할 수 없습니다.

```kotlin
if (value is List<String>) { ... }
ERROR: Cannot check ofr instance of erased type
```

이런 경우에는 스타 프로젝션 star projection 을 사용하면 됩니다. 타입 파라미터가 2개 이상이라면 * 를 여러번 써주어야 합니다.

```kotlin
if (value is List<*>) { ... }
```

as, as? 캐스팅에도 제네릭 타입을 사용할 수 있습니다. 이때 기저 타입은 같지만 다른 타입으로 캐스팅해도 캐스팅에 성공한다는 점을 조심해야 합니다.

다른 타입으로 캐스팅시에는 "unchecked cast" 경고를 해주고, 실제로 캐스팅 할 수 없는 경우에는 "ClassCastException" 예외가 발생합니다.

```kotlin
fun printSum(c: Collection<*>) {
    val intList = c as? List<Int>       // "Unchecked cast: List<*> to List<Int>" 경고 발생
        ?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}
```

캄파일 시점에 타입 정보가 주어진 경우에는 is 검사를 수행할 수 있습니다.

```kotlin
fun printSum(c: Collection<Int>) {
    if (c is List<Int>) {
        println(c.sum())
    }
}
```

### 9.2.2 실체화한 타입 파라미터를 사용한 함수 선언

인라인 함수의 타입 파라미터는 실체화되므로 실행 시점에 인라인 함수의 타입 인자를 알 수 있습니다.

```kotlin
inline fun <reified T> isA(value: Any) = value is T // 이 코드는 이제 컴파일 가능합니다.
>>> println(isA<String>("abc"))
true
>>> println(isA<String>(123))
false

>>> val items = listOf("one", 2, "three")
>>> println(items.filterIsInstance<String>())
[one, three]
```

[2_filterIsInstance.kts](2_filterIsInstance.kts)

> 인라인 함수에서만 실체화한 타입 인자를 쓸 수 있는 이유
> 
> 인라인 함수는 본문을 구현한 바이트코드를 그 함수가 호출되는 모든 지점에 삽입합니다. 컴파일러는 실체화된 타입 인자를 사용해 인라인 함수를 호출하는 각 부분의 정확한 타입 인자를 알 수 있습니다. 따라서 구체적인 타입을 바이트코드에 삽입해줄 수 있습니다.
> 
> 자바 코드에서는 reified 타입 파라미터를 사용하는 inline 함수를 호출 할 수 없습니다. 자바에서 코틀린 인라인 함수를 호출 시에는 인라이닝 되지 않고 다른 보통 함수처럼 호출하게 됩니다.

성능의 이점을 얻기 위해 (람다 생성 비용 제거) 인라인 함수를 사용했었는데, filterIsInstance 인라인 함수의 경우에는 실체화된 타입 파라미터를 사용하기 위함이였습니다.

### 9.2.3 실체화된 타입 파라미터로 클래스 참조 대신

실체화된 타입 파라미터를 활용하여 java.lang.Class 타입 인자를 받는 API 를 쉽게 호출 할 수 있습니다.

```kotlin
// 표준 자바 API 인 ServiceLoader 를 호출하는 방법
val serviceImpl = ServiceLoader.load(Service::class.java)

// 아래와 같이 리팩토링 가능
inline fun <reified T> loadService() {
    return ServiceLoadder.load(T::class.java)
}

val serviceImpl = loadService<Service>()
```

### 9.2.4 실체화된 타입 파라미터의 제약

#### 타입 파라미터 사용 가능한 경우
* 타입 검사와 캐스팅 (is, !is, as, as?)
* 10장에서 설명할 코틀린 리플렉션 API (::class)
* 코틀린 타입에 대응하는 java.lang.Class 를 얻기(::class.java)
* 다른 함수를 호출할 때 타입 인자로 사용

#### 타입 파라미터 사용할 수 없는 경우
* 타입 파라미터 클래스의 인스턴스 생성하기
* 타입 파라미터 클래스의 동반 객체 메서드 호출하기
* 실체화한 타입 파라미터를 요구하는 함수를 호출하면서 실체화하지 않은 타입 파라미터로 받은 타입을 타입 인자로 넘기기
* 클래스, 프로퍼티, 인라인 함수가 아닌 함수의 타입 파라미터를 reified 로 지정하기

실체화된 타입 파라미터는 인라인 함수에서만 사용할 수 있다고 했었습니다. 따라서 이 함수에 전달되는 람다도 모두 함께 인라이닝 됩니다. 이때 인라이닝 할 수 없거나, 하고 싶지 않을때는 noinline 변경자를 함수 타입 파리미터에 붙여서 인라이닝을 금지할 수 있습니다.

## 9.3 변성: 제네릭과 하위 타입

변성 variance 개념은 `List<String>`, `List<Any>` 같이 기저 타입이 같고 타입 인자가 다른 여러 타입이 서로 어떤 관계에 있는지 설명하는 개념입니다.

### 9.3.1 변성이 있는 이유: 인자를 함수에 넘기기

String 클래스는 Any 를 확장하므로, Any 타입 값을 파라미터로 받는 함수에 String 값을 넘겨도 절대로 안전합니다.

하지만 List 인터페이스의 타입 인자로 들어가는 경우 그렇게 자신 있게 안정성을 말할 수 없습니다.

[3_variance.kts](3_variance.kts)

위 예제를 보면 `List<Any>` 타입의 파라미터를 받는 함수에 `List<String>` 을 넘기면 안전하지 않은 이유는, 어떤 함수가 리스트의 원소를 추가하거나 변경한다면 타입 불일치가 생길 수 있기 때문임을 보았습니다.

하지만 원소 추가나 변경이 없는 경우에는 `List<String>` 을 `List<Any>` 대신 넘겨도 안전합니다.

코틀린에서는 리스트의 변경 가능성에 따라 적절한 인터페이스를 선택하면 안전하지 못한 함수 호출을 막을 수 있습니다.

### 9.3.2 클래스, 타입, 하위 타입

타입과 클래스는 어떻게 다를까요

제네릭 클래스가 아닌 클래스에서는 클래스 이름을 바로 타입으로 사용할 수 있습니다. `var x: String` 여기서 String 은 클래스이면서 타입입니다. 하지만 `var x: String?` 처럼 널이 될 수 있는 타입에도 클래스 이름을 사용할 수 있습니다. 이는 모든 코틀린 클래스가 적어도 둘 이상의 타입을 구성할 수 있다는 뜻입니다.

제네릭 클래스에서는 무수히 많은 타입이 생길 수 있습니다. 예를 들어 List 는 타입이 아니라 클래스이고, 타입 인자를 치환한 `List<Int>`, `List<String?>`, `List<List<String>>` 등은 모두 제대로된 타입입니다.

타입 사이에는 하위 타입 subtype 개념이 있습니다. 어떤 타입 A 의 값을 어떤 타입 B 값을 넣어도 아무 문제가 없다면 타입 B 는 타입 A 의 하위 타입입니다. 예를 들어 Int 는 Number 의 하위 타입입니다.

일반적으로 하위 타입은 하위 클래스와 근본적으로 같지만, nullable 의 경우에는 다릅니다.

널이 될 수 없는 타입은 널이 될 수 있는 타입의 하위 타입입니다. 하지만 두 타입 모두 같은 클래스 입니다. String 은 String? 의 하위 타입 입니다.

그렇다면 "`List<String>` 타입의 값을 `List<Any>`를 파라미터로 받는 함수에 전달해도 괜찮은가?" 라는 질문을 "`List<String>` 은 `List<Any>` 의 하위 타입인가?" 라는 질문으로 바꿀 수 있습니다.

3번 예제에서 `MutableList<String>` 을 `MutableList<Any>` 의 하위 타입으로 다루면 안된다는 것을 보았습니다. 반대로 `MutableList<Any>` 도 `MutableList<String>` 의 하위 타입이 아닙니다.

이때 공변성, 반공변성, 무공변성 개념이 등장합니다.

|공변성|반공변성|무공변성|
|----|------|------|
|`Producer<out T>`|`Consumer<in T>`|`MutableList<T>`|
|타입 인자의 하위 타입 관계가 제네릭 타입에서도 유지된다.|타입 인자의 하위 타입 관계가 제네릭 타입에서 뒤집힌다.|하위 타입 관계가 성립하지 않는다.|
|Producer<Cat>은 Producer<Animal>의 하위타입|Consumer<Animal>은 Consumer<Cat>의 하위타입||
|T를 아웃 위치에서만 사용가능|T는 인 위치에서만 사용가능|T를 아무 위치에서나 사용가능|
|`<? extends T>`|`<? super T>`||

### 9.3.3 out 공변성: 하위 타입 관계를 유지

A가 B의 하위 타입일 때 `Producer<A>`가 `Producer<B>` 의 하위 타입이면, Producer 는 공변적입니다. 공변적임을 표현하려면 타입 파라미터에 `out` 을 붙여야 합니다.

클래스 멤버를 선언할때 타입 파라미터를 사용할 수 있는 지점은 인과 아웃으로 나뉩니다.

T가 함수의 반환 타입에 쓰인다면 T는 아웃 위치에 있고, 그 함수는 T 타입의 값을 생산 Produce 한다고 합니다.

T가 함수의 파라미터 타입에 쓰인다면 T는 인 위치에 있고, 그 함수는 T 타입의 값을 소비 Consume 한다고 합니다.

```kotlin
interface Transformer<T> {
    fun transform(t: T): T
//             "인 위치"  "아웃 위치"
}
```

타입 파라미터는 다른 타입의 타입 인자로도 쓰일 수 있습니다.

```kotlin
interface List<out T>: Collection<T> {
    fun subList(fromIndex: Int, toIndex: Int): List<T>
}
```

생성자 파라미터나 private 메서드의 파라미터는 인이나 아웃 어느쪽도 아닙니다.

변성은 코드에서 위험할 여지가 있는 메서드를 호출할 수 없게 함으로써 제네릭 타입의 인스턴스 역할을 하는 클래스 인스턴스를 잘못 사용하는 일이 없게끔 방지하는 역할 입니다. 생성자는 나중에 호출할 수 있는 메서드가 아니기에 위험할 여지가 없습니다.

하지만 val 이나 var 키워드를 생성자 파라미터에 적는다면 게터나 세터를 정의하는 것과 같습니다. 따라서 읽기 전용 프로퍼티는 아웃 위치, 변경 가능 프로퍼티는 아웃과 인 위치 모두에 해당합니다.

```kotlin
class Herd<T: Animal>(var leadAnimal: T, vararg animals: T) { ... }
// 여기서 leadAnimal 프로퍼티가 인 위치에 있기 때문에 T 를 out 으로 표시할 수 없습니다.
```

### 9.3.4 in 반공변성: 뒤집힌 하위 타입 관계

T 타입의 값을 소비하기만 할때, in 위치에서만 쓰인다는 뜻이고 T 앞에 in 을 붙일 수 있습니다.

```kotlin
val anyComparator = Comparator<Any> {
    e1, e2 -> e1.hashCode() - e2.hashCode()
}
val strings: List<String> = listOf("abs", "bac")
strings.sortedWith(anyComparator)
```

위 코드에서는 `Comparator<Any>` 를 `Comparator<String>` 타입을 요구하는 파리미터에 넘겨주었습니다. `Comparator<Any>` 가 `Comparator<String>` 의 하위 타입이라는 뜻입니다. 여기서 Any 는 String 의 상위 타입인데, 서로 다른 타입 인자에 대해서 Comparator 의 하위 타입 관계는 타입 인자의 하위 타입 관계과 정반대가 되었습니다.

이는 sortedWith 함수가 `Comparator<String>` 타입을 소비만 하기 때문에 이런 반공변성이 가능합니다.

클래스나 인터페이스가 어떤 타입 파라미터에 대해서는 공변적이면서, 다른 타입 파라미터에 대해서는 반공변적일수도 있습니다.

```kotlin
interface Function1<in P, out R> {
    operator fun invoke(p: P): R
}
```

### 9.3.5 사용 지점 변성: 타입이 언급되는 지점에서 변성 지정

클래스를 선언하면서 변성을 지정하면 그 클래스를 사용하는 모든 장소에 변성 지정자가 적용됩니다. 이런 방식을 선언 지점 변성 declaration site variance 라고 합니다.

자바의 와일드카드 타입 (? extends, ? super)에 익숙하다면 자바는 변성을 다른 방식으로 다룬다는 점을 알 수 있습니다. 자바에서는 타입 파라미터가 있는 타입을 사용할 때마다 해당 타입 파라미터를 하위 타입이나 상위 타입 중 어떤 타입으로 대치할 수 있을지 명시해야 합니다. 이를 사용 지점 변성 use-site variance 라고 합니다.

코틀린도 사용 지점 변성을 지원합니다. 클래스 안에서 어떤 타입 파라미터가 공변적이거나, 반공변적인지 선언할 수 없는 경우에도 특정 타입 파라미터가 나타나는 지점에서 변성을 정할 수 있습니다.

MutableList 와 같은 상당수의 인터페이스들의 타입 파라미터는 소비될 수도 있고, 생산할 수도 있기 때문에 공변적이지도 않고, 반공변적이지도 않습니다. 하지만 한 함수 안에서 생산자나 소비자 중 단 한가지 역할만을 담당한다면 다음과 같이도 사용할 수 있습니다.

```kotlin
fun <T> copyData(source: MutableList<out T>, destination: MutableList<in T>) {
    for (item in source) {
        destination.add(item)
    }
}
```

[4_use_site_variance.kts](4_use_site_variance.kts)

변성자 in, out 을 타입 파라미터에 붙이게 되면, 타입 프로젝션 type projection 이 발생합니다. 즉 source 를 일반적인 MutableList<T> 가 아니라 MutableList 를 프로젝션 한 (제약을 가한) 타입으로 만듭니다. 이 경우 MutableList 의 메서드 중에서 반환 타입으로 타입 파라미터 T 를 사용하는 메서드만 호출할 수 있습니다. (타입 파라미터 T를 아웃 위치에서 사용하는 메서드만 호출 가능)

copyData 함수를 제대로 구현하는 방법은 source 를 List<T> 로 구현하는 것입니다. List 의 타입 파라미터 공변성은 List 선언에 있기 때문에 굳이 out 을 붙여주지 않아도 됩니다. (위 예제는 공변성의 개념을 설명하기 좋습니다.) List, MutableList 처럼 읽기 전용 인터페이스와 무공변적인 인터페이스가 나뉘어 있지 않은 경우 여전히 프로젝션은 유용합니다.

### 9.3.6 스타 프로젝션: 타입 인자 대신 * 사용

타입 검사와 캐스트에 대해 설명할 때 제네릭 타입 인자 정보가 없음을 표현하기 위해 스타 프로젝션 * 을 사용한다고 했습니다. 예를 들어 원소 타입이 알려지지 않은 리스트는 `List<*>` 라는 구문으로 표현할 수 있습니다.

우선 `MutableList<*>` 와 `MutableList<Any?>` 는 같지 않습니다. MutableList<Any?> 는 모든 타입의 원소를 담을 수 있다는 표현이고, MutableList<*> 는 어떤 정해진 구체적인 타입의 원소를 담는 리스트이긴 하지만 그 원소의 타입을 정확히 모른다는 뜻입니다.

여기서 그 리스트의 원소 타입이 어떤 타입인지 모르긴 하지만, 아무 타입의 원소나 다 담아도 된다(Consume)는 뜻은 아닙니다. 값의 타입에 따라서는 리스트를 만들어서 넘겨준 쪽이 바라는 조건을 깰 수도 있기 때문입니다. 하지만 `MutableList<*>` 타입의 리스트에서 원소를 얻을 수(Produce)는 있습니다. 값을 얻는 경우 원소 타입은 알수 없지만 어쨋든 Any? 하위 타입임은 알 수 있습니다.

이는 `MutableList<*>` 가 사실은 `MutableList<out Any?>` 처럼 동작함을 의미합니다. 타입을 모르는 리스트에 원소를 다음대로 넣을 수는 없지만, Any? 타입의 원소를 꺼내올 수는 있습니다. 자바와 비교하면 `MyType<*>` 는 `MyType<?>` 과 같습니다.

> `Consumer<in T>` 와 같은 반공변 타입 파라미터에 대한 스타 프로젝션은 사실상 `<in Nothing>` 과 같습니다. 반공변 타입 파라미터는 제네릭 클래스의 소비자 역할을 하는데, 스타 프로젝션을 하면 어떤 타입인지 알 수 없기 때문에 어떤 부분을 사용해야 할지 알 수 없습니다. 사실상 호출할 수 있는 메서드가 없는 셈입니다.

스타 프로젝션을 사용하는 경우

* 타입 파라미터를 시그니처에서 전혀 언급하지 않거나
* 데이터를 읽기는 하지만, 그 타입에는 관심이 없는 경우. 타입 인자 정보가 중요하지 않은 경우
* 값을 생산만하고 소비하지는 않을 때

```kotlin
fun printFirst(list: List<*>) { // 모든 리스트를 인자로 받을 수 있음
    if (list.isNotEmpty()) {    // isNotEmpty() 에서는 제네릭 타입 파라미터를 사용하지 않음
        println(list.first())
    }
}

fun <T> printFirst(list: List<T>) {
    if (list.isNotEmpty()) {
        println(list.first())   // 이 경우 first() 는 T 타입의 값을 반환한다
    }
}
```

스타 프로젝셔을 사용할때 빠지기 쉬운 함정 예제를 보겠습니다.

[5_star_projection_version1.kts](5_star_projection_version1.kts)

[6_star_projection_version2.kts](6_star_projection_version2.kts)

[7_star_projection_version3.kts](7_star_projection_version3.kts)

5,6,7번 예제에서 타입 안정성을 보장하는 API 를 만드는 과정을 보았습니다. 안전하지 못한 모든 로직은 클래스 내부에 감추었습니다.

이처럼 안전하지 못한 코드를 별도로 분리하면 코드를 잘못 사용하지 못하게 방지할 수 있습니다.
