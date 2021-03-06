organization := "com.example"
name := "Scalatra Atmosphere Example"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.13.4"

val ScalatraVersion = "2.7.+"

libraryDependencies ++= Seq(
  "org.json4s"                  %% "json4s-jackson"      % "3.6.7",
  "org.scalatra"                %% "scalatra"            % ScalatraVersion,
  "org.scalatra"                %% "scalatra-json"       % ScalatraVersion,
  "org.scalatra"                %% "scalatra-scalate"    % ScalatraVersion,
  "org.scalatra"                %% "scalatra-specs2"     % ScalatraVersion    % Test,
  "org.scalatra"                %% "scalatra-atmosphere" % ScalatraVersion,
  "ch.qos.logback"              %  "logback-classic"     % "1.2.3"            % Provided,
  "org.eclipse.jetty"           %  "jetty-webapp"        % "9.4.35.v20201120" % Provided,
  "javax.servlet"               %  "javax.servlet-api"   % "3.1.0"            % Provided
)

enablePlugins(JettyPlugin)
