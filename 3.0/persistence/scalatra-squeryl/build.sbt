organization := "com.example"
name := "Scalatra Squeryl"
version := "0.1.0-SNAPSHOT"
scalaVersion := "3.3.1"

val ScalatraVersion = "3.0.0"

libraryDependencies ++= Seq(
  "org.squeryl"       %% "squeryl"                    % "0.10.0",
  "com.h2database"    %  "h2"                         % "1.4.200",
  "com.mchange"       %  "c3p0"                       % "0.9.5.5",
  "org.scalatra"      %% "scalatra-jakarta"           % ScalatraVersion,
  "org.scalatra"      %% "scalatra-scalatest-jakarta" % ScalatraVersion % Test,
  "ch.qos.logback"    % "logback-classic"             % "1.4.11"        % Provided,
  "org.eclipse.jetty" %  "jetty-webapp"               % "11.0.15"       % Provided,
  "jakarta.servlet"   %  "jakarta.servlet-api"        % "5.0.0"         % Provided
)

ThisBuild / evictionErrorLevel := Level.Warn

enablePlugins(SbtTwirl)
enablePlugins(JettyPlugin)

Jetty / containerLibs := Seq("org.eclipse.jetty" % "jetty-runner" % "11.0.15" intransitive())
