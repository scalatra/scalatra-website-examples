organization := "com.example"
name := "Heroku Example"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.13.1"

val ScalatraVersion = "2.7.+"

libraryDependencies ++= Seq(
  "org.scalatra"                %% "scalatra"            % ScalatraVersion,
  "org.scalatra"                %% "scalatra-scalate"    % ScalatraVersion,
  "org.scalatra"                %% "scalatra-scalatest"  % ScalatraVersion    % Test,
  "org.eclipse.jetty"           %  "jetty-webapp"        % "9.4.19.v20190610" % Compile,
  "javax.servlet"               %  "javax.servlet-api"   % "3.1.0"            % Compile
)

enablePlugins(JettyPlugin, JavaAppPackaging)
