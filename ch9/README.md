# 9장 제네릭스

다루는 것

* 제네릭 함수, 프로퍼티, 클래스
* 타입 파라미터 T
* upper bound : , where
* 타입 소거, 스타 프로젝션 *
* 실체화된 타입 파라미터 reified

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


