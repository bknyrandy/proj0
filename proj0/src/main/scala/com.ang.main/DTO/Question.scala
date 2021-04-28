package `com.ang.main`.DTO

import java.sql.ResultSet

case class Question(id: Int, question: String, answer: Int, ver: Double , choice_one : String,
        choice_two: String, choice_three: String, choice_four: String)


//case class Question(quest_id: Int, question: String, answer: Int, version: Double , choices : List[String])

object Question {

    def fromResultSet(rs : ResultSet) : Question = {
        apply(
            rs.getInt("id"),
            rs.getString("question"),
            rs.getInt("answer"),
            rs.getDouble("ver"),
            rs.getString("choice_one"),
            rs.getString("choice_two"),
            rs.getString("choice_three"),
            rs.getString("choice_four")
        )
    }
}
