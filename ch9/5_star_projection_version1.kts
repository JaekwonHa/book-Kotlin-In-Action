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

val r = validators[String::class]!!.validate("")    // 컴파일러는 FieldValidator<*> 가 어떤 타입을 검증하는 검증기인지 모르기에 String 을 검증하려고 하면 안전하지 않다고 판단합니다.

/*
error: type mismatch: inferred type is String but Nothing was expected (5_star_projection.kts:19:46)
ch9/5_star_projection.kts:19:46: error: type mismatch: inferred type is String but Nothing was expected
val r = validators[String::class]!!.validate("")
 */
