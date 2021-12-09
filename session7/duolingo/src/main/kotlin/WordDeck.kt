class WordDeck {
   val originalListOfWords = mutableSetOf(
        EnglishWord("cow", "koe",2),
        EnglishWord("horse","paard",1),
        EnglishWord("pig", "varken",1),
        EnglishWord("chicken", "kip",1),
        EnglishWord("rabbit", "konijn",1),
        EnglishWord("dog", "hond",1),
        EnglishWord("cat", "kat",2),
        EnglishWord("bee", "bij",2),
        EnglishWord("wasp", "wesp",2),
        EnglishWord("bull", "stier",2),
        FrenchWord("vache", "koe",1),
        FrenchWord("cheval","paard",1),
        FrenchWord("cochon", "varken",1),
        FrenchWord("poule", "kip",1),
        FrenchWord("lapin", "konijn",1),
        FrenchWord("chien", "hond",1),
        FrenchWord("chat", "kat",2),
        FrenchWord("abeille", "bij",2),
        FrenchWord("guèpe", "wesp",2),
        FrenchWord("taureau", "stier",2)
    )
    var listOfWords  = originalListOfWords

    fun filterByLanguage(language:String){
        listOfWords =  listOfWords.filter{word -> word.language == language}.toMutableSet()
    }

    fun filterByDifficulty(difficulty:Int){
        listOfWords = listOfWords.filter{word -> word.initialDifficulty >= difficulty}.toMutableSet()
    }

    fun selectWords(roundSize:Int){
        listOfWords = listOfWords.shuffled().take(roundSize).toMutableSet()
    }

    fun resetWords(){
        listOfWords = originalListOfWords
    }
}