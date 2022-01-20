<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [4장 클래스, 객체, 인터페이스](#4%EC%9E%A5-%ED%81%B4%EB%9E%98%EC%8A%A4-%EA%B0%9D%EC%B2%B4-%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4)
  - [4.1 클래스 계층 정의](#41-%ED%81%B4%EB%9E%98%EC%8A%A4-%EA%B3%84%EC%B8%B5-%EC%A0%95%EC%9D%98)
    - [4.1.1 코틀린 인터페이스](#411-%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4)
    - [4.1.2 open, final, abstract 변경자: 기본적으로 final](#412-open-final-abstract-%EB%B3%80%EA%B2%BD%EC%9E%90-%EA%B8%B0%EB%B3%B8%EC%A0%81%EC%9C%BC%EB%A1%9C-final)
    - [4.1.3 가시성 변경자: 기본적으로 공개](#413-%EA%B0%80%EC%8B%9C%EC%84%B1-%EB%B3%80%EA%B2%BD%EC%9E%90-%EA%B8%B0%EB%B3%B8%EC%A0%81%EC%9C%BC%EB%A1%9C-%EA%B3%B5%EA%B0%9C)
    - [4.4.1 내부 클래스와 중첩된 클래스: 기본적으로 중첩 클래스](#441-%EB%82%B4%EB%B6%80-%ED%81%B4%EB%9E%98%EC%8A%A4%EC%99%80-%EC%A4%91%EC%B2%A9%EB%90%9C-%ED%81%B4%EB%9E%98%EC%8A%A4-%EA%B8%B0%EB%B3%B8%EC%A0%81%EC%9C%BC%EB%A1%9C-%EC%A4%91%EC%B2%A9-%ED%81%B4%EB%9E%98%EC%8A%A4)
    - [4.1.5 봉인된 클래스: 클래스 계층 정의 시 계층 확장 제한](#415-%EB%B4%89%EC%9D%B8%EB%90%9C-%ED%81%B4%EB%9E%98%EC%8A%A4-%ED%81%B4%EB%9E%98%EC%8A%A4-%EA%B3%84%EC%B8%B5-%EC%A0%95%EC%9D%98-%EC%8B%9C-%EA%B3%84%EC%B8%B5-%ED%99%95%EC%9E%A5-%EC%A0%9C%ED%95%9C)
  - [4.2 뻔하지 않은 생성자와 프로퍼티를 갖는 클래스 선언](#42-%EB%BB%94%ED%95%98%EC%A7%80-%EC%95%8A%EC%9D%80-%EC%83%9D%EC%84%B1%EC%9E%90%EC%99%80-%ED%94%84%EB%A1%9C%ED%8D%BC%ED%8B%B0%EB%A5%BC-%EA%B0%96%EB%8A%94-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%84%A0%EC%96%B8)
    - [4.2.1 클래스 초기화: 주 생성자와 초기화 블록](#421-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%B4%88%EA%B8%B0%ED%99%94-%EC%A3%BC-%EC%83%9D%EC%84%B1%EC%9E%90%EC%99%80-%EC%B4%88%EA%B8%B0%ED%99%94-%EB%B8%94%EB%A1%9D)
    - [4.2.2 부 생성자: 상위 클래스를 다른 방식으로 초기화](#422-%EB%B6%80-%EC%83%9D%EC%84%B1%EC%9E%90-%EC%83%81%EC%9C%84-%ED%81%B4%EB%9E%98%EC%8A%A4%EB%A5%BC-%EB%8B%A4%EB%A5%B8-%EB%B0%A9%EC%8B%9D%EC%9C%BC%EB%A1%9C-%EC%B4%88%EA%B8%B0%ED%99%94)
    - [4.2.3 인터페이스에 선언된 프로퍼티 구현](#423-%EC%9D%B8%ED%84%B0%ED%8E%98%EC%9D%B4%EC%8A%A4%EC%97%90-%EC%84%A0%EC%96%B8%EB%90%9C-%ED%94%84%EB%A1%9C%ED%8D%BC%ED%8B%B0-%EA%B5%AC%ED%98%84)
    - [4.2.4 게터와 세터에서 뒷받침하는 필드에 접근](#424-%EA%B2%8C%ED%84%B0%EC%99%80-%EC%84%B8%ED%84%B0%EC%97%90%EC%84%9C-%EB%92%B7%EB%B0%9B%EC%B9%A8%ED%95%98%EB%8A%94-%ED%95%84%EB%93%9C%EC%97%90-%EC%A0%91%EA%B7%BC)
    - [4.2.5 접근자의 가시성 변경](#425-%EC%A0%91%EA%B7%BC%EC%9E%90%EC%9D%98-%EA%B0%80%EC%8B%9C%EC%84%B1-%EB%B3%80%EA%B2%BD)
  - [4.3 컴파일러가 생성한 메소드: 데이터 클래스와 클래스 위임](#43-%EC%BB%B4%ED%8C%8C%EC%9D%BC%EB%9F%AC%EA%B0%80-%EC%83%9D%EC%84%B1%ED%95%9C-%EB%A9%94%EC%86%8C%EB%93%9C-%EB%8D%B0%EC%9D%B4%ED%84%B0-%ED%81%B4%EB%9E%98%EC%8A%A4%EC%99%80-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%9C%84%EC%9E%84)
    - [4.3.1 모든 클래스가 정의해야 하는 메소드](#431-%EB%AA%A8%EB%93%A0-%ED%81%B4%EB%9E%98%EC%8A%A4%EA%B0%80-%EC%A0%95%EC%9D%98%ED%95%B4%EC%95%BC-%ED%95%98%EB%8A%94-%EB%A9%94%EC%86%8C%EB%93%9C)
    - [4.3.2 data class: 모든 클래스가 정의해야 하는 메소드 자동 생성](#432-data-class-%EB%AA%A8%EB%93%A0-%ED%81%B4%EB%9E%98%EC%8A%A4%EA%B0%80-%EC%A0%95%EC%9D%98%ED%95%B4%EC%95%BC-%ED%95%98%EB%8A%94-%EB%A9%94%EC%86%8C%EB%93%9C-%EC%9E%90%EB%8F%99-%EC%83%9D%EC%84%B1)
    - [4.3.3 클래스 위임: by 키워드 사용](#433-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%9C%84%EC%9E%84-by-%ED%82%A4%EC%9B%8C%EB%93%9C-%EC%82%AC%EC%9A%A9)
  - [4.4 object 키워드: 클래스 선언과 인스턴스 생성](#44-object-%ED%82%A4%EC%9B%8C%EB%93%9C-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%84%A0%EC%96%B8%EA%B3%BC-%EC%9D%B8%EC%8A%A4%ED%84%B4%EC%8A%A4-%EC%83%9D%EC%84%B1)
    - [4.4.1 object class: 싱글턴을 쉽게 만들기](#441-object-class-%EC%8B%B1%EA%B8%80%ED%84%B4%EC%9D%84-%EC%89%BD%EA%B2%8C-%EB%A7%8C%EB%93%A4%EA%B8%B0)
    - [4.4.2 companion object: 팩토리 메서드와 정적 멤버가 들어갈 장소](#442-companion-object-%ED%8C%A9%ED%86%A0%EB%A6%AC-%EB%A9%94%EC%84%9C%EB%93%9C%EC%99%80-%EC%A0%95%EC%A0%81-%EB%A9%A4%EB%B2%84%EA%B0%80-%EB%93%A4%EC%96%B4%EA%B0%88-%EC%9E%A5%EC%86%8C)
    - [4.4.3 companion object 를 일반 객체처럼 사용](#443-companion-object-%EB%A5%BC-%EC%9D%BC%EB%B0%98-%EA%B0%9D%EC%B2%B4%EC%B2%98%EB%9F%BC-%EC%82%AC%EC%9A%A9)
    - [4.4.4 object expression: 무명 내부 클래스를 다른 방식으로 작성](#444-object-expression-%EB%AC%B4%EB%AA%85-%EB%82%B4%EB%B6%80-%ED%81%B4%EB%9E%98%EC%8A%A4%EB%A5%BC-%EB%8B%A4%EB%A5%B8-%EB%B0%A9%EC%8B%9D%EC%9C%BC%EB%A1%9C-%EC%9E%91%EC%84%B1)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# 4장 클래스, 객체, 인터페이스

다루는 내용
* class, interface
* open, final, abstract, override
* public, internal, protected, private
* nested class, inner class, sealed class
* 주 생성자, 부 생성자, 초기화 블록
* getter, setter
* data class, by
* object class, companion class
* object expression

## 4.1 클래스 계층 정의

### 4.1.1 코틀린 인터페이스

자바와 코틀린의 인터페이스 선언, 구현 차이점

[1_define_interface.kts](1_define_interface.kts)

인터페이스 메서드의 default method 를 제공할 수 있습니다. 자바의 경우 `default`를 붙였지만, 코틀린은 그냥 구현하면 됩니다.

두 인터페이스 모두 디폴트 구현이 들어있는 메서드의 경우 구현 클래스에서 반드시 오버라이딩 해야합니다.

[2_define_interface2.kts](2_define_interface2.kts)

> ##### 자바에서 코틀린의 메서드가 있는 인터페이스 구현하기
>
> 코틀린은 자바 6와 호환됩니다. 자바 6에는 인터페이스의 default method 를 지원하지 않습니다.
> 
> 코틀린은 default method 는 자바에서는 인터페이스 내부의 static final class 내부의 static method 로 구현됩니다.
> 
> 따라서 default method 가 포함된 코틀린 인터페이스를 자바 클래스에서 구현하고 싶다면, default method 를 포함해 모든 메서드를 구현해야 합니다.

### 4.1.2 open, final, abstract 변경자: 기본적으로 final

코틀린에서는 클래스와 메서드가 기본적으로 final 입니다. 상속과 오버라이드를 허용하려면 명시적으로 클래스, 메소드, 프로퍼티 앞에 open 변경자를 붙여야 합니다.

override 가 붙은 메소드나 프로퍼티는 기본적으로 open 이라서 하위 클래스에서 오버라이드하지 못하게 하려면 final 을 붙여야 한다.

> ##### 열린 클래스와 스마트 캐스트
>
> 스마트 캐스트란 타입 검사 뒤에 변경될 수 없는 변수에만 적용 가능합니다.
> 
> 이는 프로퍼티가 val 이면서, 커스텀 접근자가 없는 경우, final 인 경우에만 가능하다는 의미입니다.
> 
> 프로퍼티가 기본적으로 final 이기 때문에 대부분의 프로퍼티를 스마트 캐스트에 활용할 수 있습니다.

|변경자|이 변경자가 붙은 멤버는...|설명|
|:----|:--------------------|:---|
|final|오버라이드할 수 없음|클래스 멤버의 기본 변경자|
|open|오버라이드할 수 있음|반드시 open을 명시해야 오버라이드할 수 있다|
|abstract|반드시 오버라이드해야 함|추상 클래스의 멤버에만 이 변경자를 붙일 수 있다. 추상 멤버에는 구현이 있으면 안된다|
|override|상위 클래스나 상위 인스턴스의 멤버를 오버라이드 하는 중|오버라이드하는 멤버는 기본적으로 open이다. 오버라이드를 금지하려면 final을 붙여야 한다|

### 4.1.3 가시성 변경자: 기본적으로 공개

자바와 같은 public, protected, private 변경자가 있지만, 코틀린의 기본 가시성은 자바와 다르게 public 입니다.

자바의 기본 가시성인 패키지 전용(package-private) 대신 코틀린에서는 internal 가시성 변경자를 도입했는데, 자바와는 다르게 패키지가 아닌 '모듈' 내부에서만 볼 수 있습니다.

최상위 선언에 대해서도 private 선언이 가능한데, 이때는 취상위 선언이 들어있는 파일 내부에서만 사용할 수 있습니다. 이는 하위 시스템의 자세한 구현 사항을 외부에 감추고 싶을 때 유용합니다.

|변경자|클래스 멤버|최상위 선언|
|:----|:--------------------|:---|
|public|모든 곳에서|모든 곳에서|
|internal|같은 모듈 안에서만|같은 모듈 안에서만|
|protected|하위 클래스 안에서만|(최상위 선언에 적용할 수 없다)|
|private|같은 클래스 안에서만|같은 파일 안에서만|

[3_visibility_modifier.kts](3_visibility_modifier.kts)

> ##### 코틀린의 가시성 변경자와 자바
> 
> 코틀린의 public, protected, private 변경자는 자바에서도 동일하게 유지되지만, 언어 특성상 다른 점들을 기억해야 합니다.
> 
> 코틀린에서는 접근할 수 없는 대상을 자바에서는 접근 할 수 있는 경우도 생깁니다.
> 
> 1. 자바에서는 클래스를 private 으로 만들 수 없으므로, 코틀린은 private 클래스를 패키지-전용 클래스로 컴파일합니다.
> 2. internal 변경자는 자바에서 public 으로 변경됩니다. 다른 모듈에 정의된 internal 클래스, internal 최상위 선언을 모듈 외부의 자바 코드에서는 접근 할 수 있습니다.
> 3. protected 멤버를 코틀린 클래스와 같은 패키지에 속한 자바 코드에서는 접근할 수 있습니다.
> 
> 접근 할 수는 있지만, 코틀린 컴파일러가 internal 멤버의 이름을 보기 나쁘게 변경합니다.
> 1. 한 모듈에 속한 어떤 클래스를 모듈 밖에서 상속한 경우 그 하위 클래스 내부의 메서드 이름이 우연히 상위 클래스의 internal 메서드와 같아져서 내부 메서드를 오버라이드 하는 경우를 방지
> 2. 실수로 internal 클래스를 모듈 외부에서 사용하는 일을 막기 위함

### 4.4.1 내부 클래스와 중첩된 클래스: 기본적으로 중첩 클래스

자바에서는 다른 클래스 안에 정의한 클래스는 자동으로 inner class 가 되고, 바깥쪽 클래스에 대한 참조를 묵시적으로 포함합니다.

자바에서는 중첩 클래스를 static 으로 선언하면 그 클래스를 둘러싼 바깥쪽 클래스에 대한 묵시적인 참조가 사라집니다.



|클래스 B 안에 정의된 클래스 A|자바에서|코틀린에서|
|:----|:--------------------|:---|
|nested class(바깥쪽 클래스의 참조를 저장하지 않음)|static class A|class A|
|inner class(바깥쪽 클래스의 참조를 저장함)|class A|inner class A|

[4_inner_class.kts](4_inner_class.kts)

### 4.1.5 봉인된 클래스: 클래스 계층 정의 시 계층 확장 제한

코틀린 컴파일러는 when 을 사용해 Expr 타입 값을 검사할때 디폴트 분기인 else 분기를 붙이지 않으면 컴파일에러를 발생시킵니다.

[5_non_sealed_class.kts](5_non_sealed_class.kts)

항상 디폴트 분기를 추가하는게 편하지는 않기 때문에 sealed class 를 제공합니다. sealed 변경자를 붙이면 상위 클래스를 상속한 하위 클래스 정의를 제한할 수 있습니다. sealed 클래스의 하위 클래스를 정의할때는 반드시 상위 클래스 안에 중첩시키거나 동일한 파일 내에 있어야 합니다.

[6_sealed_class.kts](6_sealed_class.kts)

## 4.2 뻔하지 않은 생성자와 프로퍼티를 갖는 클래스 선언

코틀린은 주 생성자, 부 생성자, 초기화 블록을 제공합니다.

### 4.2.1 클래스 초기화: 주 생성자와 초기화 블록

클래스의 모든 선언은 중괄호({}) 사이에 들어갑니다. 내용이 없을때는 생략할 수 있습니다.

중괄호 전에 괄호를 둘 수 있습니다. 이는 주 생성자를 의미합니다.

주 생성자를 쓰는 다양한 방법 참고

[7_constructor.kts](7_constructor.kts)

### 4.2.2 부 생성자: 상위 클래스를 다른 방식으로 초기화

자바와 다르게 코틀린 생성자에서는 디폴트 파라미터 값과 이름 붙은 인자 문법을 사용할 수 있습니다.

디폴트 값 제공을 위해 부 생성자를 여럿 만들기 보다는, 파라미터의 디폴트 값을 생성자 시그니처에 직접 명시합니다.

[8_constructor2.kts](8_constructor2.kts)

클래스에 주 생성자가 없다면 모든 부 생성자는 반드시 상위 클래스를 초기화(super)하거나 다른 생성자에게 생성을 위힘(this)해야 합니다.

### 4.2.3 인터페이스에 선언된 프로퍼티 구현

코틀린에서는 인터페이스에 추상 프로퍼티를 선언할 수 있고, 구현 클래스에서 추상 프로퍼티를 얻어올 수 있는 방법을 구현해야 합니다.

[9_interface_property.kts](9_interface_property.kts)

### 4.2.4 게터와 세터에서 뒷받침하는 필드에 접근

프로퍼티의 유형
* 값을 저장하는 프로퍼티
* 커스텀 접근자에서 매번 값을 계산하는 프로퍼티

코틀린에서는 set, get 키워드를 사용하여 setter, getter 의 동작 방식을 정할 수 있습니다.

프로퍼티의 값을 바꿀 때 `user.address = "new value"` 처럼 필드 설정을 하면, 내부적으로 address 의 setter 를 호출합니다.

setter, getter 둘 중 하나만 직접 정의해줘도 되고, 생략해도 됩니다.

[10_setter.kts](10_setter.kts)

### 4.2.5 접근자의 가시성 변경

setter, getter 의 가시성을 변경할 수 있습니다.

[11_private_setter.kts](11_private_setter.kts)

## 4.3 컴파일러가 생성한 메소드: 데이터 클래스와 클래스 위임

### 4.3.1 모든 클래스가 정의해야 하는 메소드

* toString()
* equals()
  * 동등성 equality 와 참조 비교 reference comparision 개념이 있습니다. 자바에서는 두 객체의 동등성을 비교하기 위해서는 equals() 를 호출해야 합니다.
  * 코틀린에서는 "=="를 써도 내부적으로 equals() 를 호출해서 객체를 비교합니다. 참조 비교를 위해서 "==="를 사용합니다.
* hashCode()
  * 자바에서는 equals 를 오버라이드할 때 반드시 hashCode도 함께 오버라이드 해야합니다.
  * JVM 에서는 "equals()가 true를 반환하는 두 객체는 반드시 같은 hashCode()를 반환해야 한다."라는 제약이 있습니다.
    
### 4.3.2 data class: 모든 클래스가 정의해야 하는 메소드 자동 생성

data 라는 변경자를 클래스 앞에 붙이면 toString, equals, hashCode 메서드를 자동으로 생성해줍니다.

equals, hashCode 는 모든 프로퍼티를 고려하여 만들어집니다.

data class 의 모든 프로퍼티가 val 일 필요는 없지만, 모든 프로퍼티를 읽기 전용으로 만들어서 데이터 클래스를 불변 클래스로 만들라고 권장합니다.

불변 객체를 사용하면 프로그램에 대해 쉽게 추론이 가능하고, 다중스레드 환경에서 스레드를 동기화 할 필요가 줄어듭니다.

이때 data class 에서는 객체 복사를 위해 copy() 메서드를 제공합니다.

[12_data_class.kts](12_data_class.kts)

### 4.3.3 클래스 위임: by 키워드 사용

코틀린 클래스는 기본적으로 final 취급이라서 상속할 수 없습니다. 하지만 종종 상속을 허용하지 않는 클래스에 새로운 동작을 추가해야 할 때가 있습니다. 일반적으로 데코레이터 패턴을 사용합니다.

상속을 허용하지 않는 클래스 대신 사용할 수 있는 새로운 클래스(데코레이터)를 만들되 기존 클래스와 같은 인터페이스를 데코레이터가 제공하게 만들고, 기존 클래스를 데코레이터 내부에 필드로 유지하는 것입니다. 새로 제공하는 기능은 데코레이터의 메소드를 새로 정의하고, 기존 기능을 사용하는 것은 기존 클래스의 메소드에게 요청을 전달(forwarding)합니다.

이런 방식을 코틀린에서는 by 키워드를 사용하여 간결하게 코드 작성을 할 수 있습니다.

[13_delegate_class.kts](13_delegate_class.kts)

## 4.4 object 키워드: 클래스 선언과 인스턴스 생성

* object class : 싱글턴을 정의하는 방법
* companion object : 인스턴스 메서드는 아니지만, 어떤 클래스와 관련있는 메서드와 팩토리 메서드를 담을때 쓰인다.
* object expression : anonymous inner class

### 4.4.1 object class: 싱글턴을 쉽게 만들기

클래스를 object 로 생성하면 싱글턴 객체가 생성된다. 이를 객체 선언이라 한다.

객체 선언에는 생성자를 쓸 수 없고, 객체 선언문이 있는 위치에서 생성자 호출 없이 즉시 만들어진다.

클래스 내부에 객체를 선언해도, 인스턴스는 단 하나만 생깁니다.

[14_object_class.kts](14_object_class.kts)

> ##### 코틀린 객체를 자바에서 사용하기
> 
> 코틀린 object class 객체는 자바 클래스의 static 필드로 컴파일되고, 인스턴스 필드 이름은 항상 INSTANCE 입니다.

### 4.4.2 companion object: 팩토리 메서드와 정적 멤버가 들어갈 장소

코틀린 클래스에는 static 키워드를 지원하지 않습니다. 대신 최상위 함수와 객체 선언을 활용할 수 있습니다. 하지만 최상위 함수는 private 클래스의 비공개 멤버에 접근할 수 없습니다.

이때 클래스에 companion class, 동반 객체를 두면 자바의 정적 메서드 호출이나 정적 필드와 같이 사용할 수 있습니다. 이는 private 생성자를 호출하기 좋은 위치입니다.

[15_companion_object.kts](15_companion_object.kts)

### 4.4.3 companion object 를 일반 객체처럼 사용

companion object 는 클래스 안에 정의된 일반 객체이고 이름 붙이거나 인터페이스를 상속하거나 companion object 안에 확장 함수와 프로퍼티를 정의할 수 있습니다.

[16_companion_object_advance.kts](16_companion_object_advance.kts)

### 4.4.4 object expression: 무명 내부 클래스를 다른 방식으로 작성

object 키워드는 싱글턴 객체를 정의할때도 쓰지만, annonymous object 를 정의할때도 object 키워드를 사용합니다.

무명 객체에는 이름을 붙이지 않지만, 이름이 필요하다면 변수에 할당하여 사용하면 됩니다.

한 인터페이스, 한 클래스만 확장할 수 있는 자바의 무명 내부 클래스와 다르게 코틀린에서는 여러 인터페이스를 구현하거나 클래스를 확장할 수 있습니다.

object class 와 다르게 object expression 은 싱글턴이 아닙니다. 식이 쓰일때마다 새로운 인스턴스가 생성됩니다. 또한 자바의 무명 클래스는 final 인 변수에만 접근할 수 있었지만 코틀린에서는 같은 함수 내의 로컬 변수에 접근하여 값을 변경 할 수 있습니다.

[17_object_expression.kts](17_object_expression.kts)

object expression 은 여러 메서드를 오버라이드해야 하는 경우에 유용합니다. 구현해야할 메서드가 1개인 함수형 인터페이스들은 5장에서 다루는 람다를 사용하는게 더 유용합니다.
