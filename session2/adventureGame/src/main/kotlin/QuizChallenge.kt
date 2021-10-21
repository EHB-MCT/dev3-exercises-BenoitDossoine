class QuizChallenge(var wasSuccesful:Boolean) {

    fun start(){
        println("For this challenge, let's make sure you are not one of Moriarty's spies.")
        println("Can you name one of Sherlock's closest friends by their last name?")

        val answers = setOf<String>("Watson", "Lestrade", "Hooper", "Hudson")
        val answer = readLine()

        wasSuccesful = answers.contains(answer)
    }
}