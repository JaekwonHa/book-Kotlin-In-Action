sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

fun eval(e: Expr): Int =
    when(e) {
        is Expr.Num -> e.value
        is Expr.Sum -> eval(e.right) + eval(e.left)
//        is Multi -> eval(e.right) * eval(e.left)
    }

class Multi(val left: Expr, val right: Expr) : Expr()

val num = Expr.Num(2)
val sum = Expr.Sum(Expr.Num(2), Expr.Num(3))
val multi = Multi(Expr.Num(2), Expr.Num(3))

println(eval(num))
println(eval(sum))
println(eval(multi))
