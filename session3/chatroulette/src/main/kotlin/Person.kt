open class Person (open val name:String){
    open fun introduce(){
        print("Hi, I'm $name!")
    }
}