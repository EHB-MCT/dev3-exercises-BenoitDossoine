class FrenchWord(override val original:String,
                 override val translated:String,
                 override var initialDifficulty:Int):Word(original,translated,initialDifficulty,"french"){
    init{
        difficulty = this.initialDifficulty
        println("")
    }
                 }