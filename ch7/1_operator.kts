// 연산자를 멤버 함수로 정의
data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

// 연산자를 확장 함수로 정의
operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}

val p1 = Point(10, 20)
val p2 = Point(30, 40)

println(p1 + p2)

// 두 피연산자의 타입이 다른 연산자 정의
operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

val p3 = Point(10, 20)
println(p3 * 1.5)


// 결과 타입이 피연산자 타입과 다른 연산자 정의
operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

println('a' * 3)

// 비트 연산자
println(0x0F and 0xF0)
println(0x0F or 0xF0)
println(0x1 shl 4) // <<

// +=
operator fun <T> MutableCollection<T>.plusAssign(element: T) {
    this.add(element)
}

// +a
operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

val p4 = Point(10, 20)
println(-p4)

// ++a
// inc() 확장 함수로 만들면 에러 발생
//operator fun Point.inc(): Point {
//    return Point(x+1, y+1)
//}
//operator fun Point.inc() = Point(x + 1, y + 1)
//
//var p5 = Point(30, 40)
//println(p5++)
//println(++p5)
