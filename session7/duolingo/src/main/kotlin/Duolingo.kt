class Duolingo(var listOfWords: MutableSet<Word> = mutableSetOf()) {
    init{
        listOfWords = mutableSetOf(
            Word("cow", "koe", "english"),
            Word("horse","paard", "english"),
            Word("pig", "varken", "english"),
            Word("chicken", "kip", "english"),
            Word("rabbit", "konijn", "english"),
            Word("dog", "hond", "english"),
            Word("cat", "kat", "english"),
            Word("bee", "bij", "english"),
            Word("wasp", "wesp", "english"),
            Word("bull", "stier", "english"),
            Word("vache", "koe", "french"),
            Word("cheval","paard", "french"),
            Word("cochon", "varken", "french"),
            Word("poule", "kip", "french"),
            Word("lapin", "konijn", "french"),
            Word("chien", "hond", "french"),
            Word("chat", "kat", "french"),
            Word("abeille", "bij", "french"),
            Word("guèpe", "wesp", "french"),
            Word("taureau", "stier", "french"),
        )
    }

    fun play(){
        println("Welcome to Duolingo, the no-UX edition!")
        println("Translate the following words:")

        val selectedWords = selectWords(listOfWords)
        translateWords(selectedWords)

    }

    fun selectWords(listOfWords: MutableSet<Word>):MutableSet<Word>{
        var counter = 1
        val selectedWords = mutableSetOf<Word>()
        while(counter < 6){
            val selectedWord = listOfWords.random()
            selectedWords.add(selectedWord)
            listOfWords.removeIf{it == selectedWord}
            counter++
        }
        return selectedWords
    }

    fun translateWords(selectedWords:MutableSet<Word>){
        val mistakes = mutableSetOf<Word>()
        var madeMistake = false
        var counter = 1
        selectedWords.forEach{
            println("The words is: ${it.original}")
            println("What is the traduction?")
            val answer = readLine()
            if(answer == it.translated){
                println("Perfect! Well done!")

            } else {
                println("Oh no, that's not correct.")
                println("The correct answer was ${it.translated}")
                println("Let's try that one again later!")
                mistakes.add(it)
                madeMistake = true
            }
        }

        if(madeMistake) {
            println("Let retry the difficult ones!")
            translateWords(mistakes)
        }
    }
}