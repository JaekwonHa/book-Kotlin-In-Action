class Person1 {
    private val _attributes = hashMapOf<String, String>()
    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    val name: String
        get() = _attributes["name"]!!
}

val p1 = Person1()
val data = mapOf("name" to "Dmitry", "company" to "JetBrains")
for ((attrName, value) in data) {
    p1.setAttribute(attrName, value)
}
println(p1.name)


class Person2 {
    private val _attributes = hashMapOf<String, String>()
    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }
    val name: String by _attributes // Map, MutableMap 인터페이스에서 getValue, setValue 확장 함수를 제공함
}

val p2 = Person2()
for ((attrName, value) in data) {
    p2.setAttribute(attrName, value)
}
println(p2.name)
