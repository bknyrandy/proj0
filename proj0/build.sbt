lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.13.3"
    )),
    name := "scalatest-example"
  )
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % Test

// https://mvnrepository.com/artifact/io.argonaut/argonaut-scalaz
//scalacOptions ++= Seq("-deprecation", "-feature")

//libraryDependencies += "io.argonaut" %% "argonaut-scalaz" % "6.3.3"

libraryDependencies += "org.postgresql" % "postgresql" % "42.2.19"

// https://mvnrepository.com/artifact/net.liftweb/lift-json
libraryDependencies += "net.liftweb" %% "lift-json" % "3.4.3"

// https://mvnrepository.com/artifact/net.liftweb/lift-json-ext
libraryDependencies += "net.liftweb" %% "lift-json-ext" % "3.4.3"
