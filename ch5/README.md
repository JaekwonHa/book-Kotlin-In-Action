<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [5장 람다로 프로그래밍](#5%EC%9E%A5-%EB%9E%8C%EB%8B%A4%EB%A1%9C-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D)
  - [5.1 람다 식과 멤버 참조](#51-%EB%9E%8C%EB%8B%A4-%EC%8B%9D%EA%B3%BC-%EB%A9%A4%EB%B2%84-%EC%B0%B8%EC%A1%B0)
    - [5.1.1 람다 소개: 코드 블록을 함수 인자로 넘기기](#511-%EB%9E%8C%EB%8B%A4-%EC%86%8C%EA%B0%9C-%EC%BD%94%EB%93%9C-%EB%B8%94%EB%A1%9D%EC%9D%84-%ED%95%A8%EC%88%98-%EC%9D%B8%EC%9E%90%EB%A1%9C-%EB%84%98%EA%B8%B0%EA%B8%B0)
    - [5.1.2 람다와 컬렉션](#512-%EB%9E%8C%EB%8B%A4%EC%99%80-%EC%BB%AC%EB%A0%89%EC%85%98)
    - [5.1.3 람다 식의 문법](#513-%EB%9E%8C%EB%8B%A4-%EC%8B%9D%EC%9D%98-%EB%AC%B8%EB%B2%95)
    - [5.1.4 현재 영역에 있는 변수에 접근](#514-%ED%98%84%EC%9E%AC-%EC%98%81%EC%97%AD%EC%97%90-%EC%9E%88%EB%8A%94-%EB%B3%80%EC%88%98%EC%97%90-%EC%A0%91%EA%B7%BC)
      - [변경 가능한 변수 포획하기: 자세한 구현 방법](#%EB%B3%80%EA%B2%BD-%EA%B0%80%EB%8A%A5%ED%95%9C-%EB%B3%80%EC%88%98-%ED%8F%AC%ED%9A%8D%ED%95%98%EA%B8%B0-%EC%9E%90%EC%84%B8%ED%95%9C-%EA%B5%AC%ED%98%84-%EB%B0%A9%EB%B2%95)
    - [5.1.5 멤버 참조](#515-%EB%A9%A4%EB%B2%84-%EC%B0%B8%EC%A1%B0)
  - [5.2 컬렉션 함수형 API](#52-%EC%BB%AC%EB%A0%89%EC%85%98-%ED%95%A8%EC%88%98%ED%98%95-api)
    - [5.2.1 필수적인 함수: filter, map](#521-%ED%95%84%EC%88%98%EC%A0%81%EC%9D%B8-%ED%95%A8%EC%88%98-filter-map)
    - [5.2.2 all, any, count, fund: 컬렉션에 술어 적용](#522-all-any-count-fund-%EC%BB%AC%EB%A0%89%EC%85%98%EC%97%90-%EC%88%A0%EC%96%B4-%EC%A0%81%EC%9A%A9)
    - [5.2.3 groupBy: 리스트를 어러 그룹으로 이뤄진 맵으로 변경](#523-groupby-%EB%A6%AC%EC%8A%A4%ED%8A%B8%EB%A5%BC-%EC%96%B4%EB%9F%AC-%EA%B7%B8%EB%A3%B9%EC%9C%BC%EB%A1%9C-%EC%9D%B4%EB%A4%84%EC%A7%84-%EB%A7%B5%EC%9C%BC%EB%A1%9C-%EB%B3%80%EA%B2%BD)
    - [5.2.4 flatMap, flatten: 중첩된 컬렉션 안의 원소 처리](#524-flatmap-flatten-%EC%A4%91%EC%B2%A9%EB%90%9C-%EC%BB%AC%EB%A0%89%EC%85%98-%EC%95%88%EC%9D%98-%EC%9B%90%EC%86%8C-%EC%B2%98%EB%A6%AC)
  - [5.3 지연 계산(lazy) 컬렉션 연산](#53-%EC%A7%80%EC%97%B0-%EA%B3%84%EC%82%B0lazy-%EC%BB%AC%EB%A0%89%EC%85%98-%EC%97%B0%EC%82%B0)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# 5장 람다로 프로그래밍

다루는 내용
* 람다식 문법
* 람다와 무명 클래스의 차이점
* 자바 람다와 코틀린 람다의 차이점
* 자바 스트림, 코틀린 시퀀스
* 스트림, 시퀀스의 지연 연산
* 람다가 변수를 캡쳐할때
* 수신 객체 지정 함수: with, apply

## 5.1 람다 식과 멤버 참조

### 5.1.1 람다 소개: 코드 블록을 함수 인자로 넘기기

자바에서 무명 내부 클래스를 선언하면 코드가 장황해졌는데, 람다식을 쓰면 불필요한 코드를 제거 할 수 있습니다.

### 5.1.2 람다와 컬렉션

코틀린에서는 많은 컬렉션 API 를 제공하고, 컬렉션 API 를 사용할때 람다식을 활용할 수 있습니다.

```kotlin
val people = listOf(Person("Alice", 29), Person("Bob", 31))
// 람다 사용
println(people.maxBy { it.age })

// 멤버 참조 사용
people.maxBy(Person::age)
```

자바 컬렉션에 대해 수행하던 대부분의 작업은 람다나 멤버 참조를 인자로 전달함으로써 코드를 더 짧고 이해하기 쉽게 만들 수 있습니다.

### 5.1.3 람다 식의 문법

코틀린 람다 식은 항상 중괄호로 둘러싸여 있습니다. 람다식은 변수에도 저장할 수 있습니다.

```kotlin
val sum = { x: Int, y: Int -> x + y}
println(sum(1, 2))
```

코틀린에서는 함수 호출 시 마지막 인자가 람다식이라면 그 람다를 괄호 밖으로 빼낼 수 있다는 문법 관습이 있습니다.

```kotlin
// 다양한 방식으로 람다 사용 가능
people.maxBy { it.age }
people.maxBy({ p: Person -> p.age })
people.maxBy() { p: Person -> p.age }
people.maxBy { p: Person -> p.age }
people.maxBy { p -> p.age } // 컴파일러가 타입 추론
```

람다식이 중첩된다면 it 대신 파라미터를 명시하는 것이 좋습니다.

### 5.1.4 현재 영역에 있는 변수에 접근

람다를 함수 안에서 정의하면 함수의 파라미터뿐 아니라 람다 정의의 앞에 선언된 로컬 변수에도 접근 할 수 있습니다.
자바와 다른 점은 코틀린 람다 안에서는 파이널 변수가 아닌 변수에도 접근할 수도 있고, 수정할 수도 있습니다. 이를 람다가 포획 capture 한 변수라고 합니다.

기본적으로 함수 안에서 정의된 로컬 변수의 생명 주기는 함수가 반환되면 종료됩니다. 하지만 어떤 함수가 자신의 로컬 변수를 캡쳐한 람다를 반환하거나, 다른 변수에 저장한다면 로컬 변수의 생명주기와 함수의 생명주기가 달라질 수 있습니다. 캡쳐한 변수가 있는 람다를 저장해서 함수가 끝난 뒤에 실행하면 람다의 본문 코드는 여전히 포획한 변수를 읽거나 쓸 수 있습니다.

이런 동작의 원리는 파이널 변수(val)를 캡쳐한 경우에는 람다 코드를 변수 값과 함께 저장합니다. 파이널이 아닌 변수(var)를 포획한 경우에는 변수를 특별한 래퍼로 감싸서 나중에 변경하거나 읽을 수 있게 하고, 래퍼에 대한 참조를 람다 코드와 함께 저장합니다.

#### 변경 가능한 변수 포획하기: 자세한 구현 방법

자바에서는 파이널 변수만 캡쳐할 수 있지만, 트릭이 존재합니다. 변경 가능한 변수를 원소 1개짜리 배열에 선언하거나, 변경 가능한 변수를 필드로 가지는 클래스를 선언함으로써 회피할 수 있습니다.

```kotlin
class Ref<T>(var value: T)

val counter = Ref(0)
val inc = { counter.value++ }
```

한가지 알아둬야할 함정은 람다를 이벤트 핸들러나 다른 비동기적으로 실행되는 코드로 활용하는 경우 함수 호출이 끝난 다음에 로컬 변수가 변경될 수 있습니다.

```kotlin
fun tryToCountButtonClicks(button: Button): Int {
    var clicks = 0
    button.onClick { clicks++ }
    return clicks
}
```

이 함수는 항상 0을 반환합니다. 핸들러가 함수 종료 후에 호출되기 때문입니다.

### 5.1.5 멤버 참조

::을 사용하는 식을 멤버 참조라고 합니다. 멤버 참조는 프로퍼티나 메서드에 사용할 수 있습니다.

```kotlin
people.maxBy(Person::age)
people.maxBy { p -> p.age }
people.maxBy { it.age }
```

최상위에 선언된 함수나 프로퍼티도 참조할 수 있습니다.

```kotlin
fun salute() = println("Salute!")
run(::salute)
```

람다가 인자가 여럿인 다른 함수한테 작업을 위임하는 경우 람다를 정의하지 않고, 직접 위임 함수에 대한 참조를 제공하면 편리합니다.

```kotlin
// 이 람다는 sendEmail 함수에게 작업을 위임
val action = { person: Person, message: String -> sendEmail(person, message)}
// 람다 대신 멤버 참조를 대신 사용
val nextAction = ::sendEmail 
```

생성자 참조를 사용하면 클래스 생성 작업을 연기하거나 저장할 수 있고, 확장 함수도 멤버 함수와 똑같은 방식으로 참조할 수 있습니다.

```kotlin
data class Person(val name: String, val age: Int)
val createPerson = ::Person
val p = createPerson("Alice", 29)

fun Person.isAdult() = age >= 21
val predicate = Person::isAdult
```

> 바운드 멤버 참조
> 
> 바운드 멤버 참조를 사용하면 멤버 참조를 생성할 때 클래스 인스턴스를 함께 저장한 다음 나중에 그 인스턴스에 대한 멤버를 호출해줍니다. 따라서 호출 시 수신 대상 객체를 별도로 지정해 줄 필요가 없습니다.
> 
> ```kotlin
> val p = Person("Dmitry", 34)
> val personAgeFunction = Person::age
> println(personsAgeFunction(p) // 코틀린 1.0 에서의 방식. p 클래스 인스턴스를 넘겨주어야함
> 
> val dimitrysAgeFunction = p::age // 코틀린 1.1 부터 사용할 수 있는 바운드 멤버 참조
> println(dmitrysAgeFunction())
> ```

## 5.2 컬렉션 함수형 API

### 5.2.1 필수적인 함수: filter, map

### 5.2.2 all, any, count, fund: 컬렉션에 술어 적용

### 5.2.3 groupBy: 리스트를 어러 그룹으로 이뤄진 맵으로 변경

### 5.2.4 flatMap, flatten: 중첩된 컬렉션 안의 원소 처리

## 5.3 지연 계산(lazy) 컬렉션 연산

앞서 살펴본 map, filter 같은 컬렉션 함수는 결과 컬렉션을 즉시 생성합니다. 이는 컬렉션 함수를 연쇄하면 매 단계마다 계산 중간 결과를 새로운 컬렉션에 임시로 담는다는 말입니다. 원소가 몇개되지 않는다면 상관없겠지만, 원소가 수백만개가 되면 효율이 떨어집니다.

시퀀스 sequence 를 사용하면 원소를 필요로 할때 비로소 계산됩니다. 큰 컬렉션에 대해서 연산을 연쇄시킬 때는 시퀀스를 사용하는 것이 좋습니다.

### 5.3.1 시퀀스 연산 실행: 중간 연산과 최종 연산

`sequence.map { ... }.filter { ... }.toLilst()` 에서 `toList()` 는 최종 연산이고, 그 전은 중간 연산입니다.

최종연산이 수행되지 않으면 중간 연산도 수행되지 않습니다.

시퀀스의 경우 모든 연산은 각 원소에 대해 순차적으로 적용됩니다. 첫번째 원소가 처리되고 난 후 두번째 원소가 처리됩니다.

따라서 원소에 연산을 차례대로 적용하다가 결과가 얻어지면 그 이후의 원소에 대해서는 변환이 이뤄지지 않을 수도 있습니다.

map -> find 연산을 수행한다고 했을때, 컬렉션을 사용하면 모든 원소에 map 연산을 수행 후 find 연산을 수행해 1개 원소를 찾지만, 시퀀스의 경우 각 원소에 대해 차례대로 map -> find 연산을 수행하기 때문에 find 로 원소가 찾아지면 이후 연산을 수행하지 않습니다.

map -> filter / filter -> map 연산의 경우에도 결과는 같을지라도 변환의 전체 횟수는 다릅니다.

> 자바 스트림과 코틀린 시퀀스 비교
> 
> 코틀린 시퀀스의 개념은 자바의 스트림과 같습니다. 코틀린에서 같은 개념을 별도로 구현해둔 이유는 예전 자바 (자바 8 이전)와의 호환성을 위해서 입니다.
> 
> 자바 8을 채택하면 스트림 연산을 여러 CPU 에서 병렬적으로 실행하는 기능을 사용할 수 있습니다. 필요와 사용할 자바 버전에 따라서 시퀀스와 스트림 중 적절한 것을 사용하면 됩니다.

### 5.3.2 시퀀스 만들기

```kotlin
val naturalNumbers = generateSequence(0) { it + 1 }
val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
println(numbersTo100.sum())
```

`generateSequence()` 함수를 사용하여 시퀀스를 만들 수 있습니다. 시퀀스는 연산을 지연 계산하여, 최종 연산을 수행하기 전까지는 시퀀스의 각 숫자는 계산되지 않습니다. (여기서는 sum()이 최종연산)

## 5.4 자바 함수형 인터페이스 활용

코틀린 람다를 자바 API 에 사용해도 전혀 문제되지 않습니다. 자바 8 이전의 자바에서는 람다 대신 무명 클래스의 인스턴스를 넘겨주었습니다. 코틀린에서는 람다를 대신 넘길 수 있습니다.

추상 메서드가 단 하나만 있는 인터페이스를 함수형 인터페이스 functional interface 또는 SAM single abstract method 인터페이스라고 합니다.

### 5.4.1 자바 메서드에 람다를 인자로 전달

코틀린에서 함수형 인터페이스를 인자로 원하는 자바 메서드에 람다를 전달하면 컴파일러는, 예를 들면 Runnable 인터페이스라면, 'Runnable 인스턴스' 즉 'Runnable 을 구현한 무명 클래스의 인스턴스' 를 만들어 넘겨줍니다.

```kotlin
// 객체 식을 함수형 인터페이스로 넘깁니다. 이때는 메서드를 호출할때마다 항상 새로운 객체가 생성됩니다.
postponeComputation(1000, object : Runnable {
    override fun run() {
        println(42)
    }
})

// 프로그램 전체에서 Runnable 의 인스턴스는 단 하나만 만들어진다.
postponeComputation(1000) { println(42) }

val runnable = Runnable { println(42) } // 전연 변수로 컴파일되므로 프로그램 안에 단 하나의 인스턴스만 존재한다.
fun handleComputation() {
    postponeComputation(1000, runnable) // 모든 handleComputation 호출에 같은 객체를 사용한다.
}
```

람다가 주변 영역의 변수를 캡쳐한다면 매 호출마다 같은 인스턴스를 사용할 수 없습니다. 그런 경우 매번 주변 영역의 변수를 캡쳐한 새로운 인스턴스를 생성합니다.

```kotlin
fun handleComputation(id: String) {
    postponeComputation(1000) { println(id) } // handleComputation 을 호출할때마다 새로 Runnable 인스턴스를 만든다.
}
```

> 람다의 자세한 구현
> 
> 람다가 변수를 캡쳐하면 무명 클래스 안에 포획한 변수를 저장하는 필드가 생기며, 매 호출마다 그 무명 클래스의 인스턴스를 새로 만듭니다. 캡쳐하는 변수가 없는 람다는 인스턴스가 단 하나만 생깁니다.
> 
> 캡쳐가 있는 람다 식을 디컴파일 해보면 아래와 같습니다.
> 
> ```kotlin
> class HandleComputation$1(val id: String) : Runnable {
>   override fun run() {
>     println(id)
>   }
> }
> fun handleComputation(id: String) {
>   postponeComputation(1000, HandleComputation$1(id)) // 내부적으로는 람다 대신 특별한 클래스의 인스턴스가 만들어집니다.
> }
> ```

함수형 인터페이스를 인자로 받는 자바 메서드에 람다를 넘기면, 무명 클래스를 만들고, 그 클래스의 인스턴스를 만들어서 메서드에 넘긴다는 방식은 셜명이 되지만, 컬렉션을 확장한 메서드에 람다를 넘기는 경우는 이런 방식을 사용하지 않습니다.

inline 으로 표시된 코틀린 함수에게 람다를 넘기면 무명 클래스가 생기지 않습니다. 대부분의 코틀린 확장 함수는 inline 으로 되어 있는데, 이는 8.2 절에서 설명합니다.

### 5.4.2 SAM 생성자: 람다를 함수형 인터페이스로 명시적으로 변경

람다와 함수형 인터페이스 간의 변환은 자동으로 이뤄지지만, 수동으로 변환해야 하는 경우에는 어떻게 할 수 있을까요.

SAM 생성자는 람다를 함수형 인터페이스의 인스턴스로 변환할 수 있게 컴파일러가 자동으로 생성한 함수입니다. 컴파일러가 자동으로 람다를 함수형 인터페이스 무명 클래스로 바꾸지 못하는 경우 SAM 생성자를 사용합니다.

예를 들어 함수형 인터페이스의 인스턴스를 반환하는 메서드가 있다면, 람다를 직접 반환할 수 없고, 반환하고픈 람다를 SAM 생성자로 감싸야 합니다.

```kotlin
fun createAllDoneRunnable() : Runnable {
// SAM 생성자를 사용해 값 반환하기
    return Runnable { println("All Done!") }
}
createAllDoneRunnable().run()
```

람다로 생성한 함수형 인터페이스 인스턴스를 변수에 저장해 재사용할 수도 있습니다.

```kotlin
val listener = OnClickListener { view -> 
    val text = when (view.id) {
        R.id.button1 -> "First Button"
        R.id.button2 -> "Second Button"
        else -> "Unknown Button"
    }
    toast(text)
}
```

함수형 인터페이스를 요구하는 메서드를 호출할때 가끔 오버로드한 메서드 중에서 어떤 타입의 메서드를 선택해 람다를 변환해 넘겨줘야 할지 모호한 때에는 SAM 생성자를 적용하면 컴파일 오류를 피할 수 있습니다.

> 람다, 무명 객체, this
> 
> 람다에는 무명 객체와 달리 인스턴스 자신을 가리키는 this 가 없습니다. 람다에서 this 는 그 람다를 둘러싼 클래스의 인스턴스를 가리킵니다.
> 
> 인스턴스 자신에게 접근해야 하는 경우 람다 대신 무명 객체를 사용해야 합니다.

## 5.5 수신 객체 지정 람다: with 와 apply

### 5.5.1 with 함수

with 함수는 첫번째 파라미터가 수신 객체이고, 두번째 파라미터가 람다식인 메서드입니다.

with 함수는 람다 코드를 실행한 결과를 반환합니다.

```kotlin
fun alphabet() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter) // this.append(letter)
    }
    append("\nNow I know the alphabet !")
    toString()
}
```

> 메서드 이름 충돌
> 
> with 의 인자로 넘긴 객체의 클래스와 with 를 사용하는 코드가 들어있는 클래스 안에 이름이 같은 메서드가 있다면?
> 
> this@OuterClass.toString() 과 같이 명시적으로 호출해줘야 합니다.

### 5.5.2 apply 함수

apply 함수는 람다의 결과 대신 수신 객체를 반환합니다. apply 는 확장함수입니다.

```kotlin
fun alphabet() = StringBuiler().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet !")
}.toString()
```

buildString 표준 라이브러리를 사용하면 StringBuilder 객체를 만드는 일, toString 을 호출하는 일을 단순화할 수 있습니다.

```kotlin
fun alphabet() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}
```
