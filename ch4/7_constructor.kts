class User1(val nickname: String)

class User2 constructor(_nickname: String) {
    val nickname: String

    init {
        nickname = _nickname
    }
}

class User3(_nickname: String) {
    val nickname = _nickname
}

class User4(val nickname: String, val isSubscribed: Boolean = true)

open class User5(val nickname: String)

class TwitterUser(nickname: String) : User5(nickname)

open class Button

class RadioButton : Button()

class Secretive private constructor() {}
