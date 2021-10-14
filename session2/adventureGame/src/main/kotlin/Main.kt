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
    val answer = readLine()

    if((diceRoll<4 && answer=="Low") || (diceRoll>3 && answer == "High")){
        challengeThree()
    } else {
        gameOver()
    }
}

fun challengeThree(){
    println("Well, it looks like that fellow doesn't like to lose and now has a gun pointed at us...")
    println("Quick detective, what should we do?")
    println("Offer him a cigarette (type 1), bribe him (type 2) or try to explain him that he is a complete moron (type 3)?")

    val answer = readLine()

    if(answer == "1"){
        println("Well, it seems the cigarette has calmed down our friend. Maybe we can try playing again?")
        challengeTwo()
    } else if(answer == "2") {
        println("Even loyalty to Moriarty has its limits. We now have the location of Moriarty's layer!")
        println("Let's go!")
        challengeFour()
    } else if(answer == "3") {
        println("Seriously?! Who thought that was a good idea?!")
        gameOver()
    } else {
        println("Now now, stop talking gibberish!")
        challengeThree()
    }
}

fun challengeFour(){
    val randomNumber:Int = (1..100).random()
    println("Here it is, the entrance to Moriarty's lair! But it is locked with a code...")
    println("I'm pretty sure the code is Moriarty's favorite number!")
    println("Maybe you can guess it? I think it is between 1 and 100.")
    var answer = 0

    while(answer != randomNumber){
        answer = readLine()!!.toInt()
        if(answer> randomNumber){
            println("Hmmm, I think Moriarty's favorite number would be lower...")
        } else if (answer < randomNumber){
            println("Now, you know Moriarty: he would aim higher!")
        }
    }

    endBoss()
}

fun endBoss(){
    println("Blimey, there he is! And he challenges us to one of his riddles.")
    println("If you can solve Moriarty's riddle, he will turn himself in.")
    println("Can you guess from which word the following is an anagram?")

    val possibleAnswers = mapOf("moon starer" to "astronomer","dirty room" to "dormitory", "the classroom" to "schoolmaster")
    var tries = 3

    while(tries > 0){
        val randomPicked = possibleAnswers.keys.random()
        println(randomPicked)
        val answer = readLine()

        if(answer == possibleAnswers.get(randomPicked)){
            win()
            return
        } else {
            tries--
            println("Hmm, try again. You still have $tries tries!")
        }
    }

    gameOver()
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