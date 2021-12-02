import kotlin.math.round
import java.util.Timer
import kotlin.concurrent.schedule

class Duolingo{
    var roundSize:Int = 5
    var listOfWords:MutableSet<Word> = mutableSetOf()
    var language:String = "english"
    var difficulty:String = "easy"

    constructor(roundSize:Int = 5, language:String = "english"){
        this.roundSize = roundSize
        this.language = language
        initialize()
    }

    constructor(difficulty:String){
        this.difficulty = difficulty
        if(difficulty == "easy") {
            this.roundSize = 3
            this.language = "french"
        } else {
            this.roundSize = 6
        }
        initialize()
    }
    fun initialize(){
        listOfWords = mutableSetOf(
            EnglishWord("cow", "koe"),
            EnglishWord("horse","paard"),
            EnglishWord("pig", "varken"),
            EnglishWord("chicken", "kip"),
            EnglishWord("rabbit", "konijn"),
            EnglishWord("dog", "hond"),
            EnglishWord("cat", "kat"),
            EnglishWord("bee", "bij"),
            EnglishWord("wasp", "wesp"),
            EnglishWord("bull", "stier"),
            FrenchWord("vache", "koe"),
            FrenchWord("cheval","paard"),
            FrenchWord("cochon", "varken"),
            FrenchWord("poule", "kip"),
            FrenchWord("lapin", "konijn"),
            FrenchWord("chien", "hond"),
            FrenchWord("chat", "kat"),
            FrenchWord("abeille", "bij"),
            FrenchWord("guèpe", "wesp"),
            FrenchWord("taureau", "stier"),
        )
        if(this.difficulty == "easy"){
            listOfWords = listOfWords.filter{it.language == language}.toMutableSet()
        }
    }

    fun play(){
        println("Welcome to Duolingo, the no-UX edition!")
        println("Translate the following words:")

        val selectedWords = selectWords(listOfWords, roundSize)
        translateWords(selectedWords)

    }

    private fun selectWords(listOfWords: MutableSet<Word>, roundSize: Int):MutableSet<Word>{
        return listOfWords.shuffled().take(roundSize).toMutableSet()
    }

    private fun translateWords(selectedWords:MutableSet<Word>){
        val mistakes = mutableSetOf<Word>()
        var madeMistake = false
        var counter = 1
        selectedWords.forEach{
            println("This is word $counter of the ${selectedWords.count()}.")
            println("The words is: ${it.original}")
            println("What is the traduction?")
            val answer = readLine()
            Thread.sleep(100)
            if(answer == it.translated){
                    println("Perfect! Well done!")
            } else {
                println("Oh no, that's not correct.")
                println("The correct answer was ${it.translated}")
                println("Let's try that one again later!")
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