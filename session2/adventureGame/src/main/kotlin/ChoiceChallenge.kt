class ChoiceChallenge(var succes:Boolean = false) {
    fun start(){
        println("Well, it looks like that fellow doesn't like to lose and now has a gun pointed at us...")
        println("Quick detective, what should we do?")
        println("Offer him a cigarette (type 1), bribe him (type 2) or try to explain him that he is a complete moron (type 3)?")

        val answer = readLine()

        if(answer == "1"){
            println("Well, it seems the cigarette has calmed down our friend. Maybe we can try playing again?")

        } else if(answer == "2") {
            println("Even loyalty to Moriarty has its limits. We now have the location of Moriarty's layer!")
            println("Let's go!")
            succes = true
        } else if(answer == "3") {
            println("Seriously?! Who thought that was a good idea?!")
            succes = false
        } else {
            println("Now now, stop talking gibberish!")
            start()
        }
    }

    fun wasSuccessful():Boolean{
        return succes
    }
}