fun main(){
    val people = arrayOf(Student("Benoît"),Teacher("Finn"),Comedian("Ilyes"))
    val randomPerson = people.random()
    randomPerson.introduce()
    randomPerson.talk()



}