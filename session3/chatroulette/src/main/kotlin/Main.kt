fun main(){
    val people = arrayOf(Student("Benoît"),Teacher("Finn"),Comedian("Ilyes"),Chatbot())
    val randomPerson = people.random()
    randomPerson.introduce()
    randomPerson.talk()
}


