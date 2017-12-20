organization := "org.scalatra.slickexample"
name := "Scalatra Slick"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.12.4"

val ScalatraVersion = "2.6.+"

libraryDependencies ++= Seq(
  "org.scalatra"            %% "scalatra"          % ScalatraVersion,
  "org.scalatra"            %% "scalatra-scalate"  % ScalatraVersion,
  "org.scalatra"            %% "scalatra-specs2"   % ScalatraVersion    % "test",
  "com.typesafe.slick"      %% "slick"             % "3.2.1",
  "com.h2database"          %  "h2"                % "1.4.196",
  "com.mchange"             %  "c3p0"              % "0.9.5.2",
  "ch.qos.logback"          %  "logback-classic"   % "1.2.3"            % "provided",
  "org.eclipse.jetty"       %  "jetty-webapp"      % "9.4.7.v20170914"  % "provided",
  "javax.servlet"           %  "javax.servlet-api" % "3.1.0"            % "provided"
)

enablePlugins(ScalatraPlugin)
