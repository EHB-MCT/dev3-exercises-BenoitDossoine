fun main(){
    val people = arrayOf(Person("Benoît"),Person("Finn"))
    val randomPerson = people.random()
    randomPerson.introduce()
}