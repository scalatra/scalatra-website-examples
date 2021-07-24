organization := "com.example"
name := "Akka Examples"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.13.6"

val ScalatraVersion = "2.8.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka"       %% "akka-actor"        % "2.6.15",
  "com.typesafe.akka"       %% "akka-http"         % "10.2.2",
  "org.scalaj"              %% "scalaj-http"       % "2.4.2",
  "ch.qos.logback"          %  "logback-classic"   % "1.2.4"            % Provided,
  "org.scalatra"            %% "scalatra"          % ScalatraVersion,
  "org.scalatra"            %% "scalatra-specs2"   % ScalatraVersion    % "test",
  "org.eclipse.jetty"       %  "jetty-webapp"      % "9.4.43.v20210629" % "provided",
  "javax.servlet"           %  "javax.servlet-api" % "3.1.0"            % "provided"
)

enablePlugins(JettyPlugin)
