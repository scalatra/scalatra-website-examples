val ScalatraVersion = "2.8.2"

organization := "org.scalatra"

name := "Scalatra Mongo"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.13.6"

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.4.35.v20201120" % "container",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
  "org.mongodb.scala" %% "mongo-scala-driver" % "4.1.1",
  "org.mongodb.scala" %% "mongo-scala-bson" % "4.1.1",
  "org.mongodb" % "bson" % "4.1.1",
  "org.mongodb" % "mongodb-driver-core" % "4.1.1",
  "org.mongodb" % "mongodb-driver-async" % "3.12.7"
)

enablePlugins(JettyPlugin)
