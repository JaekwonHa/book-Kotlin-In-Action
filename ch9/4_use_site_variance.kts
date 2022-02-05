fun <T> copyData(source: MutableList<out T>, destination: MutableList<in T>) {
    for (item in source) {
        destination.add(item)
    }
}

val s = mutableListOf(1, 2, 3)
val d = mutableListOf<Int>()

copyData(s, d)
println(d)
