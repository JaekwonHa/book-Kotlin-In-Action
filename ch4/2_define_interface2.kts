interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) =
        println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable!")
}

class Button : Clickable, Focusable {
    override fun click() = println("I'm clicked!")

//    override fun showOff() {
//        super<Clickable>.showOff()
//        super<Focusable>.showOff()
//    }
}

Button().click()
Button().setFocus(true)
Button().showOff()
