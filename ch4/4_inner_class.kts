class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}

val outer = Outer()
val inner = outer.Inner()
val outer2 = inner.getOuterReference()

println(outer == outer2)
