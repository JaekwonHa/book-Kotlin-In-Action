class NullableProcessor<T> {
    fun process(value: T) {
        println(value.hashCode())       // ? 를 안붙여도 컴파일, 실행은 되지만 값이 다르게 출력됨
        println(value?.hashCode())
    }
}

class Processor<T: Any> {
    fun process(value: T) {
        println(value.hashCode())
    }
}

val nullableStringProcessor = NullableProcessor<String?>()
nullableStringProcessor.process(null)

val stringProcessor = Processor<String>()
stringProcessor.process("null")
