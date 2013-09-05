import AssemblyKeys._

organization  := "org.apache.kafka"

name          := "udp-kafka-bridge"

version       := "0.1"

scalaVersion  := "2.10.2"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "akka repo" at "http://repo.akka.io/releases/"
)

libraryDependencies ++= Seq(
  "com.sksamuel.kafka"      %%  "kafka"           % "0.8.0-beta1" excludeAll(
    ExclusionRule(organization = "junit"),
    ExclusionRule(organization = "log4j"),
    ExclusionRule(organization = "org.slf4j")
  ),
  "com.typesafe.akka"       %%  "akka-actor"       % "2.2.1",
  "com.typesafe.akka"       %%  "akka-slf4j"       % "2.2.1"  % "runtime",
  "org.slf4j"               %   "log4j-over-slf4j" % "1.7.5"  % "runtime",
  "ch.qos.logback"          %   "logback-classic"  % "1.0.13" % "runtime",
  "com.typesafe.akka"       %%  "akka-testkit"     % "2.2.1"  % "test",
  "org.specs2"              %%  "specs2"           % "2.2"    % "test"
)

assemblySettings
