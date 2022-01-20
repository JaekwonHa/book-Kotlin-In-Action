data class Client(val name: String, val postalCode: Int)

val client1 = Client("alice", 48202)
val client2 = client1.copy()

println(client1 == client2)
println(client1 === client2)
