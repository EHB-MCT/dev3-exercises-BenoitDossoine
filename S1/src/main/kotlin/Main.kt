fun main(){
    val classmates = arrayOf("Freya", "Finn","Benoit","Ilyes")
    for (classmate in classmates){
        greeting(classmate)
    }
}

fun greeting(classmate:String){
    println("Hello " + classmate)
}