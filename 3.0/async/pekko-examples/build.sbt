organization := "com.example"
name := "Pekko Examples"
version := "0.1.0-SNAPSHOT"
scalaVersion := "3.3.1"

val ScalatraVersion = "3.0.0"

libraryDependencies ++= Seq(
  "org.apache.pekko"  %% "pekko-actor"             % "1.0.0" cross(CrossVersion.for3Use2_13),
  "org.apache.pekko"  %% "pekko-http"              % "1.0.0" cross(CrossVersion.for3Use2_13),
  "org.scalaj"        %% "scalaj-http"             % "2.4.2" cross(CrossVersion.for3Use2_13),
  "ch.qos.logback"    %  "logback-classic"         % "1.4.11"        % Provided,
  "org.scalatra"      %% "scalatra-jakarta"        % ScalatraVersion,
  "org.scalatra"      %% "scalatra-specs2-jakarta" % ScalatraVersion % "test",
  "org.eclipse.jetty" %  "jetty-webapp"            % "11.0.15"       % "provided",
  "jakarta.servlet"   %  "jakarta.servlet-api"     % "5.0.0"         % "provided"
)

enablePlugins(JettyPlugin)

Jetty / containerLibs := Seq("org.eclipse.jetty" % "jetty-runner" % "11.0.15" intransitive())
