import com.typesafe.sbt.SbtStartScript

organization := "com.example"
name := "Scalatra Atmosphere Embedded"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.12.3"

val ScalatraVersion = "2.6.+"
val jettyVersion = "9.2.19.v20160908"

libraryDependencies ++= Seq(
  "org.json4s"                  %% "json4s-jackson"      % "3.5.0",
  "org.scalatra"                %% "scalatra"            % ScalatraVersion,
  "org.scalatra"                %% "scalatra-scalate"    % ScalatraVersion,
  "org.scalatra"                %% "scalatra-specs2"     % ScalatraVersion   % "test",
  "org.scalatra"                %% "scalatra-atmosphere" % ScalatraVersion,
  "org.eclipse.jetty"           %  "jetty-webapp"        % jettyVersion      % "compile",
  "org.eclipse.jetty.websocket" %  "websocket-server"    % jettyVersion      % "compile;provided",
  "javax.servlet"               %  "javax.servlet-api"   % "3.1.0"
)

enablePlugins(JettyPlugin)

Seq(SbtStartScript.startScriptForClassesSettings: _*)