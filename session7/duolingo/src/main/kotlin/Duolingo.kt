class Duolingo(var listOfWords: MutableSet<Word>) {
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
    }
}