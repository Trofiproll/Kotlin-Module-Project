import java.util.Scanner

abstract class menu{
    val contentList = mutableListOf<unit>()
    abstract val typeString: String

    protected fun printContentList(){
        if(contentList.size != 0){
            println("\nList of ${typeString}s:")
            var i = 1
            for(content in contentList){
                println("${i++}. ${content.name}")
            }
            println("To go to the ${typeString}, enter its number")
        }
        else println("No ${typeString}s")
        println("To create a${if(typeString == "archive") "n" else ""} ${typeString}, enter \"create\"\nTo exit, enter \"exit\"")
    }

    protected fun input(): Int{
        val inputString = Scanner(System.`in`).nextLine()
        when(inputString.lowercase()){
            "exit" -> return -2
            "create" -> return -3
            else -> {
                if(inputString.toIntOrNull() == null) return -1
                return inputString.toInt()
            }
        }
    }

    protected abstract fun create()

    fun menu(){
        var input = 0
        while(input != -2){
            printContentList()
            input = input()
            when{
                input <= contentList.size && input > 0 -> contentList[input-1].onEnter()
                input == -2 -> return
                input == -3 -> {
                    create()
                }
                else -> println("Incorrect input")
            }
        }
    }
}