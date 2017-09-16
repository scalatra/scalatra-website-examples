organization := "com.example"
name := "Scalatra Squeryl"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.12.3"

val ScalatraVersion = "2.6.+"

libraryDependencies ++= Seq(
  "org.scalatra"            %% "scalatra"           % ScalatraVersion,
  "org.scalatra"            %% "scalatra-scalate"   % ScalatraVersion,
  "org.scalatra"            %% "scalatra-scalatest" % ScalatraVersion    % "test",
  "org.squeryl"             %% "squeryl"            % "0.9.5-7",
  "com.h2database"          %  "h2"                 % "1.4.190",
  "com.mchange"             %  "c3p0"               % "0.9.5.2",
  "org.eclipse.jetty"       %  "jetty-webapp"       % "9.2.19.v20160908" % "provided",
  "javax.servlet"           %  "javax.servlet-api"  % "3.1.0"            % "provided"
)

enablePlugins(JettyPlugin)