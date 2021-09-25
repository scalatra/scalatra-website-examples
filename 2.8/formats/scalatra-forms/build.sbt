organization := "org.scalatra.example"
name := "Scalatra Forms Example"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.13.6"

val ScalatraVersion = "2.8.2"

libraryDependencies ++= Seq(
  "org.json4s"              %% "json4s-jackson"    % "3.6.7",
  "org.scalatra"            %% "scalatra-forms"    % ScalatraVersion,
  "org.scalatra"            %% "scalatra"          % ScalatraVersion,
  "org.scalatra"            %% "scalatra-specs2"   % ScalatraVersion    % Test,
  "ch.qos.logback"          %  "logback-classic"   % "1.2.3"            % Provided,
  "org.eclipse.jetty"       %  "jetty-webapp"      % "9.4.35.v20201120" % Provided,
  "javax.servlet"           %  "javax.servlet-api" % "3.1.0"            % Provided
)

enablePlugins(SbtTwirl)
enablePlugins(JettyPlugin)
