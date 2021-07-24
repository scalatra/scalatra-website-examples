organization := "org.scalatra.slickexample"
name := "Scalatra Slick"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.13.6"

val ScalatraVersion = "2.8.0"

libraryDependencies ++= Seq(
  "org.scalatra"            %% "scalatra"          % ScalatraVersion,
  "org.scalatra"            %% "scalatra-specs2"   % ScalatraVersion    % "test",
  "com.typesafe.slick"      %% "slick"             % "3.3.3",
  "com.h2database"          %  "h2"                % "1.4.200",
  "com.mchange"             %  "c3p0"              % "0.9.5.5",
  "ch.qos.logback"          %  "logback-classic"   % "1.2.3"             % "provided",
  "org.eclipse.jetty"       %  "jetty-webapp"      % "9.4.35.v20201120"  % "provided",
  "javax.servlet"           %  "javax.servlet-api" % "3.1.0"             % "provided"
)

enablePlugins(JettyPlugin)
