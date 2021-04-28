package `com.ang.main`.Cli
import `com.ang.main`.DAO.ScoreDAO
import scala.io.StdIn
import scala.util.matching.Regex
import java.io.FileNotFoundException
import scala.collection.mutable.Map

class Cli {

  //I'm going to use a little regex to make our lives easier
  // good to look into!
  // we're going to extract commands and argument(s) from user input
  val commandArgPattern: Regex = "(\\w+)\\s*(.*)".r

 

  /** runs the main menu, on a loop
    */
  def menu(): Unit = {
    printWelcome()
    var continueMenuLoop = true
    while (continueMenuLoop) {
      println()
      printMenuOptions()
      //we can get user input via StdIn.  I'm going to grab a line at a time:
      // this is blocking, so program flow will not continue until input is received
      var input = StdIn.readLine()
      input match {
          case commandArgPattern(cmd, arg) if cmd == "play" => {
          val start = new play()
        }
          case commandArgPattern(cmd, arg) if cmd == "show" => {
          val scores = ScoreDAO.readAllScore()
          for(x<- scores)
         // println(s|$x.id , $x.handle  : $x.score""".stripMargin)e
          println(x.id+ ") "+ x.handle + " :"+ " "+ x.score )
         
        }
          
        case commandArgPattern(cmd, arg) if cmd == "exit" => {
          continueMenuLoop = false
          println("A shame, come give it a try again next time!!!!")
        }
        case commandArgPattern(cmd) => {
          println(
            s"Parsed command $cmd did not correspond to an option"
          )
        }
        case _ => {
          //default case if no other cases are matched
          println("Failed to parse command.")
        }
      }

    }

  }

  def printWelcome(): Unit = {
    println("Welcome to an exciting game of Guess that, Trivia")
  }

  def printMenuOptions(): Unit = {
    List(
      "Menu options:",
      "play to start the game",
      "show to view high score",
      "exit: exits the game"
    ).foreach(println)

  }

}




