class Teacher(overrides val name:String):Person(name) {
    fun talk(){
        funFact()
    }
    fun funFact(){
        println("Did you know that sheep can't swim?")
    }
}