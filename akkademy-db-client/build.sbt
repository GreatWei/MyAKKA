name := "akkademy-db-client"

version := "1.0"

scalaVersion := "2.11.6"


libraryDependencies ++= Seq(
  "com.akkademy-db" %% "AKKA" % "1.0",
  "org.scala-lang.modules" %% "scala-java8-compat" % "0.8.0",
  "junit" % "junit" % "4.12" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test"
)

