organization := "com.example"
name := "Scalatra HTTP Demo"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.13.1"

val ScalatraVersion = "2.7.+"

libraryDependencies ++= Seq(
  "org.scalatra"            %% "scalatra"          % ScalatraVersion,
  "org.scalatra"            %% "scalatra-scalate"  % ScalatraVersion,
  "org.scalatra"            %% "scalatra-specs2"   % ScalatraVersion    % Test,
  "org.eclipse.jetty"       %  "jetty-webapp"      % "9.4.19.v20190610" % Provided,
  "javax.servlet"           %  "javax.servlet-api" % "3.1.0"            % Provided
)

enablePlugins(JettyPlugin)
