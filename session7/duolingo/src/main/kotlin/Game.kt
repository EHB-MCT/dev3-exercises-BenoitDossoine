open class Game(open var difficulty:String,open var language:String) {
    private var roundSize:Int = 3
    val wordDeck:WordDeck = WordDeck()

    fun setup(){
        try {
            if (this.difficulty == "easy") {
                this.roundSize = 3
            } else if (this.difficulty == "difficult"){
                this.roundSize = 6
            } else {
                throw IllegalArgumentException("Input is invalid")
            }

            if(this.language !="french" && this.language !="english"){
                throw IllegalArgumentException("Input is invalid")
            }

        } catch(exception: IllegalArgumentException){
            println("Bad argument. Game was started in easy mode.")
            this.difficulty = "easy"
            this.language = "english"
        }
    }

    fun play(){
        println("Welcome to Duolingo, the no-UX edition!")
        println("Translate the following words:")

        if(this.difficulty == "difficult"){
            wordDeck.filterByDifficulty(2)
        }
        wordDeck.filterByLanguage(language)
        wordDeck.selectWords(roundSize)
    }


}