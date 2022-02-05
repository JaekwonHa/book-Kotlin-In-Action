fun addAnswer(list: MutableList<Any>) {
    list.add(42)
}

val strings = mutableListOf("abc", "bac")
addAnswer(strings)
println(strings.maxByOrNull { it.length })

/**
error: type mismatch: inferred type is MutableList<String> but MutableList<Any> was expected (3_variance.kts:6:11)
ch9/3_variance.kts:6:11: error: type mismatch: inferred type is MutableList<String> but MutableList<Any> was expected
addAnswer(strings)

addAnswer(strings) 만약 이 코드가 컴파일 된다면, 정수를 문자열 리스트 뒤에 추가할 수 있게 됩니다. 코틀린 컴파일러는 이런 함수 호출을 금지합니다.
 */
