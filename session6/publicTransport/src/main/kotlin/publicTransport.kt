import java.sql.*
import java.util.*

fun main() {
    Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance()

    val connectionProps = Properties()
    val credentials = Credentials()
    connectionProps["user"] = credentials.username
    connectionProps["password"] = credentials.password

// Create the connection: this will allow us to run queries on it later
    val connection = DriverManager.getConnection(
        "jdbc:" + "mysql" + "://" +
                "dt5.ehb.be" +
                ":" + "3306" + "/" +
                credentials.username,
        connectionProps
    )

//  FIRST PART OF THE EXERCICES
//
//
//    println("Do you want to search by destination or by platform?")
//    val searchMethod = readLine()
//
//    if(searchMethod == "destination"){
//        println("Where do you want to go?")
//        val destination = readLine()
//
//        val query = "SELECT s6_cities.city_name, s6_rides.departure_time, s6_rides.departure_platform FROM s6_rides LEFT JOIN s6_cities ON s6_cities.id = s6_rides.arrival_city_id WHERE (s6_cities.city_name = ? AND date(s6_rides.departure_time) = CURDATE()) ORDER BY s6_rides.departure_time"
//
//        val statement = connection.prepareStatement(query)
//        statement.setString(1, destination)
//        val result = statement.executeQuery()
//        var counter = 1
//        while(result.next()){
//            println("Train " + counter + " departs at " + result.getTime("departure_time") + " on platform " + result.getInt("departure_platform"))
//            counter++
//        }
//    } else if (searchMethod == "platform"){
//        println("From which platform do you want to leave?")
//        val platform = readLine()
//
//        val query = "SELECT s6_cities.city_name AS arrival_city, s6_rides.departure_time, s6_rides.departure_platform FROM s6_rides LEFT JOIN s6_cities ON s6_cities.id = s6_rides.arrival_city_id WHERE (s6_rides.departure_platform = ? AND date(s6_rides.departure_time) = CURDATE()) ORDER BY s6_rides.departure_time"
//        val statement = connection.prepareStatement(query)
//        statement.setString(1, platform)
//        val result = statement.executeQuery()
//        var counter = 1
//        while(result.next()){
//            println(
//                "Train " + counter + " to " + result.getString("arrival_city") +" departs at " + result.getTime("departure_time")
//            )
//            counter++
//        }
//    } else {
//        println("Wrong input!")
//    }

    println("Where do you want to go?")
    val destination = readLine()

    val query =
        "SELECT s6_rides.id, s6_cities.city_name, s6_rides.departure_time, s6_rides.departure_platform, s6_trains.capacity, s6_rides.passengers FROM s6_rides LEFT JOIN s6_cities ON s6_cities.id = s6_rides.arrival_city_id LEFT JOIN s6_trains ON s6_trains.id = s6_rides.train_id WHERE (s6_cities.city_name = ? AND date(s6_rides.departure_time) = CURDATE()) ORDER BY s6_rides.departure_time LIMIT 1"

    val statement = connection.prepareStatement(query)
    statement.setString(1, destination)
    val result = statement.executeQuery()
    while (result.next()) {
        println(
            "The first train departs at " + result.getTime("departure_time") + " on platform " + result.getInt("departure_platform") + " with " + result.getInt("passengers") + " passengers on board. This train has a capacity of " + result.getInt("capacity") + " passengers.")
        if(result.getInt("passengers") == result.getInt("capacity")){
            println("You can't board this train, it is full!")
            println("Do you want to kick someone off instead? (Y/N)")
            val kickAnswer = readLine()
            if(kickAnswer =="Y"){
                val newPassengerNumber = result.getInt("passengers") - 1
                val updateQuery = "UPDATE s6_rides SET passengers = " + newPassengerNumber + " WHERE s6_rides.id = " + result.getInt("id")
                val updateStatement = connection.prepareStatement(updateQuery)
                updateStatement.executeUpdate()
                println("You succesfully kicked someone off the train. Good job!")
            } else {
                println("You're too kind!")
            }

        } else {
            println("Do you want to board this train? (Y/N)")
            val boardAnswer = readLine()

            if (boardAnswer == "Y"){
                val newPassengerNumber = result.getInt("passengers") + 1
                val updateQuery = "UPDATE s6_rides SET passengers = " + newPassengerNumber + " WHERE s6_rides.id = " + result.getInt("id")
                val updateStatement = connection.prepareStatement(updateQuery)
                updateStatement.executeUpdate()

                println("Welcome aboard!")
            } else {
                println("See you later!")
            }

        }
    }
}
