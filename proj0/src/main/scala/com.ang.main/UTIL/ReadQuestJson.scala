package `com.ang.main`.UTIL
import net.liftweb.json._
import scala.io.BufferedSource
import scala.io.Source
import `com.ang.main`.DTO.Question
import `com.ang.main`.DAO.QuestionDAO

object ReadQuestJson {
  
implicit val formats = DefaultFormats

def readQuestJson() : String ={
        var qJson : BufferedSource = null
        try{
            qJson = Source.fromFile("Questions.json")
            qJson.getLines().mkString(" ")
        }
        finally {
           if(qJson != null)  qJson.close()
        }
    }


//println(QuestionDAO.readAllQuestions())

//readQuestJson()
  //def main(args: Array[String]): Unit = {
  def addtoDB(): Unit = {
     val json = parse(readQuestJson())
   // val checList = QuestionDAO.readAllQuestions()
    val elements = (json \\ "questionz").children
    for ( ques <- elements ) {
      val q = ques.extract[Question]
      
    QuestionDAO.createQuestion(q)
    }

    }
           
        }
    
  
  



/*
 println(q.quest_id)
      println(q.question)
      println(q.answer)
      println(q.ver)
      println(q.choice_one)
      println(q.choice_two)
      println(q.choice_three)
      println(q.choice_four)


*/

//var x = 0
      //println(q.isInstanceOf)
 /*    if(checList.nonEmpty){
      for(ck <- checList) {
     if(!ck.question.equalsIgnoreCase(q.question) && x == checList.size-1){
                QuestionDAO.createQuestion(q)
     }
     x+=1
      } 
     
    }else */