fun main(){
    println("Welcome detective! Sherlock Holmes needs you for his latest investigation.")
    println("He is on the verge of discovering Moriarty's layer. But in order to do that, you will have to face 5 challenges.")
    println("Let's start with the first challenge!")
    challengeOne()
}

fun challengeOne(){
    println("For this challenge, let's make sure you are not one of Moriarty's spies.")
    println("Can you name one of Sherlock's closest friends by their last name?")

    val answers = setOf<String>("Watson", "Lestrade", "Hooper", "Hudson")
    val answer = readLine()

    if (answers.contains(answer)){
        win()
    } else {
        gameOver()
    }
}

fun win(){
    println("Well done! We caught Moriarty!")
}

fun gameOver(){
    println("Good God, we lost! Let's try again next time, shall we?")
}