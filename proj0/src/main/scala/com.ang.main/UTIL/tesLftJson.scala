package `com.ang.main`.UTIL
//import net.liftweb.json.
import net.liftweb.json._
import scala.io.BufferedSource
import scala.io.Source


object tesLftJson {
 

  implicit val formats = DefaultFormats

  val mailAccountString ="""
{
  "accounts": [
  { "emailAccount": {
    "accountName": "YMail",
    "username": "USERNAME",
    "password": "PASSWORD",
    "url": "imap.yahoo.com",
    "minutesBetweenChecks": 1,
    "usersOfInterest": ["barney", "betty", "wilma"]
  }},
  { "emailAccount": {
    "accountName": "Gmail",
    "username": "USER",
    "password": "PASS",
    "url": "imap.gmail.com",
    "minutesBetweenChecks": 1,
    "usersOfInterest": ["pebbles", "bam-bam"]
  }}
  ]
}
"""
def readQuestJson() : String ={
        var qJson : BufferedSource = null
        try{
            qJson = Source.fromFile("test.json")
            qJson.getLines().mkString(" ")
        }
        finally {
           if(qJson != null)  qJson.close()
        }
    }




//readQuestJson()
  
  def main(args: Array[String]): Unit = {
    //   val json = parse(mailAccountString)
    val json = parse(readQuestJson())
    val elements = (json \\ "emailAccount").children
    for ( acct <- elements ) {
      val m = acct.extract[EmailAccount]
      println(m.url)
      println(m.username)
      println(m.password)
      m.usersOfInterest.foreach(println)
    }
  }
  
}

/**
 * A case class to match the json properties.
 */
case class EmailAccount(
  accountName: String,
  url: String, 
  username: String, 
  password: String,
  minutesBetweenChecks: Int,
  usersOfInterest: List[String]
)