name := "AKKA"

version := "1.0"

scalaVersion := "2.11.6"

organization :="com.akkademy-db"

libraryDependencies ++= Seq(
  // Uncomment to use Akka
  "com.typesafe.akka" %% "akka-testkit" % "2.3.6" % "test",
  "com.typesafe.akka" % "akka-actor_2.11" % "2.3.9",
  "com.typesafe.akka" %% "akka-remote" % "2.3.6",
  "org.scala-lang.modules" %% "scala-java8-compat" % "0.8.0",
  "junit"             % "junit"           % "4.12"  % "test",
  "com.novocode"      % "junit-interface" % "0.11"  % "test"
)

mappings in (Compile, packageBin) ~= { _.filterNot { case (_, name) =>
  Seq("application.conf").contains(name)
}}