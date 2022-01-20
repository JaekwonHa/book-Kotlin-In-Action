interface User {
    val nickname: String
}

class PrivateUser(override val nickname: String) : User

class SubscribingUser(val email: String): User {
    override val nickname: String
        get() = email.substringBefore('@')
}

class FacebookUser(val accountId: Int): User {
    override val nickname = "Not yet implemented"
}

println(PrivateUser("test@kotlinlang.org").nickname)
println(SubscribingUser("test@kotlinlang.org").nickname)
println(FacebookUser(1234).nickname)
