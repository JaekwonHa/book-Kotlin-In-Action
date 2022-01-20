class User private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) =
            User(email.substringBefore('@'))

        fun newFacebookUser(accountId: Int) =
            User(accountId.toString())
    }
}

val subscribinUser = User.newSubscribingUser("bob@gmail.com")
val facebookUser = User.newFacebookUser(4)

println(subscribinUser.nickname)
