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

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# 7장 연산자 오버로딩과 기타 관례

다루는 것

* 산술, 비교 연산자 오버로딩
* 비트 연산자
* 컬렉션, 범위 관례 convention

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



