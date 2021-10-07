fun main(){
    val choices = arrayOf("Rock", "Paper", "Scissors")
    val randomChoice = choices.random()
    val userChoice = readLine()
    println("The computer has chosen $randomChoice")
    println("You have chosen $userChoice")

    checkResult(randomChoice,userChoice)

}

fun checkResult(computer:String,user:String?){
    if (computer == user){
        println("It's a tie!")
    } else if (computer == "Rock"){
        if(user == "Paper"){
            println("You won!")
        } else if (user == "Scissors"){
            println("You lost!")
        }
    }else if (computer == "Paper") {
        if (user == "Scissors") {
            println("You won!")
        } else if (user == "Rock") {
            println("You lost!")
        }
    }else if (computer == "Scissors"){
        if(user == "Rock"){
            println("You won!")
        } else if (user == "Paper"){
            println("You lost!")
        }
    }
}