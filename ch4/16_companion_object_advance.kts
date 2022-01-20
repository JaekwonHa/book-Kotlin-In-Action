// name
class Person(val name: String) {
    companion object Loader {
         fun fromJSON(jsonText: String): Person = Person(jsonText)
    }
}

val person1 = Person.Loader.fromJSON("{name: 'Dmitry'}")
println(person1.name)

val person2 = Person.fromJSON("{name: 'Brent'}")
println(person2.name)

// interface
interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}

class Person2(val name: String) {
    companion object : JSONFactory<Person2> {
        override fun fromJSON(jsonText: String): Person2 = Person2(jsonText)
    }
}

fun <T> loadFromJSON(factory: JSONFactory<T>): T {
    return factory.fromJSON("{name: 'Brent'}")
}

val person3 = loadFromJSON(Person2)
println(person3.name)

// 확장함수
class Person3(val firstName: String) {
    companion object
}

fun Person3.Companion.fromJson(jsonText: String): Person3 {
    return Person3(jsonText)
}

val person4 = Person3.fromJson("{name: 'Brent'}")
println(person4.firstName)
