class DuolingoLive(difficulty:String, language:String):Game(difficulty,language) {
    fun run(){
        setup()
        play()
        translateWords(wordDeck.listOfWords)
    }

    fun translateWords(selectedWords:MutableSet<Word>){
        val lives
        if(difficulty == "difficult"){
            lives = 2
        } else {
            lives = 3
        }
        selectedWords.forEach{

        }
    }
}