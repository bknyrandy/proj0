package `com.ang.main`
import `com.ang.main`.ConnectionManager
import `com.ang.main`.UTIL.ReadQuestJson
import `com.ang.main`.Cli.Cli

object Main extends App {
 // println("Hello, World!")
ReadQuestJson.addtoDB()
val start = new Cli
start.menu()

}

