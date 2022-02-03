<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [8장 고차 함수: 파라미터와 반환 값으로 람다 사용](#8%EC%9E%A5-%EA%B3%A0%EC%B0%A8-%ED%95%A8%EC%88%98-%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0%EC%99%80-%EB%B0%98%ED%99%98-%EA%B0%92%EC%9C%BC%EB%A1%9C-%EB%9E%8C%EB%8B%A4-%EC%82%AC%EC%9A%A9)
  - [8.1 고차 함수 정의](#81-%EA%B3%A0%EC%B0%A8-%ED%95%A8%EC%88%98-%EC%A0%95%EC%9D%98)
    - [8.1.1 함수 타입](#811-%ED%95%A8%EC%88%98-%ED%83%80%EC%9E%85)
    - [8.1.2 인자로 받은 함수 호출](#812-%EC%9D%B8%EC%9E%90%EB%A1%9C-%EB%B0%9B%EC%9D%80-%ED%95%A8%EC%88%98-%ED%98%B8%EC%B6%9C)
    - [8.1.3 자바에서 코틀린 함수 타입 사용](#813-%EC%9E%90%EB%B0%94%EC%97%90%EC%84%9C-%EC%BD%94%ED%8B%80%EB%A6%B0-%ED%95%A8%EC%88%98-%ED%83%80%EC%9E%85-%EC%82%AC%EC%9A%A9)
    - [8.1.4 디폴트 값을 지정한 함수 타입 파라미터나 널이 될 수 있는 함수 타입 파라미터](#814-%EB%94%94%ED%8F%B4%ED%8A%B8-%EA%B0%92%EC%9D%84-%EC%A7%80%EC%A0%95%ED%95%9C-%ED%95%A8%EC%88%98-%ED%83%80%EC%9E%85-%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0%EB%82%98-%EB%84%90%EC%9D%B4-%EB%90%A0-%EC%88%98-%EC%9E%88%EB%8A%94-%ED%95%A8%EC%88%98-%ED%83%80%EC%9E%85-%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0)
    - [8.1.5 함수를 함수에서 반환](#815-%ED%95%A8%EC%88%98%EB%A5%BC-%ED%95%A8%EC%88%98%EC%97%90%EC%84%9C-%EB%B0%98%ED%99%98)
    - [8.1.6 람다를 활용한 중복 제거](#816-%EB%9E%8C%EB%8B%A4%EB%A5%BC-%ED%99%9C%EC%9A%A9%ED%95%9C-%EC%A4%91%EB%B3%B5-%EC%A0%9C%EA%B1%B0)
  - [8.2 inline 함수: 람다의 부가 비용 없애기](#82-inline-%ED%95%A8%EC%88%98-%EB%9E%8C%EB%8B%A4%EC%9D%98-%EB%B6%80%EA%B0%80-%EB%B9%84%EC%9A%A9-%EC%97%86%EC%95%A0%EA%B8%B0)
    - [8.2.1 인라이닝이 작동하는 방식](#821-%EC%9D%B8%EB%9D%BC%EC%9D%B4%EB%8B%9D%EC%9D%B4-%EC%9E%91%EB%8F%99%ED%95%98%EB%8A%94-%EB%B0%A9%EC%8B%9D)
    - [8.2.2 inline 함수의 한계](#822-inline-%ED%95%A8%EC%88%98%EC%9D%98-%ED%95%9C%EA%B3%84)
    - [8.2.3 컬렉션 연산 인라이닝](#823-%EC%BB%AC%EB%A0%89%EC%85%98-%EC%97%B0%EC%82%B0-%EC%9D%B8%EB%9D%BC%EC%9D%B4%EB%8B%9D)
    - [8.2.4 함수를 인라인으로 선언해야 하는 경우](#824-%ED%95%A8%EC%88%98%EB%A5%BC-%EC%9D%B8%EB%9D%BC%EC%9D%B8%EC%9C%BC%EB%A1%9C-%EC%84%A0%EC%96%B8%ED%95%B4%EC%95%BC-%ED%95%98%EB%8A%94-%EA%B2%BD%EC%9A%B0)
    - [8.2.5 자원 관리를 위해 인라인된 람다 사용](#825-%EC%9E%90%EC%9B%90-%EA%B4%80%EB%A6%AC%EB%A5%BC-%EC%9C%84%ED%95%B4-%EC%9D%B8%EB%9D%BC%EC%9D%B8%EB%90%9C-%EB%9E%8C%EB%8B%A4-%EC%82%AC%EC%9A%A9)
  - [8.3 고차 함수 안에서 흐름 제어](#83-%EA%B3%A0%EC%B0%A8-%ED%95%A8%EC%88%98-%EC%95%88%EC%97%90%EC%84%9C-%ED%9D%90%EB%A6%84-%EC%A0%9C%EC%96%B4)
    - [8.3.1 람다 안의 return 문: 람다를 둘러싼 함수로부터 반환](#831-%EB%9E%8C%EB%8B%A4-%EC%95%88%EC%9D%98-return-%EB%AC%B8-%EB%9E%8C%EB%8B%A4%EB%A5%BC-%EB%91%98%EB%9F%AC%EC%8B%BC-%ED%95%A8%EC%88%98%EB%A1%9C%EB%B6%80%ED%84%B0-%EB%B0%98%ED%99%98)
    - [8.3.2 람다로부터 반환: 레이블을 사용한 return](#832-%EB%9E%8C%EB%8B%A4%EB%A1%9C%EB%B6%80%ED%84%B0-%EB%B0%98%ED%99%98-%EB%A0%88%EC%9D%B4%EB%B8%94%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%9C-return)
    - [8.3.3 무명 함수: 기본적으로 로컬 return](#833-%EB%AC%B4%EB%AA%85-%ED%95%A8%EC%88%98-%EA%B8%B0%EB%B3%B8%EC%A0%81%EC%9C%BC%EB%A1%9C-%EB%A1%9C%EC%BB%AC-return)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# 8장 고차 함수: 파라미터와 반환 값으로 람다 사용

다루는 것

* 함수타입, nullable 함수 타입 파라미터, 디폴트 람다
* inline
* try-with-resource, use
* 비로컬 return, 로컬 return, 레이블
* 무명 함수, fun(person) { }

8장에서는 람다를 인자로 받거나, 반환하는 "고차 함수"를 만드는 방법을 배웁니다. 고차 함수를 통해 코드 중복을 없애고, 더 나은 추상화를 구축합니다. 또한 람다를 사용하면서 발생하는 성능상 부가 비용을 inline 함수를 통해 제거하는 방법을 배웁니다.

## 8.1 고차 함수 정의

고차 함수 high order function 란 다른 함수를 인사로 받거나, 함수를 반환하는 함수입니다.

### 8.1.1 함수 타입

람다를 인자로 받는 함수를 정의하려면, 람다 인자의 타입을 어떻게 선언할 수 있을지 알아야 합니다.

```kotlin
val sum: (Int, Int) -> Int = { x, y -> x + y}
val action: () -> Unit = { println(42) }
```

이 경우 코틀린의 타입 추론으로 인해 컴파일러는 sum과 action이 함수 타입임을 추론합니다.

(Int, String) -> Unit

파라미터 타입 -> 반환 타입

Unit 은 생략해도 되지만, 함수 타입을 선언할 때는 반환 타입을 반드시 명시해야 합니다.

지정하는 타입은 nullable 도 가능합니다. 함수의 반환 타입이 아니라, 함수 타입 자체가 널이 될 수 있는 타입이라면 전체를 괄호로 감싸고 ? 를 붙여야 합니다.

`var funOrNull: ((Int, Int) -> Int)? = null`

> 파라미터 이름과 함수 타입
> 
> 함수 타입에서 파라미터 이름을 지정할 수도 있습니다. 하지만 사용할때는 그냥 원하는 다른 이름을 붙여도 됩니다. 인자에 이름을 추가하게 되면 코드 가독성이 좋아지고, IDE 의 자동완성을 사용할 수 있습니다.

### 8.1.2 인자로 받은 함수 호출

```kotlin
fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println(result)
}
```

> Intellij IDEA Tip
> 
> 디버깅시에 람다 코드 내부를 한 단계씩 실행해볼 수 있는 스마트 스태핑 smart stepping 기능을 제공합니다.

### 8.1.3 자바에서 코틀린 함수 타입 사용

컴파일된 코드 안에서 함수 타입은 일반 인터페이스로 바뀝니다. FunctionN 인터페이스를 구현하는 객체를 저장합니다.

Function0<R> (인자가 없는 함수), Function1<P1, R>(인자가 하나인 함수) 등의 인터페이스가 제공되며, 각 인터페이스는 invoke 메서드가 정의되어 있어서 invoke 메서드를 호출하여 함수를 실행할 수 있습니다.

```kotlin
fun processTheAnser(f: (Int) -> Int) {
    println(f(42))
}
```

```java
// java8
processTheAnswer(number->number+1);

// java8 이전
processTheAnswer(
    new Function1<Integer, Integer>() {
        @Override
        public Integer invoke(Integer number) {
            System.out.println(number)
            return number+1
        }
    }
);
```

반환 타입이 Unit 인 함수나 람다를 자바로 작성할 수도 있습니다. 이때 자바에서는 코틀린 Unit 타입 값을 명시적으로 반환해줘야 합니다. 반대로 Unit 반환 타입인 함수 타입에 void 를 반환하는 자바 람다를 넘길 수 없습니다.

### 8.1.4 디폴트 값을 지정한 함수 타입 파라미터나 널이 될 수 있는 함수 타입 파라미터

함수 타입에도 디폴트 값과 nullable 설정을 할 수 있습니다.

```kotlin
fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: ((T) -> String)? = null // 함수 타입을 nullable 로 선언
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        val str = transform?.invoke(element) // safe call 을 사용해 함수 호출
            ?: element.toString() // elvis 연산자로 람다가 null 인 경우를 처리
        result.append(str)
    }
    result.append(postfix)
    return result.toString()
}
```

함수 타입이 nullable 이면 함수를 직접 호출할 수 없습니다. null 여부를 명시적으로 확인(if)하거나, callback?.invoke() 처럼 호출해야 합니다.

### 8.1.5 함수를 함수에서 반환

함수를 반환하는 함수가 유용한 경우를 살펴보겠습니다.

프로그램의 상태나 다른 조건에 따라 달라질 수 있는 로직, 예를 들어 사용자가 선택한 배송 수단에 따라 배송비를 계산하는 방법이 달라질 수 있습니다. 이럴때 적절한 로직을 선택해서 함수로 반환하는 함수를 정의할 수 있습니다.

또는 GUI 연락처 관리 앱을 만드는데 UI의 상태에 따라 어떤 연락처 정보를 표시할지 결정해야 할 필요가 있는 경우도 있습니다.

### 8.1.6 람다를 활용한 중복 제거

함수 타입과 람다 식은 재활용하기 좋은 코드를 만들 때 쓸 수 있는 훌륭한 도구입니다.

```kotlin

fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) = 
    filter(precicate).map(SiteVisit::duration).average()

>>> println(log.averageDurationFor {
    it.os in setOf(OS.ANDROID, OS.IOS) })

12.15

>>> println(log.averageDurationFor {
    it.os == OS.IOS && it.path = "/signup" })
```

## 8.2 inline 함수: 람다의 부가 비용 없애기

5장에서 코틀린이 보통 람다를 무명 클래스로 컴파일하지만, 람다 식을 사용할때마다 새로운 클래스가 만들어지지 않는다고 설명했습니다.

하지만 람다가 변수를 캡쳐하면 람다가 생성되는 시점마다 새로운 무명 클래스 객체가 생깁니다. 이 경우에 실행 시점에 생성 비용이 듭니다.

그렇다면 컴파일러가 자바의 일반 명령문만큼 효율적인 코드를 생성하게 할 수는 없을까요?

### 8.2.1 인라이닝이 작동하는 방식

inline 변경자를 붙이면 컴파일러는 그 함수를 호출하는 모든 문장을 함수 본문에 해당하는 바이트코드로 바꿔줍니다.

* inline 함수에 전달된 람다의 본문도 함께 인라이닝 됩니다. 람다를 호출하는 코드 정의의 일부분으로 간주하기 때문에 코틀린 컴파일러는 그 람다를 함수 인터페이스를 구현하는 무명 클래스로 감싸지 않습니다.
* 람다를 넘기는 대신 함수 타입의 변수를 넘기는 경우, 람다 변수는 인라이닝 되지 않습니다.
* inline 함수를 두 곳에서 각각 다른 람다를 사용해 호출하면, 그 두 호출은 각각 인라이닝 됩니다.

### 8.2.2 inline 함수의 한계

인라이닝의 방식에 의해 람다로 사용하는 모든 함수를 인라이닝 할 수는 없습니다.

함수가 인라이닝될 때 그 함수에 전달된 람다 식의 본문은 결과 코드에 직접 들어갈 수 있습니다. 하지만 파라미터로 받은 람다를 다른 변수에 저장하고 나중에 그 변수를 사용한다면 람다를 표현하는 객체가 어딘가는 존재해야 하기 때문에 람다를 인라이닝 할 수 없습니다.

일반적으로 인라인 함수의 본문에서 람다 식을 바로 호출하거나 람다 식을 인자로 전달받아 바로 호출하는 경우에는 인라이닝 할 수 있습니다. 이런 경우가 아니라면 컴파일러는 "Illegal usage of inline-parameter" 라는 에러를 출력합니다.

```kotlin
fun <T, R> Sequence<T>.map(transform: (T) -> R): Sequence<R> {
    return TransformingSequence(this, transform) // 람다를 호출하지 않고 생성자의 인자로 넘김
}
```

위의 경우 전달받은 람다를 호출하지 않고 생성자에게 값을 넘깁니다. 이런 경우에는 transform 을 함수 인터페이스를 구현하는 무명 클래스 인스턴스로 만드는 수 밖에 없습니다.

둘 이상의 람다를 인자로 받는 함수에서 일부 람다만 인라이닝 하고 싶은 경우도 있습니다. 이때는 인라인 함수에서 특정 인자에 noinline 변경자를 붙이면 됩니다.

```kotlin
inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) { ... }
```

자바에서 코틀린 인라인 함수를 호출하는 경우 인라이닝 하지 않고, 일반 함수 호출로 컴파일합니다.

### 8.2.3 컬렉션 연산 인라이닝

코틀린 표준 라이브러리의 컬렉션 함수는 대부분 람다를 인자로 받고, 인라인 함수 입니다. 따라서 컬렉션 함수에 람다를 넘기는 대신 직접 구현해도 결과 코드는 비슷합니다.

처리할 원소가 많아지면 중간 리스트를 사용하는 부가 비용이 커지는데, 이때 asSequence 를 통해 리스트 대신 시퀀스를 사용할 수 있습니다. 이 경우 중간 리스트로 인한 부가 비용은 줄어들지만, 시퀀스는 람다를 인라이닝 하지 않기 때문에 람다 생성 비용이 커집니다.

시퀀스의 최종 연산은 중간 시퀀스에 있는 여러 람다(필드에 저장된 객체)를 연쇄 호출하게 됩니다. 따라서 지연 계산을 통해 성능을 향상시키려는 이유로 모든 컬렉션 연산에 asSequence를 붙여선 안됩니다. 컬렉션의 크기가 큰 경우에만 성능을 향상 시킬 수 있습니다.

### 8.2.4 함수를 인라인으로 선언해야 하는 경우

inline 키워드의 성능 향상은 람다를 인자로 받는 함수의 경우에만 발생할 가능성이 큽니다. 다른 경우에는 주의 깊게 성능을 측정해봐야 합니다.

* 일반 함수 호출의 경우 JVM 이 코드 실행을 분석하여 가장 이익이 되는 방향으로 호출을 인라이닝합니다. 이런 과정은 바이트코드를 기계어로 번역하는 과정(JIT)에서 발생하고, 바이트코드에서는 각 함수 구현이 한번만 있으면 되기에 함수 호출 부분에서 함수 코드를 중복할 필요가 없습니다.
* 코틀린 인라인 함수는 바이트코드에서 각 함수 호출 지점을 함수 본문으로 인라이닝하기 때문에 코드 중복이 생깁니다.

inline 함수가 큰 경우에는 바이트코드가 전체적으로 커질 수 있기 때문에 주의해야 하고, 람다 인자와 무관한 부분을 비인라인 함수로 빼낼 수도 있습니다. 코틀린 표준 라이브러리의 inline 함수들의 크기가 모두 매우 작은 것을 볼 수 있습니다.

### 8.2.5 자원 관리를 위해 인라인된 람다 사용

람다로 중복을 제거할 수 있는 일반적인 패턴 중 하나는 어떤 작업 전후로 자원을 획득하고, 해제하는 자원 관리입니다. 이때 자워능ㄴ 파일, 락, 데이터베이스 트랜잭션 등이 될 수 있습니다.

코틀린에는 자바의 synchronized 와 비슷한 withLock (Lock 인터페이스의 확장 함수) 함수를 제공합니다.

자바의 try-with-resource 를 언어 구성 요소로 제공하진 않지만, use (closable 인터페이스의 확장 함수, 인라인 함수) 함수를 통해 구현할 수 있습니다.

```kotlin
fun <T>.Lock.withLock(action: () -> T): T {
    lock()
    try {
        return action()
    } finally {
        unlock()
    }
}

val l: Lock = ...
l.withLock {
    ...
}

fun readFirstLineFromFile(path: String): String {
    BufferedReader(FileReader(path)).use { br -> 
        return br.readline()
    }
}
```

## 8.3 고차 함수 안에서 흐름 제어

루프와 같은 명령형 코드를 람다로 바꾸기 시작하면 곧 return 문제가 생깁니다.

### 8.3.1 람다 안의 return 문: 람다를 둘러싼 함수로부터 반환

인라인 함수의 람다 안에서 return 을 사용하면 람다 뿐만 아니라 람다를 호출하는 함수 자체를 종료하게 됩니다. 이를 논로컬 non-local return 이라고 합니다.

forEach 함수는 인라인 함수이므로 람다 본문이 인라이닝 됩니다. 따라서 return 식이 바깥쪽 함수를 반환시키게 됩니다.

인라이닝되지 않은 함수의 람다 안에서는 return 을 사용할 수 없습니다. 람다를 변수에 저장해둔 경우 바깥쪽 함수가 반환된 후에 저장해둔 람다가 호출 될 수 있는 등, 람다 안의 return 이 실행되는 시점이 바깥쪽 함수를 반환하기에는 너무 늦은 시점 일 수 있습니다.

### 8.3.2 람다로부터 반환: 레이블을 사용한 return

람다 안에서 로컬 local return 은 for 루프의 break 와 비슷합니다. 로컬 return 은 람다의 실행을 끝내고 함수를 계속 실행됩니다.

로컬 return, 논로컬 return 을 구분하기 위해 @ 문자를 이용한 레이블을 사용합니다. 레이블은 특정 이름을 지정해줄 수도 있고, 함수 이름을 사용할 수도 있습니다. 레이블은 2개 이상 붙일 수 없습니다.

```kotlin
people.forEach label@{ // 람다 레이블
    if (it.name == "Alice") return@label // reutrn 식 레이블
}

people.forEach {
    if (it.name == "Alice") return@forEach
}
```

> 레이블이 붙은 this 식
> 
> ```kotlin
> println(StringBuilder().apply sb@{   // this@sb를 통해 이 람다의 묵시적 수신 객체에 접근할 수 있다.
>   listOf(1, 2, 3).apply {            // "this" 는 이 위치를 둘러싼 가장 안쪽 영역의 묵시적 수신 객체를 가리킨다.
>     this@sb.append(this.toString())  // 모든 묵시적 수신 객체를 사용할 수 있다. 다만 바깥쪽 묵시적 수신 객체에 접근할 때는 레이블을 명시해야 한다.
>   }
> })
> [1, 2, 3]
> ```

넌로컬 return 은 장황하기 때문에, 람다 안에서 여러 위치에 return 식이 들어가야 하는 경우에는 불편합니다. 이런 경우 무명 함수를 사용할 수 있습니다.

### 8.3.3 무명 함수: 기본적으로 로컬 return

무명 함수란 코드 블록을 함수에 넘길 때 사용할 수 있는 다른 방법입니다.

```kotlin
people.forEach(fun (person) {               // 람다 식 대신 무명 함수 사용
    if (person.name == "Alice") return      // 가장 가까운 함수를 리턴. 무명 함수를 리턴
    println("${person.name} is not Alice")
})
```

무명 함수란 일반 함수와 비슷하지만, 이름이나 파라미터 타입을 생략한다는 차이점이 있습니다.

블록이 본문인 무명 함수는 반환 타입을 명시해야 하지만, 식이 본문인 무명 함수는 반환 타입을 생략할 수 있습니다.

```kotlin
// 블록이 본문
people.filter(fun (person): Boolean {
    return person.age < 30
})
// 식이 본문
people.filter(fun (person) = person.age < 30)
```

return 에 적용되는 규칙은 간단합니다. fun 키워드를 사용해 정의된 가장 안쪽 함수를 반환시킵니다.

무명 함수는 일반 함수와 비슷해 보이지만 실제로는 람다 식에 대한 문법적 편의일 뿐입니다. 람다 식의 구현 방법이나 람다 식을 인라인 함수에 넘길때 어떻게 본문이 인라이닝 되는지 등의 규칙을 무명 함수에도 적용할 수 있습니다.

[2_anonymous_function.kts](2_anonymous_function.kts)
