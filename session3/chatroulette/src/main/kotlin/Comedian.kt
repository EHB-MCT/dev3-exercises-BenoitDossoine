class Comedian(override val name:String):Person(name),ChatPartner {

    override fun talk(){
        tellJoke()
    }

    fun tellJoke(){
        println("Orion’s Belt is a huge waist of space.")
    }
}