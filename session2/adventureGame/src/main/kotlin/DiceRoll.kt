class DiceRoll(var succes:Boolean = false) {

    fun start(){
        println("In order to gain knowledge about Moriarty's whereabouts, we should go to The Lion's Head, a club with a...")
        println("... peculiar reputation. Maybe we can challenge someone to a chance game to get some intel?")
        println("That fellow looks like he wants to talk. Let's play his game! Just choose low or high and let him roll the dice.")
        println("Low or High?")

        val diceRoll = rollDice()
        println(diceRoll)
        val answer = readLine()

        if((diceRoll<4 && answer=="Low") || (diceRoll>3 && answer == "High")){
            succes = true
        }
    }

    fun wasSuccesful():Boolean{
        return succes
    }

    private fun rollDice():Int{
        return (1..6).random()
    }
}