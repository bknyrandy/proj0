package `com.ang.main`.DTO

import java.sql.ResultSet

 case class Score(id: Int = 0, var handle: String = "guest", var score: Int = 0)


 object Score {
    def fromResultSet(rs : ResultSet) : Score = {
        apply (
            rs.getInt("id"),
            rs.getString("handle"),
            rs.getInt("score")
        )
    }

 }