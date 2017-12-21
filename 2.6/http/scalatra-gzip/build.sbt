organization := "org.scalatra.example"
name := "Scalatra Gzip"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.12.4"

val ScalatraVersion = "2.6.+"

libraryDependencies ++= Seq(
  "org.scalatra"            %% "scalatra"          % ScalatraVersion,
  "org.scalatra"            %% "scalatra-scalate"  % ScalatraVersion,
  "org.scalatra"            %% "scalatra-specs2"   % ScalatraVersion    % Test,
  "ch.qos.logback"          % "logback-classic"    % "1.2.3"            % Provided,
  "org.eclipse.jetty"       %  "jetty-webapp"      % "9.4.7.v20170914"  % Provided,
  "javax.servlet"           %  "javax.servlet-api" % "3.1.0"            % Provided
)

enablePlugins(ScalatraPlugin)
