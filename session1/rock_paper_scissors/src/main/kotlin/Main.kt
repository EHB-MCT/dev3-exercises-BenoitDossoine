fun main(){
    val choices = arrayOf("Rock", "Paper", "Scissors", "Lizard", "Spock")
    var userScore = 0

    while(true){
        var randomChoice = choices.random()

        println("Make your choice:")
        var userChoice = readLine()


        println("The computer has chosen $randomChoice")
        println("You have chosen $userChoice")

        var result = checkResult(randomChoice,userChoice)
        if(result == true){
            userScore ++
        }
        println("Your score: $userScore")
    }
}

fun checkResult(computer:String,user:String?):Boolean?{
    if(user != "Rock" && user !="Paper" && user !="Scissors" && user !="Lizard" && user!="Spock"){
        println("Make sure you type Rock, Paper or Scissors!")
        return false
    } else if (computer == user){
        println("It's a tie!")
        return false
    } else if (computer == "Rock") {
        if (user == "Paper") {
            println("You won!")
            return true
        } else if (user == "Scissors") {
            println("You lost!")
            return false
        } else if (user == "Spock") {
            println("You won!")
            return true
        } else if (user == "Lizard"){
            println("You lost!")
            return false
        }else {
            return false
        }
    } else if (computer == "Paper") {
        if (user == "Scissors") {
            println("You won!")
            return true
        } else if (user == "Rock") {
            println("You lost!")
            return false
        } else if (user == "Spock") {
            println("You lost!")
            return false
        } else if (user == "Lizard"){
            println("You won!")
            return true
        }else {
            return false
        }
    } else if (computer == "Scissors"){
        if(user == "Rock"){
            println("You won!")
            return true
        } else if (user == "Paper"){
            println("You lost!")
            return false
        }else if (user == "Spock") {
            println("You won!")
            return true
        } else if (user == "Lizard"){
            println("You lost!")
            return false
        }else {
            return false
        }
    } else if (computer == "Spock"){
        if(user == "Rock"){
            println("You lost!")
            return false
        } else if (user == "Paper"){
            println("You won!")
            return true
        }else if (user == "Scissors") {
            println("You lost!")
            return false
        } else if (user == "Lizard"){
            println("You won!")
            return true
        }else {
            return false
        }
    } else if (computer == "Lizard"){
        if(user == "Rock"){
            println("You won!")
            return true
        } else if (user == "Paper"){
            println("You lost!")
            return false
        }else if (user == "Spock") {
            println("You lost!")
            return false
        } else if (user == "Scissors"){
            println("You won!")
            return true
        } else {
            return false
        }
    } else {
        return false
    }
}