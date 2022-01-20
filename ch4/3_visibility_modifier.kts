internal open class TalkativeButton {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

fun TalkativeButton.giveSpeech() {
    yell()
    whisper()
}

//open class TalkativeButton {
//    private fun yell() = println("Hey!")
//    protected fun whisper() = println("Let's talk!")
//}
//
//fun TalkativeButton.giveSpeech() {
//    yell()
//    whisper()
//}
