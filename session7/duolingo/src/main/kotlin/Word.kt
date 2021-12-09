open class Word(open val original:String,
                open val translated:String,
                open var initialDifficulty:Int,
                val language:String) {
    var difficulty = 10
    set(value){
        if(value < 1){
            field = 1
        } else{
            field = value
        }
    }

}