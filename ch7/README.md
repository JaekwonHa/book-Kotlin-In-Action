<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [7장 연산자 오버로딩과 기타 관례](#7%EC%9E%A5-%EC%97%B0%EC%82%B0%EC%9E%90-%EC%98%A4%EB%B2%84%EB%A1%9C%EB%94%A9%EA%B3%BC-%EA%B8%B0%ED%83%80-%EA%B4%80%EB%A1%80)
  - [7.1 산술 연산자 오버로딩](#71-%EC%82%B0%EC%88%A0-%EC%97%B0%EC%82%B0%EC%9E%90-%EC%98%A4%EB%B2%84%EB%A1%9C%EB%94%A9)
    - [7.1.1 이항 산술 연산 오버로딩 + - * / %](#711-%EC%9D%B4%ED%95%AD-%EC%82%B0%EC%88%A0-%EC%97%B0%EC%82%B0-%EC%98%A4%EB%B2%84%EB%A1%9C%EB%94%A9------%25)
    - [7.1.2 복합 대입 연산자 오버로딩 += -=](#712-%EB%B3%B5%ED%95%A9-%EB%8C%80%EC%9E%85-%EC%97%B0%EC%82%B0%EC%9E%90-%EC%98%A4%EB%B2%84%EB%A1%9C%EB%94%A9---)
    - [7.1.3 단항 연산자 오버로딩 + - ++ --](#713-%EB%8B%A8%ED%95%AD-%EC%97%B0%EC%82%B0%EC%9E%90-%EC%98%A4%EB%B2%84%EB%A1%9C%EB%94%A9-------)
  - [7.2 비교 연산자 오버로딩](#72-%EB%B9%84%EA%B5%90-%EC%97%B0%EC%82%B0%EC%9E%90-%EC%98%A4%EB%B2%84%EB%A1%9C%EB%94%A9)
    - [7.2.1 equals, ==, ===](#721-equals--)
    - [7.2.2 compareTo, >, <](#722-compareto--)
  - [7.3 컬렉션과 범위](#73-%EC%BB%AC%EB%A0%89%EC%85%98%EA%B3%BC-%EB%B2%94%EC%9C%84)
    - [7.3.1 get, set, []](#731-get-set-)
    - [7.3.2 in](#732-in)
    - [7.3.3 rangeTo, a..z](#733-rangeto-az)
    - [7.3.4 for loop, iterator](#734-for-loop-iterator)
  - [7.4 구조 분해 선언과 component 함수](#74-%EA%B5%AC%EC%A1%B0-%EB%B6%84%ED%95%B4-%EC%84%A0%EC%96%B8%EA%B3%BC-component-%ED%95%A8%EC%88%98)
    - [7.4.1 구조 분해 선언과 루프](#741-%EA%B5%AC%EC%A1%B0-%EB%B6%84%ED%95%B4-%EC%84%A0%EC%96%B8%EA%B3%BC-%EB%A3%A8%ED%94%84)
  - [7.5 프로퍼티 접근자 로직 재활용: 위임 프로퍼티](#75-%ED%94%84%EB%A1%9C%ED%8D%BC%ED%8B%B0-%EC%A0%91%EA%B7%BC%EC%9E%90-%EB%A1%9C%EC%A7%81-%EC%9E%AC%ED%99%9C%EC%9A%A9-%EC%9C%84%EC%9E%84-%ED%94%84%EB%A1%9C%ED%8D%BC%ED%8B%B0)
    - [7.5.2 위임 프로퍼티 사용: by lazy() 를 사용한 프로퍼티 초기화 지연](#752-%EC%9C%84%EC%9E%84-%ED%94%84%EB%A1%9C%ED%8D%BC%ED%8B%B0-%EC%82%AC%EC%9A%A9-by-lazy-%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%9C-%ED%94%84%EB%A1%9C%ED%8D%BC%ED%8B%B0-%EC%B4%88%EA%B8%B0%ED%99%94-%EC%A7%80%EC%97%B0)
    - [7.5.3 위임 프로퍼티 구현](#753-%EC%9C%84%EC%9E%84-%ED%94%84%EB%A1%9C%ED%8D%BC%ED%8B%B0-%EA%B5%AC%ED%98%84)
    - [7.5.4 위임 프로퍼티 컴파일 규칙](#754-%EC%9C%84%EC%9E%84-%ED%94%84%EB%A1%9C%ED%8D%BC%ED%8B%B0-%EC%BB%B4%ED%8C%8C%EC%9D%BC-%EA%B7%9C%EC%B9%99)
    - [7.5.5 프로퍼티 값을 맵에 저장](#755-%ED%94%84%EB%A1%9C%ED%8D%BC%ED%8B%B0-%EA%B0%92%EC%9D%84-%EB%A7%B5%EC%97%90-%EC%A0%80%EC%9E%A5)
    - [7.5.6 프레임워크에서 위임 프로퍼티 사용](#756-%ED%94%84%EB%A0%88%EC%9E%84%EC%9B%8C%ED%81%AC%EC%97%90%EC%84%9C-%EC%9C%84%EC%9E%84-%ED%94%84%EB%A1%9C%ED%8D%BC%ED%8B%B0-%EC%82%AC%EC%9A%A9)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# 7장 연산자 오버로딩과 기타 관례

다루는 것

* 산술, 비교 연산자 오버로딩
* 비트 연산자
* 컬렉션, 범위 관례 convention
* 구조 분해 선언. component1, component2, componentN
* 위임 프로퍼티, by, by lazy, getValue, setValue
* 프로퍼티 변경 통지. Delegates.observable

언어 기능을 타입에 의존하는 자바와 달리 코틀린에서는 관례 convention 에 의존합니다. 이는 기존 자바 클래스들 역시 코틀린에서 사용하기 위함입니다.

## 7.1 산술 연산자 오버로딩

[1_operator.kts](1_operator.kts)

### 7.1.1 이항 산술 연산 오버로딩 + - * / %

* plus, minus, times, div, mod(1.1부터 rem)

연산자 우선 순위는 표준 숫자 타입과 같습니다. 곱하기, 나누기, 모듈러가 우선순위가 같고, 더하기, 빼기는 그것보다 낮습니다.

두 피연산자의 타입이 달라도, 결과 타입이 달라도 연산자를 정의할 수 있습니다.

하지만 코틀린이 자동으로 교환 법칙 (a op b == b op a) 를 지원하지 않음에 유의해야 합니다.

비트 연산

* << : shl
* \>> : shr
* \>>> : ushr
* & : and
* | : or
* ^ : xor
* - : inv
    
### 7.1.2 복합 대입 연산자 오버로딩 += -=

이론적으로는 코드에 있는 += 를 plus, plusAssign 양쪽을 컴파일 할 수 있지만, 두 함수를 모두 정의하고 둘 다 += 에 사용 가능한 경우에는 컴파일 에러가 발생합니다.

일반 연산자를 사용하거나, var 를 val 로 바꾸어서 plusAssign 을 못하게 할 수 있겠지만, 일관성있게 클래스를 설계하는 것이 좋으므로 두 연산을 동시에 정의하지 않는게 좋습니다.

+,- 는 항상 새로운 컬렉션을 반환하며, +=, -= 는 항상 변경 가능한 컬렉션에 작용해 메모리에 있는 객체 상태를 변경합니다. 또한 읽기 전용 컬렉션에서 +=, -= 는 변경을 적용한 복사본을 반환합니다.

이런 연산자의 피연산자로는 개별 원소를 사용하거나, 원소 타입이 일치하는 다른 컬렉션을 사용할 수 있습니다. (list + list)

### 7.1.3 단항 연산자 오버로딩 + - ++ --

* +a : unaryPlus()
* -a : unaryMinus()
* !a : not()
* ++a, a++ : inc()
* --a, a-- : dec()

## 7.2 비교 연산자 오버로딩

### 7.2.1 equals, ==, ===

코틀린에서는 ==, != 연산자를 사용하는 식은 equals 호출로 컴파일 됩니다. 널인 경우 둘다 널인 경우에만 true 가 반환됩니다.

equals 메서드는 Any 클래스에 정의되어 있습니다.

식별자 비교 === 은 오버로딩 할 수 없습니다.

### 7.2.2 compareTo, >, <

자바에서 정렬, 최댓값, 최솟값 등을 비교하기 위해서는 Comparable 인터페이스를 구현했어야 했습니다.

자바에서는 원시 타입의 값만 >, < 로 비교할 수 있고, 다른 모든 타입의 값은 e1.compareTo(e2) 와 같이 명시적으로 사용해야 했습니다.

코틀린에서는 Comparable 인터페이스를 제공해주고, compareTo() 메서드를 구현하여 비교 연산자를 사용할 수 있습니다.

* <
* \>
* <=
* \>=

## 7.3 컬렉션과 범위

### 7.3.1 get, set, []

get, set 메서드를 정의하면 [key] = value, [] 인덱스 연산자를 사용할 수 있습니다.

x[a, b] ==> x.get(a, b)

```kotlin
operator fun get(rowIndex: Int, colIndex: Int)

matrix[row, col] = value // 2차원 배열도 가능
```

### 7.3.2 in

in 은 객체가 컬렉션에 존재하는지 검사합니다. contains() 메서드를 구현합니다.

### 7.3.3 rangeTo, a..z

범위를 만드려면 .. 구문을 사용합니다. rangeTo() 메서드를 구현합니다.

start..end ==> start.rangeTo(end)

어떤 클래스가 Comparable 인터페이스를 구현하면 rangeTo 를 정의할 필요가 없습니다.

```kotlin
operator fun <T: Comparable<T>> T.rangeTo(that: T): ClosedRange<T> // 이 함수는 범위를 반환합니다.

val now = LocalData.now()
val vacation = now..now.plusDays(10)
println(now.plusWeeks(1) in vacation) // true
```

rangeTo 는 LocalData 의 멤버 함수가 아니라 Comparable 의 확장 함수 입니다.

rangeTo 연산자는 다른 산술 연산자보다 우선순위가 낮아서 괄호로 감싸주면 좋습니다.

```kotlin
println(0..(n+1))
(0..n).forEach { print(it) }
```

### 7.3.4 for loop, iterator

for (x in list) { ... } 와 같은 문장은 list.iterator() 를 호출해서 이터레이터를 얻은 뒤, hasNext(), next() 호출을 반복하는 식으로 변환됩니다.

iterator 메서드를 확장 함수로 정의하고 있습니다.

```kotlin
operator fun CharSequence.iterator(): CharSequence // 문자열을 이터레이션 할 수 있게 해줌
```

[2_iterator.kts](2_iterator.kts)

## 7.4 구조 분해 선언과 component 함수

```kotlin
val p = Point(10, 20)
val (x, y) = p
```

일반 변수 선언과 비슷해보이지만, = 의 좌변에 여러 변수를 괄호로 묶었습니다.

val (a, b) = p ==> val a = p.component1(), val b = p.component2()

data 클래스의 주 생성자에 들어있는 프로퍼티에 대해서 컴파일러 자동으로 componentN 함수를 생성해줍니다.

클래스에서는 직접 선언할 수 있습니다.

```kotlin
class Point(val x: int, val y: Int) {
    operator fun component1() = x
    operator fun component2() = y
}
```

구조 분해 선언을 함수에서 여러 값을 반환할때 유용합니다. 반환해야 하는 모든 값이 들어가는 데이터 클래스를 정의하고, 함수의 반환 타입을 그 데이터 클래스로 바꿉니다.

컬렉션에 대해서도 맨 앞 다섯 원소까지는 componentN 을 제공하므로 유용합니다.

Pair, Triple 함수를 사용하면 간단하게 여러 값을 반환 가능하지만, 의미를 알 수는 없기에 가독성이 떨어지는 반면 코드는 더 단순해집니다.

[3_destructuring.kts](3_destructuring.kts)

### 7.4.1 구조 분해 선언과 루프

map 을 순회할때 (key, value) 로 구조 분해가 가능합니다.

Map.Entry 에 .component1(), .component2() 로 key, value 를 받을 수 있는 확장함수를 제공합니다.

## 7.5 프로퍼티 접근자 로직 재활용: 위임 프로퍼티

위임 프로퍼티를 사용하면 값을 뒷받침하는 필드에 단순히 저장하는 것보다 더 복잡한 방식으로 작동하는 프로퍼티를 구현할 수 있습니다.

프로퍼티는 위임을 사용해 자신의 값을 필드가 아니라 데이터베이스 테이블이나 브라우저 세션, 맵 등에 저장할 수 있습니다.

위임은 객체가 직접 작업을 수행하지 않고, 다른 도우미 객체, 위임 객체에게 처리를 맡기는 디자인 패턴입니다.

```kotlin
class Foo P {
    var p: Type by Delegate()
}

// Foo 클래스는 아래와 같이 작동합니다. p 프로퍼티에 접근시 getValue, setValue 메서드를 호출합니다.
class Foo {
    private val delegate = Delegate()
    var p: Type
    set(value: Type) = deletegate.setValue(..., value)
    get() = delegate.getValue(...)
}
```

프로퍼티 위임 관례를 따르는 Delegate 클래스는 getValue, setValue 메서드를 제공해야 합니다. (변경 가능한 프로퍼티만 setValue 를 제공)

다른 경우와 마찬가지로 getValue, setValue 는 멤버 메서드일수도 있고, 확장 함수일수도 있습니다.

```kotlin

class Delegate {
    operator fun getValue(...) { ... }
    operator fun setValue(..., value: Type) { ... }
}
class Foo {
    var p: Type by Delegate()
}

>>> val foo = Foo()
>>> val oldValue = foo.p // 내부적으로 delegate.getValue() 호출
>>> foo.p = newValue // 내부적으로 deletegate.setValue(..., newValue) 호출
```

### 7.5.2 위임 프로퍼티 사용: by lazy() 를 사용한 프로퍼티 초기화 지연

지연 초기화는 객체의 일부분을 초기화하지 않고, 실제로 그 부분의 값이 필요할 경우 초기화할때 쓰이는 패턴입니다.

초기화 과정에서 자원을 많이 사용하거나, 꼭 초기화되지 않아도 되는 부분에 사용할 수 있습니다.

[4_by_lazy.kts](4_by_lazy.kts)

초기 구현에서는 뒷받침하는 프로퍼티, 백킹 프로퍼티 backing property 라는 기법을 사용했습니다. _emails 라는 프로퍼티는 값을 저장하고, 다른 프로퍼티인 emails 는 _emails 프로퍼티에 대한 읽기 연산을 제공합니다.

lazy 를 by 키워드와 함께 위임 프로퍼티를 쉽게 만들 수 있습니다. lazy 함수의 인자는 값을 초기화할때 호출할 람다입니다.

lazy 함수는 기본적으로 thread safe 하지만, 필요에 따라 동기화에 사용할 Lock 을 lazy 함수에 전달 할 수도 있고, 다중 스레드 환경에서 사용하지 않을 프로퍼티를 위해 lazy 함수가 동기화를 하지 못하게 막을 수도 있습니다.

### 7.5.3 위임 프로퍼티 구현

어떤 객체의 프로퍼티가 바뀔 때마다 리스너에게 변경 통지를 보내고 싶은 케이스를 살펴봅시다.

자바에서는 PropertyChangeSupport, PropertyChangeEvent 클래스를 사용해 이런 통지를 처리하는 경우가 자주 있습니다.

코틀린에서 위임 프로퍼티 없이 이런 기능을 구현하고, 위임 프로퍼티를 사용하는 리팩토링을 해보겠습니다.

[5_property_change_support.kts](5_property_change_support.kts)

이 코드는 field 키워드를 사용해 age, salary 프로퍼티의 백킹 프로퍼티에 접근하는 방법을 보여줍니다. setter 코드를 보면 중복이 많이 보입니다.

[6_observable_property.kts](6_observable_property.kts)

이 코드는 코틀린의 위임이 실제로 작동하는 방식과 비슷합니다. 프로퍼티 값을 저장하고 그 값이 바뀌면 자동으로 변경 통지를 전달해주는 클래스를 만들었고, setter 중복부분을 상당 부분 제거했습니다.

하지만 아직도 작업 위임을 준비하는 코드가 상당히 많이 필요합니다.

[7_observable_property_by.kts](7_observable_property_by.kts)

```kotlin
class Person(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    var age: Int by ObservableProperty(age, changeSupport)
    var salary: Int by ObservableProperty(salary, changeSupport)
}

```

getValue, setValue 함수를 operator 변경자를 붙여서 작성해주고, KProperty 타입 객체를 사용해 프로퍼티를 표현합니다.

그리고 by 키워드를 사용해 위임 객체를 지정해주면 이전 예제에서 직접 코드를 짜야 했던 어려 작업을 코틀린 컴파일러가 자동으로 처리해줍니다.

관찰 가능한 프로퍼티 로직 `ObservableProperty` 클래스를 직접 작성하는 대신 코틀린 표준 라이브러리를 사용할 수 있습니다.

다만 이 표준 라이브러리는 PropertyChangeSupport 와는 연결돼 있지 않아서 PropertyChangeSupport 를 사용하는 방법을 알려주는 람다를 넘겨주어야 합니다.

[8_delegates_observable_by.kts](8_delegates_observable_by.kts)

```kotlin

class Person(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    private val observer = { prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)
}
```

by 오른쪽 식이 항상 새 인스턴스를 만들 필요는 없고, 함수 호출, 다른 프로퍼티, 다른 식 등이 by 우항에 올 수 있습니다.

다만 우항에 있는 식을 계산한 결과 객체가 컴파일러가 호출할 수 있는 올바른 타입의 getValue, setValue 를 반드시 제공해야 합니다.

getValue, setValue 는 멤버 메서드일수도, 확장 함수 일수도 있습니다.

예제에서는 Int 타입만을 사용했지만, 모든 타입에 두루두루 사용할 수 있습니다.

### 7.5.4 위임 프로퍼티 컴파일 규칙

위임 프로퍼티가 실제로 어떤 방식으로 동작하는지 알아보겠습니다.

```kotlin
class C {
    var prop: Type by MyDelegate()
}
val c = C()
```

컴파일러는 MyDelete 클래스의 인스턴스를 감춰진 프로퍼티에 저장하며, 그 감춰진 프로퍼티를 <delegate> 라는 이름으로 부릅니다. 또한 컴파일러는 프로퍼티를 표현하기 위해 KProperty 타입의 객체를 사용합니다. 이 객체를 <property> 라고 부릅니다.

컴파일러는 다음 코드를 생성합니다.

```kotlin
class C {
    private val <delegate> = MyDelegate()
    var prop: Type
    get() = <delegate>.getValue(this, <property>)
    set(value: Type) = <delegate>.setValue(this, <property>, value)
}
```

다시 말해 컴파일러는 모든 프로퍼티 접근자 안에 getValue, setValue 호출 코드를 생성해줍니다.

이 메커니즘은 단순하지만, 값이 저장될 장소를 바꾼다거나, 프로퍼티를 읽거나 쓸때 벌어질 일을 변경할 수도 있는 등 흥미로운 활용법이 많습니다.

### 7.5.5 프로퍼티 값을 맵에 저장

[9_attribute_map.kts](9_attribute_map.kts)

by 키워드 뒤에 맵을 넘겨주면 맵을 위임 객체로 사용할 수 있습니다. 이는 Map, MutableMap 인터페이스에서 getValue, setValue 확장 함수를 제공해주기에 가능합니다.

### 7.5.6 프레임워크에서 위임 프로퍼티 사용

```kotlin
object Users: IdTable() {
    val name = varchar("name", length = 50).index()
    val age = integer("age")
}

class User(id: EntityId): Entity(id) {
    var name: String by Users.name
    var age: Int by Users.age
}
```

데이터베이스는 전체에 단 하나만 존재하므로 object 객체로 선언하였습니다. 객체의 프로퍼티는 테이블 칼럼을 표현합니다.

User 상위 클래스인 Entity 클래스는 데이터베이스 칼럼을 엔티티의 속성값으로 연결해주는 매핑이 있습니다.

이 프레임워크를 사용하면 User 프로퍼티에 접근할때 자동으로 Entity 클래스에 정의된 데이터베이스 매핑으로부터 필요한 값을 가져오므로 편리합니다.

어떤 User 객체를 변경하면 그 객체는 변경됨 dirty 상태로 변하고, 프레임워크는 나중에 적절히 데이터베이스에 변경 내용을 반영합니다.

각 엔티티 속성은 위임 프로퍼티이며, 칼럼 객체 (Users.name, Users.age)를 위임 객체로 사용합니다. 이를 위해 getValue, setValue 메서드를 Column 클래스 안에 정의해야 합니다.

```kotlin
operator fun <T> Column<T>.getValue(o: Entity, desc: KProperty<*>): T {
    // 데이터베이스에서 값 가져오기
}
operator fun <T> Column<T>.setValue(o: Entity, desc: KProperty<*>, value: T) {
    // 데이터베이스에서 값 변경하기
}
```

user.age += 1 이라는 코드를 사용하면 실제로는 user.ageDelegate.setValue(users.ageDelegate.getValue() + 1) 과 비슷한 코드로 변환됩니다.

이 예제의 완전한 구현을 Exposed 프레임워크 소스코드에서 볼 수 있습니다. 11장에서 Exposed 프레임워크에 사용한 DSL 설계 기법을 봅니다.

> https://github.com/JetBrains/Exposed
