println(StringBuilder().apply sb@ {
    listOf(1, 2, 3).apply {
        this@sb.append(this.toString())
    }
})
