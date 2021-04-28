package `com.ang.main`.DAO
import `com.ang.main`.DTO.Question
import scala.util.Using
import java.sql.ResultSet
import scala.collection.mutable.ArrayBuffer
import `com.ang.main`.ConnectionManager.ConnectionManager

object QuestionDAO {

//crud

def readAllQuestions() : Seq[Question] = {
    val conn = ConnectionManager.getConnection()
    Using.Manager { use => 
        val stmt = use(conn.prepareStatement("SELECT * FROM question;" ))
        stmt.execute()
        val rs = use(stmt.getResultSet())
        
        val allQuestions: ArrayBuffer[Question] = ArrayBuffer()
        while(rs.next()) {
            allQuestions.addOne(Question.fromResultSet(rs))
        }
        allQuestions.toList
}.get
}

    //not needed
//    def readScore(quest: Question) : Seq[Question] = {
      //   choice_one : String,
        //choice_two: String, choice_three: String, choice_four: String)
    //    new Question
  //  }

    def createQuestion(quest: Question) : Boolean = {
        val conn = ConnectionManager.getConnection()
        Using.Manager { use => 
        val stmt = use(conn.prepareStatement("INSERT INTO question VALUES (DEFAULT, ?, ?,?,?,?,?,?);"))
        stmt.setString(1, quest.question)
        stmt.setInt(2, quest.answer)
        stmt.setDouble(3, quest.ver)
        stmt.setString(4, quest.choice_one)
        stmt.setString(5, quest.choice_two)
        stmt.setString(6, quest.choice_three)
        stmt.setString(7, quest.choice_four)

        stmt.execute()
        

        stmt.getUpdateCount() > 0
    }.getOrElse(false)
    


    }




}

