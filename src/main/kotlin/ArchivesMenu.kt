import java.util.Scanner

class ArchivesMenu: menu() {
    override val typeString: String = "archive"



    override fun create(){
        println("Enter the name of the ${typeString}:")
        val newName = Scanner(System.`in`).nextLine()
        contentList.add(Archive(newName))
        println("The \"$newName\" ${typeString} has been created!")
    }

}