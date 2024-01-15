import java.util.Scanner

class ArchivesMenu {
    val archivesList = mutableListOf<Archive>()

    fun printArchivesList(){
        if(archivesList.size != 0){
            println("Список архивов:")
            var i = 1
            for(archive in archivesList){
                println("${i++}. ${archive.name}")
            }
        }
        else println("Архивов нет")
        println("Чтобы создать архив, введите \"создать\"\nЧтобы выйти, введите \"выход\"")
    }

    fun input(): Int{
        val inputString = Scanner(System.`in`).nextLine()
        when(inputString.lowercase()){
            "выход" -> println("dsf")
            "создать" -> println("fsdf")

        }

    }
}