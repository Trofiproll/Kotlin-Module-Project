class Note(unitName: String, val text: String): Unit{
    override val name: String = unitName

    override fun onEnter() {
        println("Note \"$name\":\n\"$text\"")
    }
}