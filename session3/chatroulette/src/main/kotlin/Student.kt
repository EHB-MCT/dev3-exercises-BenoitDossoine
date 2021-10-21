class Student(override val name: String):Person(name) {
    fun gossip(){
        println("Did you hear that juicy gossip?")
    }
}