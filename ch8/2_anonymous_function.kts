class Person(val name: String, val age: Int)

fun lookForAlice1(people: List<Person>) {
    people.forEach(fun(person) {
        if (person.name == "Alice") return
        println("${person.name} is not Alice")
    })
}

fun lookForAlice2(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") return
        println("${it.name} is not Alice")
    }
}


val p = listOf(Person("Alice", 30), Person("Dmitry", 43))
println("lookForAlice1")
lookForAlice1(p)
println("lookForAlice2")
lookForAlice2(p)


//val a = p.filter(fun (person): Boolean {
//    return person.age < 30
//})
//
//val b = p.filter(fun (person) = person.age < 30)
//
//println(a)
//println(b)
