organization := "com.example"
name := "Pekko Examples"
version := "0.1.0-SNAPSHOT"
scalaVersion := "3.3.7"

val ScalatraVersion = "3.0.0"

libraryDependencies ++= Seq(
  "org.apache.pekko"              %% "pekko-actor"             % "1.0.0",
  "org.apache.pekko"              %% "pekko-http"              % "1.0.0",
  "com.softwaremill.sttp.client3" %% "core"                    % "3.9.0",
  "org.scalatra"                  %% "scalatra-jakarta"        % ScalatraVersion,
  "org.scalatra"                  %% "scalatra-specs2-jakarta" % ScalatraVersion % Test,
  "ch.qos.logback"                %  "logback-classic"         % "1.4.11"        % Provided,
  "org.eclipse.jetty"             %  "jetty-webapp"            % "11.0.18"       % Provided,
  "jakarta.servlet"               %  "jakarta.servlet-api"     % "5.0.0"         % Provided
)

enablePlugins(JettyPlugin)

Jetty / containerLibs := Seq("org.eclipse.jetty" % "jetty-runner" % "11.0.18" intransitive())
