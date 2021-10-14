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
        challengeTwo()
    } else {
        gameOver()
    }
}

fun challengeTwo(){
    println("In order to gain knowledge about Moriarty's whereabouts, we should go to The Lion's Head, a club with a...")
    println("... peculiar reputation. Maybe we can challenge someone to a chance game to get some intel?")
    println("That fellow looks like he wants to talk. Let's play his game! Just choose low or high and let him roll the dice.")
    println("Low or High?")
    
    val diceRoll = rollDice()
    println(diceRoll)
    val answer = readLine()

    if((diceRoll<4 && answer=="Low") || (diceRoll>3 && answer == "High")){
        win()
    } else {
        gameOver()
    }
}

fun rollDice():Int{
    return (1..6).random()
}

fun win(){
    println("Well done! We caught Moriarty!")
}

fun gameOver(){
    println("Good God, we lost! Let's try again next time, shall we?")
}