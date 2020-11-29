import com.typesafe.sbt.SbtNativePackager.autoImport.NativePackagerHelper._

organization := "com.example"
name := "Scalatra Atmosphere Embedded"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.13.1"

val ScalatraVersion = "2.7.+"
val jettyVersion = "9.4.19.v20190610"

libraryDependencies ++= Seq(
  "org.json4s"                  %% "json4s-jackson"      % "3.6.7",
  "org.scalatra"                %% "scalatra"            % ScalatraVersion,
  "org.scalatra"                %% "scalatra-json"       % ScalatraVersion,
  "org.scalatra"                %% "scalatra-scalate"    % ScalatraVersion,
  "org.scalatra"                %% "scalatra-specs2"     % ScalatraVersion   % Test,
  "org.scalatra"                %% "scalatra-atmosphere" % ScalatraVersion,
  "org.eclipse.jetty"           %  "jetty-webapp"        % jettyVersion      % Compile,
  "org.eclipse.jetty.websocket" %  "websocket-server"    % jettyVersion      % "compile;provided",
  "javax.servlet"               %  "javax.servlet-api"   % "3.1.0"
)

enablePlugins(JettyPlugin, JavaServerAppPackaging)
