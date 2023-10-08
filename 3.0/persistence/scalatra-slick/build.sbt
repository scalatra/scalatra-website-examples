organization := "org.scalatra.slickexample"
name := "Scalatra Slick"
version := "0.1.0-SNAPSHOT"
scalaVersion := "3.3.1"

val ScalatraVersion = "3.0.0"

libraryDependencies ++= Seq(
  "org.scalatra"            %% "scalatra-jakarta"        % ScalatraVersion,
  "org.scalatra"            %% "scalatra-specs2-jakarta" % ScalatraVersion % "test",
  "com.typesafe.slick"      %% "slick"                   % "3.5.0-M4",
  "com.h2database"          %  "h2"                      % "1.4.200",
  "com.mchange"             %  "c3p0"                    % "0.9.5.5",
  "ch.qos.logback"          %  "logback-classic"         % "1.4.11"        % "provided",
  "org.eclipse.jetty"       %  "jetty-webapp"            % "11.0.15"       % "provided",
  "jakarta.servlet"         %  "jakarta.servlet-api"     % "5.0.0"         % "provided"
)

enablePlugins(JettyPlugin)

Jetty / containerLibs := Seq("org.eclipse.jetty" % "jetty-runner" % "11.0.15" intransitive())
