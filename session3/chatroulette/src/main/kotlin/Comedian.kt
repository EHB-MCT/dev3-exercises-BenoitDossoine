class Comedian(override val name:String):Person(name) {
    fun talk(){
        tellJoke()
    }
    fun tellJoke(){
        println("Orion’s Belt is a huge waist of space.")
    }
}