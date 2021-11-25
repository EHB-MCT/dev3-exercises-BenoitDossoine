import java.sql.*
import java.util.*

fun main(){
    Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance()

    val connectionProps = Properties()
    val credentials = Credentials()
    connectionProps["user"] = credentials.username
    connectionProps["password"] = credentials.password

// Create the connection: this will allow us to run queries on it later
    val connection =  DriverManager.getConnection(
        "jdbc:" + "mysql" + "://" +
                "dt5.ehb.be" +
                ":" + "3306" + "/" +
                credentials.username,
        connectionProps)

    println("Where do you want to go?")
    val destination = readLine()

    val query = "SELECT s6_cities.city_name, s6_rides.departure_time, s6_rides.departure_platform FROM s6_rides LEFT JOIN s6_cities ON s6_cities.id = s6_rides.arrival_city_id WHERE (s6_cities.city_name = ? AND date(s6_rides.departure_time) = CURDATE()) ORDER BY s6_rides.departure_time"

    val statement = connection.prepareStatement(query)
    statement.setString(1, destination)
    val result = statement.executeQuery()

    var counter = 1
    while(result.next()){
        println("Train " + counter + " departs at " + result.getTime("departure_time") + " on platform " + result.getInt("departure_platform"))
        counter++
    }
}