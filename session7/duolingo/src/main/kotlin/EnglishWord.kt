class EnglishWord(override val original:String,
                  override val translated:String,
                  override var initialDifficulty:Int):Word(original,translated,initialDifficulty,"english") {
    init{
        difficulty = this.initialDifficulty
        println("")
    }
}