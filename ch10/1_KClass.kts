import kotlin.reflect.full.*

class Person(val name: String, val age: Int)

val person = Person("Alice", 29)
val kClass = person.javaClass.kotlin            // KClass<Person> 인스턴스를 반환

println(kClass.simpleName)

kClass.memberProperties.forEach { println(it.name) }
