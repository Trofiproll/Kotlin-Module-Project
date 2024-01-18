import java.util.Scanner

const val EXIT = -2
const val CREATE = -3
const val ERR = -1

abstract class Menu{
    val contentList = mutableListOf<Unit>()
    abstract val typeString: String



    protected fun printContentList(){
        println("\nList of ${typeString}s:\n0. create")
        var i = 1
        for(content in contentList){
            println("${i++}. ${content.name}")
        }
        println("$i. exit")
        println("To move to the $typeString, enter its number, '0' or \"$i\" to create $typeString or exit")
    }

    protected fun input(): Int{
        val inputString = Scanner(System.`in`).nextLine()
        when(inputString.lowercase()){
            "${contentList.size+1}" -> return EXIT
            "0" -> return CREATE
            else -> {
                if(inputString.toIntOrNull() == null) return ERR
                return inputString.toInt()
            }
        }
    }

    protected abstract fun create()

    fun menu(){
        var input = 0
        while(input != EXIT){
            printContentList()
            input = input()
            when{
                input <= contentList.size && input > 0 -> contentList[input-1].onEnter()
                input == EXIT -> return
                input == CREATE -> create()
                else -> println("Incorrect input")
            }
        }
    }
}