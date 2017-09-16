import Wro4jKeys._

organization := "com.example"
name := "Scalatra Less Css"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.12.3"

val ScalatraVersion = "2.6.+"

libraryDependencies ++= Seq(
  "org.scalatra"            %% "scalatra"          % ScalatraVersion,
  "org.scalatra"            %% "scalatra-scalate"  % ScalatraVersion,
  "org.scalatra"            %% "scalatra-specs2"   % ScalatraVersion    % "test",
  "org.eclipse.jetty"       %  "jetty-webapp"      % "9.2.19.v20160908" % "provided",
  "javax.servlet"           %  "javax.servlet-api" % "3.1.0"            % "provided"
)

enablePlugins(JettyPlugin)

// import task settings
Seq(wro4jSettings: _*)

resourceGenerators in Compile += (generateResources in Compile).map(_.toSeq).taskValue

// If you use xsbt-web-plugin, this will add compiled files to your war file:
webappPostProcess := {
  webappDir: File =>
    val targetDir = (targetFolder in generateResources in Compile).value
    IO.copyDirectory(targetDir, webappDir)
}
