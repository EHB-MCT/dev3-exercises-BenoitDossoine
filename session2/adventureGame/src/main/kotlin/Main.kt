fun main(){
    println("Welcome detective! Sherlock Holmes needs you for his latest investigation.")
    println("He is on the verge of discovering Moriarty's layer. But in order to do that, you will have to face 5 challenges.")
    println("Let's start with the first challenge!")

    val quizChallenge = QuizChallenge()
    quizChallenge.start()
    if (quizChallenge.wasSuccesful()){
        val diceRoll = DiceRoll()
        diceRoll.start()
        if(diceRoll.wasSuccesful()){
            val choiceChallenge = ChoiceChallenge()
            choiceChallenge.start()
            if(choiceChallenge.wasSuccesful())
        } else {
            gameOver()
        }
    } else {
        gameOver()
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



fun win(){
    println("Well done! We caught Moriarty!")
}

fun gameOver(){
    println("Good God, we lost! Let's try again next time, shall we?")
}