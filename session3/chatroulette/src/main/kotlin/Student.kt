class Student(override val name: String):Person(name),ChatPartner {

    override fun talk(){
        gossip()
    }

    fun gossip(){
        println("Did you hear that juicy gossip?")
    }
}