package `com.ang.main`.Cli
import `com.ang.main`.DTO._
import `com.ang.main`.DAO._
import scala.io.StdIn
import scala.util.matching.Regex


class play {
    val cArgPattern: Regex = "[0-4]".r
    val ques= QuestionDAO.readAllQuestions()
    var continueMenuLoop2 = true
    val player = new Score()
  
    for (q <- ques) {  
       println("0) "+q.question)
       println("1) "+q.choice_one)
       println("2) "+q.choice_two)
       println("3) "+q.choice_four)
       println()
       println("4 to exit out of this game")
       
      while (continueMenuLoop2) {
         println(" ")
        printMenuOptions()
      var inpt = StdIn.readLine()
        
      inpt match {
          case cArgPattern(cmd) if cmd == "0" => {
          //println("something login")
          if(q.answer.equals(0))
             player.score +=1
        }
        case cArgPattern(cmd) if cmd == "1" => {
          continueMenuLoop2 = false
          if(q.answer.equals(1))
           player.score +=1
        }
        case cArgPattern(cmd) if cmd == "2" => {
          if(q.answer.equals(2))
           player.score +=1
        }
        case cArgPattern(cmd) if cmd == "3" => {
          if(q.answer.equals(3))
           player.score +=1
        }
        case cArgPattern(cmd) if cmd == 4 => {
          continueMenuLoop2 = false
          println("A shame, come give it a try again next time!!!!")
        }
        case cArgPattern(cmd) => {
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


      def printMenuOptions(): Unit = {
    List(
      "Game options:",
      "pick from 0-4",
      "4 to exit"
    ).foreach(println)

   }    

}
if(player.score == ques.size-1 || player. score > ques.size/2 ){
    println("Good Job, You got a high score :" + player.score)
   println("Enter your name")
  
    var ipt = StdIn.readLine()
    player.handle = ipt;
    ScoreDAO.createScore(player)
}else
 println("Better luck next time :" + player.score)

}