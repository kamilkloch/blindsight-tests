val logbackVersion = "1.4.8"
val terseLogbackVersion = "1.2.0"
val blindsightVersion = "2.0.0"
val janinoVersion = "3.1.10"

val blindsightLogging = Seq(
  "ch.qos.logback" % "logback-classic" % logbackVersion,
  "net.logstash.logback" % "logstash-logback-encoder" % "7.4",
  "org.codehaus.janino" % "janino" % janinoVersion, // conditional processing of configuration files
  "com.tersesystems.logback" % "logback-classic" % terseLogbackVersion,
  "com.tersesystems.logback" % "logback-uniqueid-appender" % terseLogbackVersion,

  // https://tersesystems.github.io/terse-logback/1.2.0/guide/budget/
  "com.tersesystems.logback" % "logback-budget" % terseLogbackVersion,

  // https://tersesystems.github.io/blindsight/usage/inspections.html
  "com.tersesystems.blindsight" %% "blindsight-inspection" % blindsightVersion,


  "com.tersesystems.blindsight" %% "blindsight-logstash" % blindsightVersion,

  "org.fusesource.jansi" % "jansi" % "1.18",
)

scalaVersion := "2.13.11"
name := "blindsight-tests"
libraryDependencies ++= blindsightLogging
scalacOptions ++= Seq("-release", "17")
javacOptions ++= Seq("-source", "17", "-target", "17")
javaOptions ++= Seq(
  "--add-opens", "java.base/sun.nio.ch=ALL-UNNAMED",
  "--add-opens", "java.base/java.util.zip=ALL-UNNAMED",
  "-XX:+UseZGC",
)

