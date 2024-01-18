import java.util.Scanner

class ArchivesMenu: Menu() {
    override val typeString: String = "archive"



    override fun create(){
        println("Enter the name of the $typeString:")
        var newName = Scanner(System.`in`).nextLine()
        while(newName.isEmpty()){
            println("Empty name is not allowed. Enter the name")
            newName = Scanner(System.`in`).nextLine()
        }
        contentList.add(Archive(newName))
        println("The \"$newName\" $typeString has been created!")
    }

}