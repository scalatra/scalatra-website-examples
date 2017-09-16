organization := "com.example"
name := "Riak Example"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.12.3"

val ScalatraVersion = "2.6.+"

libraryDependencies ++= Seq(
  "com.basho.riak"          %  "riak-client"        % "1.1.4",
  "org.scalatra"            %% "scalatra"           % ScalatraVersion,
  "org.scalatra"            %% "scalatra-scalate"   % ScalatraVersion,
  "org.scalatra"            %% "scalatra-scalatest" % ScalatraVersion    % "test",
  "org.eclipse.jetty"       %  "jetty-webapp"       % "9.2.19.v20160908" % "provided",
  "javax.servlet"           %  "javax.servlet-api"  % "3.1.0"            % "provided"
)

enablePlugins(JettyPlugin)