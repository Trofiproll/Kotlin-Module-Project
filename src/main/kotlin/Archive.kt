import java.util.Scanner

class Archive (unitName: String):menu(), unit{
    override val name: String = unitName
    override val typeString: String = "note"

    override fun create() {
        println("Enter the name of the $typeString:")
        var newName = Scanner(System.`in`).nextLine()
        while(newName.isEmpty()){
            println("Empty name is not allowed. Enter the name")
            newName = Scanner(System.`in`).nextLine()
        }
        println("Enter the text of the $typeString:")
        var newText = Scanner(System.`in`).nextLine()
        while(newText.isEmpty()){
            println("Empty text is not allowed. Enter the text")
            newText = Scanner(System.`in`).nextLine()
        }
        contentList.add(Note(newName, newText))
        println("The \"$newName\" $typeString has been created!")
    }

    override fun onEnter() {
        println("You are in \"$name\" archive")
        this.menu()
    }
}