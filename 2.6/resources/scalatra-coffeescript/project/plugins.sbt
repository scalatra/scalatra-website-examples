addSbtPlugin("org.scalatra.sbt" % "scalatra-sbt" % "0.5.1")
addSbtPlugin("com.bowlingx" %% "xsbt-wro4j-plugin" % "0.3.5")

resolvers += Resolver.url("sbt-plugin-snapshots", new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-snapshots/"))(Resolver.ivyStylePatterns)
