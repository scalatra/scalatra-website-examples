# Scalatra Atmosphere Example #

Corresponds to the guide at [http://scalatra.org/guides/2.5/async/atmosphere.html](http://scalatra.org/guides/2.5/async/atmosphere.html)

## Build & Run ##

```sh
$ git clone https://github.com/scalatra/scalatra-website-examples.git
$ cd scalatra-website-examples/2.5/async/scalatra-atmosphere-embedded
$ chmod +x sbt
$ ./sbt run
```

Open [http://localhost:8080/](http://localhost:8080/) in your browser.

You can build an embedded Atmosphere-enabled app which runs under Jetty, by
calling the `stage` task once you're in SBT. This will package a start script
for you - it can be run by calling `target/start` from the top-level project
directory.

