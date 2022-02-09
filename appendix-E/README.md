<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [부록E 코루틴과 Async/Await](#%EB%B6%80%EB%A1%9De-%EC%BD%94%EB%A3%A8%ED%8B%B4%EA%B3%BC-asyncawait)
  - [E.2 코틀린의 코루틴 지원: 일반적인 코루틴](#e2-%EC%BD%94%ED%8B%80%EB%A6%B0%EC%9D%98-%EC%BD%94%EB%A3%A8%ED%8B%B4-%EC%A7%80%EC%9B%90-%EC%9D%BC%EB%B0%98%EC%A0%81%EC%9D%B8-%EC%BD%94%EB%A3%A8%ED%8B%B4)
    - [E.2.1 여러가지 코루틴](#e21-%EC%97%AC%EB%9F%AC%EA%B0%80%EC%A7%80-%EC%BD%94%EB%A3%A8%ED%8B%B4)
      - [kotlinx.coroutines.CoroutineScope.launch](#kotlinxcoroutinescoroutinescopelaunch)
      - [kotlinx.coroutines.CoroutineScope.async](#kotlinxcoroutinescoroutinescopeasync)
    - [E.2.2 코루틴 컨텍스트와 디스패처](#e22-%EC%BD%94%EB%A3%A8%ED%8B%B4-%EC%BB%A8%ED%85%8D%EC%8A%A4%ED%8A%B8%EC%99%80-%EB%94%94%EC%8A%A4%ED%8C%A8%EC%B2%98)
    - [E.2.3 코루틴 빌더와 일시 중단 함수](#e23-%EC%BD%94%EB%A3%A8%ED%8B%B4-%EB%B9%8C%EB%8D%94%EC%99%80-%EC%9D%BC%EC%8B%9C-%EC%A4%91%EB%8B%A8-%ED%95%A8%EC%88%98)
  - [E.3 suspend 키워드와 코틀린의 일시 중단 함수 컴파일 방법](#e3-suspend-%ED%82%A4%EC%9B%8C%EB%93%9C%EC%99%80-%EC%BD%94%ED%8B%80%EB%A6%B0%EC%9D%98-%EC%9D%BC%EC%8B%9C-%EC%A4%91%EB%8B%A8-%ED%95%A8%EC%88%98-%EC%BB%B4%ED%8C%8C%EC%9D%BC-%EB%B0%A9%EB%B2%95)
  - [E.4 코루틴 빌더 만들기](#e4-%EC%BD%94%EB%A3%A8%ED%8B%B4-%EB%B9%8C%EB%8D%94-%EB%A7%8C%EB%93%A4%EA%B8%B0)
    - [E.4.1 제네레이터 빌더 사용법](#e41-%EC%A0%9C%EB%84%A4%EB%A0%88%EC%9D%B4%ED%84%B0-%EB%B9%8C%EB%8D%94-%EC%82%AC%EC%9A%A9%EB%B2%95)
    - [E.4.2 제네레이터 빌더 구현](#e42-%EC%A0%9C%EB%84%A4%EB%A0%88%EC%9D%B4%ED%84%B0-%EB%B9%8C%EB%8D%94-%EA%B5%AC%ED%98%84)
  - [E.5 결론](#e5-%EA%B2%B0%EB%A1%A0)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# 부록E 코루틴과 Async/Await

우선 서브루틴이란 여러 명령어를 모아 이름을 부여해서 반복 호출할 수 있게 정의한 프로그램 혹은 함수입니다. 어떤 동작을 수행하기 위해서는 함수가 호출되고, 그 함수의 동작이 끝나면 자신을 호출하였던 메인루틴으로 돌아오게 됩니다.

서브루틴에 진입하는 방법은 오직 함수를 호출하는 것뿐이고, 항상 서브루틴의 맨 처음부터 실행됩니다. 이때마다 활성 레코드 activation record 라는 것이 스택에 할당되면서 서브루틴 내부의 로컬 변수 등이 초기화됩니다. 반면 return 은 여러 곳에서 사용할 수 있기에 서브루틴이 실행을 중단하고 제어를 caller 쪽으로 돌려주는 지점은 여럿 있을 수 있습니다. 다만 일단 반환되고 나면 활성 레코드가 스택에서 사라지기 때문에 실행 중이던 모든 상태를 읽어버립니다. 그래서 서브루틴을 여러번 호출해도 (전역변수나 다른 부수효과가 없는한) 항상 같은 결과를 받습니다.

코루틴이란 하나의 진입점과 하나의 탈출점이 있는 서브루틴과 다르게 다양한 진입점과 다양한 탈출점이 있는 루틴입니다. 함수 A 가 실행되는중에 코루틴 B 를 호출하면 함수 A 가 실행되던 스레드 안에서 코루틴 B 가 실행됩니다. 코루틴 B 에서 yield 가 호출되면 다시 함수 A 가 실행되다가 코루틴 B 를 다시 호출하면, B 는 처음부터 실행되는게 아니라 yield 했던 지점부터 실행됩니다.

* 비선점형 멀티태스킹
* 매우 경량

## E.2 코틀린의 코루틴 지원: 일반적인 코루틴

코루틴의 지원 기본 기능들 kotlin.coroutine, 기본 기능을 활용한 다양한 형태의 코루틴 kotlinx.coroutines

### E.2.1 여러가지 코루틴

코틀린은 코루틴 빌더에 원하는 동작을 람다로 넘겨서 코루틴을 만들어 실행하는 방식으로 코루틴을 활용합니다.

#### kotlinx.coroutines.CoroutineScope.launch

launch 는 코루틴을 Job 으로 반환하고, 만들어진 코루틴은 즉시 실행됩니다. 원한다면 Job의 cancel() 메서드로 코루틴을 중단할 수 있습니다.

[1_launch.main.kts](1_launch.main.kts)

[2_yield_example.main.kts](2_yield_example.main.kts)

`GlobalScope.launch { }` 가 만들어낸 코루틴은 메인 함수와 다른 스레드에서 실행됩니다. 따라서 메인 스레드가 실행 중인 동안만 코루틴의 동작을 보장합니다.

이를 방지하기 위해 비동기적으로 launch 를 실행하거나, launch 가 모두 다 실행될때까지 기다려야 합니다. 코루틴의 실행이 끝날때까지 현재 스레드를 블록시키는 함수로 `runBlocking { }` 이 있습니다. (runBlocking 은 일반 함수)

* launch 는 즉시 반환된다
* runBlocking 은 내부 코루틴이 모두 끝난 다음에 반환된다
* delay()를 사용한 코루틴은 그 시간이 지날 때까지 다른 코루틴에게 실행을 양보하고, 자신에게 차례가 돌아와도 delay 가 끝나지 않았다면 다시 실행을 양보합니다.

#### kotlinx.coroutines.CoroutineScope.async

async 는 launch 와 같은 일을 하지만 Job 대신 Deferred 를 반환한다는 차이점이 있습니다. Deferred 는 코루틴이 계산을 하고 돌려주는 값이 포함되어 있고, Job 타입은 Deferred<Unit> 타입이라고 생각할 수도 있습니다.

[3_async.main.kts](3_async.main.kts)

스레드를 여럿 사용하는 병렬 처리와 달리 모든 async 함수들이 메인 스레드 안에서 실행됨을 볼 수 있습니다. 이 부분이 async/await과 스레드를 사용한 병렬 처리의 큰 차이점 입니다.

실행하려는 작업이 시간이 얼마 걸리지 않거나, I/O에 의한 대기 시간이 크고, CPU 코어 수가 작아 동시에 실행할 수 있는 스레드 개수가 한정된 경우에는 코루틴과 일반 스레드를 사용한 비동기 처리 사이에 차이는 커집니다.

### E.2.2 코루틴 컨텍스트와 디스패처

```kotlin
public fun CoroutineScope.launch(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job {
    ...
}

public fun <T> CoroutineScope.async(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> T
): Deferrd<T> {
    ...
}
```

launch, async 함수에는 CoroutineContext 객체도 넘길 수 있습니다. CoroutineContext 는 코루틴이 실행 중인 여러 Job 과 디스패처를 저장하는 일종의 맵입니다.

코틀린 런타임은 이 CoroutineContext 를 사용해서 다음에 실행할 작업을 선정하고, 어떻게 스레드에 배정할지 방법을 결정합니다.

```kotlin
launch {    // 부모 컨텍스트를 사용 (이 경우 main)
    println("hello")
}
launch(Dispatchers.Unconfined) {    // 특정 스레드에 종속되지 않았으면 main
    println("hello")
}
launch(Dispatchers.Default) {    // 기본 디스패처를 사용
    println("hello")
}
launch(newSingleThreadContext("MyOwnThread")) {    // 새 스레드를 사용
    println("hello")
}
```

### E.2.3 코루틴 빌더와 일시 중단 함수

launch, async, runBlocking 모두 코루틴 빌더라고 합니다. 이들은 코루틴을 생성해주며, `kotlinx-coroutines-core` 모듈에는 다음 2가지 빌더가 더 있습니다.

* produce: 정해진 채널로 데이터를 스트림으로 보내는 코루틴을 생성. ReceiveChannel<> 을 반환
* actor: 정채진 채널로 메시지를 받아 처리하는 코루틴을 생성. SendChannel<> 를 반환

delay, yield 는 일시 중단 함수입니다. `kotlinx-coroutines-core` 모듈에는 일시 중단 함수가 더 있습니다.

* withContext: 다른 컨텍스트로 코루틴을 전환
* withTimeout: 코루틴이 정해진 시간 안에 실행되지 않으면 예외
* withTimeoutOrNull: 코루틴이 정해진 시간안에 실행되지 않으면 null 반환
* awaitAll: 모든 작업의 성공을 대기. 하나라도 예외로 실패하면 예외
* joinAll: 모든 작업이 끝날때까지 현재 작업을 일시 중단

## E.3 suspend 키워드와 코틀린의 일시 중단 함수 컴파일 방법

일시 중단 함수를 코루틴이나 suspend 함수가 아닌 함수에서 호출하는 것은 컴파일러 수준에서 금지됩니다.

suspend 함수의 동작 방식을 알기 위해서 yield 가 발생하면 추가적인 로직이 필요할지 생각해봅니다.

* 코루틴에 진입할 때와 코루틴에서 나갈 때 코루틴이 실행 중이던 상태를 저장하고 복구하는 등의 작업을 할 수 있어야 한다.
* 현재 실행 중이던 위치를 저장하고 다시 코루틴이 재개될 때 해당 위치부터 실행을 재개할 수 있어야 한다.
* 다음에 어떤 코루틴을 실행할지 결정한다.

이 중 마지막은 코루틴 컨텍스트의 디스패처에 의해 수행됩니다. suspend 함수는 컴파일러가 1,2번 작업을 할 수 있는 코드를 생성해줍니다. 이때 코틀린 컴파일러는 CPS continuation passing style 변환과 상태 기계 state machine 을 활용해 코드를 생산합니다.

CPS 변환이란 프로그램의 실행 중 특정 시점 이후에 진행해야 하는 내용을 별도의 함수로 뽑고 (이런 함수를 Continuation 이라고 함), 그 함수에게 현재 시점까지 실행한 결과를 넘겨서 처리하게 만드는 소스코드 변환 기술입니다. (자세한 변환 과정은 생략합니다)

```kotlin
suspend fun example(v: Int): Int {
    return v*2
}
```
코틀린 컴파일러는 이 함수를 컴파일하면서 뒤에 Continuation 을 인자로 붙입니다.
```java
public static final Object example(int v, @NotNull Continuation var1)
```
그리고 이 함수를 호출할 때는 함수 호출이 끝난 후 수행해야 할 작업을 var1 에 Continuation 으로 전달하고, 함수 내부에서는 모든 일을 수행한 다음에 결과를 var1에 넘기는 코드를 추가합니다. 여기선 v*2 를 인자로 Continuation을 호출하는 코드가 들어갑니다.

CPS를 사용하면 코루틴을 만들기 위해 필수적인 일시 중단 함수를 만드는 문제가 해결되지만, 모든 코드를 전부 CPS로 변환하면 지나치게 많은 함수가 생기게 되므로, 상태 기계를 사용해서 코루틴이 제어를 다른 시점으로 넘겨야 하는 시점에만 컨티뉴에이션이 생기도록 만들 수 있습니다.

## E.4 코루틴 빌더 만들기

일반적으로 코루틴 빌더를 직접 만들 필요는 없지만, 한번 살펴보겠습니다.

> 다양한 코루틴 빌더와 빌더 사용법은 https://github.com/Kotlin/kotlin-coroutines-examples

### E.4.1 제네레이터 빌더 사용법

### E.4.2 제네레이터 빌더 구현

## E.5 결론
