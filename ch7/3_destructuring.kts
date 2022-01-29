data class NameComponents(val name: String, val extension: String)

fun splitFilename(fullName: String): NameComponents {
    val result = fullName.split('.', limit = 2)
    return NameComponents(result[0], result[1])
}

val (name, ext) = splitFilename("example.kt")
println(name)
println(ext)

// 컬렉션에 구조 분해 사용
fun splitFilename2(fullName: String): NameComponents {
    val (name, ext) = fullName.split('.', limit = 2)
    return NameComponents(name, ext)
}

val (name2, ext2) = splitFilename2("example.kt")
println(name2)
println(ext2)
