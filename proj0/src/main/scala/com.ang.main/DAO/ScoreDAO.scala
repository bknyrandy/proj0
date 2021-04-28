package `com.ang.main`.DAO
import scala.util.Using
import java.sql.ResultSet
import scala.collection.mutable.ArrayBuffer
import `com.ang.main`.DTO.Score
import `com.ang.main`.ConnectionManager.ConnectionManager

object ScoreDAO {
  //crud

    def readAllScore() : Seq[Score] = {
    val conn = ConnectionManager.getConnection()
    Using.Manager { use => 
        val stmt = use(conn.prepareStatement("SELECT * FROM score;" ))
        stmt.execute()
        val rs = use(stmt.getResultSet())

        val allScores: ArrayBuffer[Score] = ArrayBuffer()
        while(rs.next()) {
            allScores.addOne(Score.fromResultSet(rs))
        }
         allScores.toList

        }.get
    
    }


/*              //not needed
    def readScore(score: Score) : Seq[Score] = {
        
        new Score
    }
*/

    def createScore(score: Score) : Boolean = {
        val conn = ConnectionManager.getConnection()
    Using.Manager { use => 
        val stmt = use(conn.prepareStatement("INSERT INTO score VALUES (DEFAULT, ?, ?);"))
        stmt.setString(1, score.handle)
        stmt.setInt(2, score.score)
        stmt.execute()

        stmt.getUpdateCount() > 0
    }.getOrElse(false)
    }

}
