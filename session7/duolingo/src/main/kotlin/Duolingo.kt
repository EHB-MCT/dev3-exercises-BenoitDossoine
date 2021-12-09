class Duolingo(override var difficulty: String,
               override var language: String):Game(difficulty,language)
{
    fun run(){
        setup()
        play()
        translateWords(wordDeck.listOfWords)
    }

    private fun translateWords(selectedWords:MutableSet<Word>){
        val mistakes = mutableSetOf<Word>()
        var madeMistake = false
        var counter = 1
        selectedWords.forEach{
            println("This is word $counter of the ${selectedWords.count()}.")
            println("The words is: ${it.original}. It has a difficulty rating of ${it.difficulty}.")
            println("What is the traduction?")
            val answer = readLine()
            Thread.sleep(100)
            if(answer == it.translated){
                    println("Perfect! Well done!")
                    it.difficulty -= 1
            } else if(answer == "Hint") {
                    println(it.translated.first())
            } else {
                println("Oh no, that's not correct.")
                println("The correct answer was ${it.translated}")
                println("Let's try that one again later!")
                it.difficulty += 2
                mistakes.add(it)
                madeMistake = true
            }
            counter++
            Thread.sleep(400)
        }

        if(madeMistake) {
            println("Let retry the difficult ones!")
            translateWords(mistakes)
        }
    }
}