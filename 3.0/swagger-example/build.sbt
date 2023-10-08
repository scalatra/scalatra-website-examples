organization := "com.example"
name := "Flowershop"
version := "0.1.0-SNAPSHOT"
scalaVersion := "3.3.1"

val ScalatraVersion = "3.0.0"

libraryDependencies ++= Seq(
  "org.json4s"              %% "json4s-native"            % "4.0.6",
  "org.scalatra"            %% "scalatra-swagger-jakarta" % ScalatraVersion,
  "org.scalatra"            %% "scalatra-jakarta"         % ScalatraVersion,
  "org.scalatra"            %% "scalatra-specs2-jakarta"  % ScalatraVersion    % Test,
  "ch.qos.logback"          %  "logback-classic"          % "1.4.11"           % Provided,
  "org.eclipse.jetty"       %  "jetty-webapp"             % "11.0.15"          % Provided,
  "jakarta.servlet"         %  "jakarta.servlet-api"      % "5.0.0"            % Provided
)

ThisBuild / evictionErrorLevel := Level.Warn

enablePlugins(JettyPlugin)

Jetty / containerLibs := Seq("org.eclipse.jetty" % "jetty-runner" % "11.0.15" intransitive())
