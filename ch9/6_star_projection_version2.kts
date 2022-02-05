import kotlin.reflect.KClass

interface FieldValidator<in T> {
    fun validate(input: T): Boolean
}

object DefaultStringValidator: FieldValidator<String> {
    override fun validate(input: String) = input.isNotEmpty()
}

object DefaultIntValidator: FieldValidator<Int> {
    override fun validate(input: Int) = input >= 0
}

val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()
validators[String::class] = DefaultStringValidator
validators[Int::class] = DefaultIntValidator

// 검증기를 가져오면서 명시적 타입 캐스팅 사용하기
val stringValidator = validators[String::class] as FieldValidator<String>   // 경고 출력
println(stringValidator.validate(""))

/*
ch9/6_star_projection_version2.kts:20:49: warning: unchecked cast: _6_star_projection_version2.FieldValidator<*>? to _6_star_projection_version2.FieldValidator<String>
val stringValidator = validators[String::class] as FieldValidator<String>
 */

// 검증기를 잘못 가져온 경우 컴파일은 되지만 런타임 에러 발생
val stringValidatorError = validators[Int::class] as FieldValidator<String>   // 잘못가져왔지만 컴파일과 타입 캐스팅 시에는 문제가 없다
stringValidatorError.validate("")                                       // 사용시에 에러 발생

/*
java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Number (java.lang.String and java.lang.Number are in module java.base of loader 'bootstrap')
        at _6_star_projection_version2$DefaultIntValidator.validate(6_star_projection_version2.kts:11)
        at _6_star_projection_version2.<init>(6_star_projection_version2.kts:30)
 */
