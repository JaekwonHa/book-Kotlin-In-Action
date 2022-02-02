data class Email(val email: String)

fun loadEmails(person: Person): List<Email> {
    println("${person.name}의 이메일을 가져옴")
    return listOf(Email("${person.name}@gmail.com"))
}

class Person(val name: String) {
    private var _emails: List<Email>? = null
    val emails: List<Email>
    get() {
        if (_emails == null) {
            _emails = loadEmails(this)
        }
        return _emails!!
    }
}

val p = Person("Alice")
println(p.emails)
println(p.emails)

fun loadEmails(person: Person2): List<Email> {
    println("${person.name}의 이메일을 가져옴")
    return listOf(Email("${person.name}@gmail.com"))
}

class Person2(val name: String) {
    val emails by lazy { loadEmails(this) }
}

val p2 = Person2("Alice")
println(p2.emails)
println(p2.emails)
