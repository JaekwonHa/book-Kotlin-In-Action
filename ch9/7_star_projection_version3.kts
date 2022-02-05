import kotlin.reflect.KClass

interface FieldValidator<in T> {
    fun validate(input: T): Boolean
}

object DefaultStringValidator : FieldValidator<String> {
    override fun validate(input: String) = input.isNotEmpty()
}

object DefaultIntValidator : FieldValidator<Int> {
    override fun validate(input: Int) = input >= 0
}

// 검증기 컬렉션에 대한 접근 캡슐화하기
object Validators {
    private val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()

    fun <T : Any> registerValidator(kClass: KClass<T>, fieldValidator: FieldValidator<T>) {
        validators[kClass] = fieldValidator         // 어떤 클래스와 검증기가 타입이 맞아 떨어지는 경우에만 정보를 입력 가능
    }

    @Suppress("UNCHECKED_CAST")             // 안전하지 않은 캐스팅에 대한 경고 무시
    operator fun <T : Any> get(kClass: KClass<T>): FieldValidator<T> =
        validators[kClass] as? FieldValidator<T>
            ?: throw IllegalArgumentException("No validator for ${kClass.simpleName}")
}

Validators.registerValidator(String::class, DefaultStringValidator)
Validators.registerValidator(Int::class, DefaultIntValidator)

println(Validators[String::class].validate("Kotlin"))
println(Validators[Int::class].validate(42))
