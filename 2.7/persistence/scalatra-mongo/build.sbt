val ScalatraVersion = "2.7.+"

organization := "org.scalatra"

name := "Scalatra Mongo"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.13.1"

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.4.19.v20190610" % "container",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
  "org.mongodb.scala" %% "mongo-scala-driver" % "2.8.0",
  "org.mongodb.scala" %% "mongo-scala-bson" % "2.8.0",
  "org.mongodb" % "bson" % "3.12.0",
  "org.mongodb" % "mongodb-driver-core" % "3.12.0",
  "org.mongodb" % "mongodb-driver-async" % "3.12.0"
)

enablePlugins(ScalatraPlugin)
