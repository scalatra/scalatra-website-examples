# Scalatra Mongo #

Corresponds to a specific Scalatra version Mongo guide at [http://scalatra.org/guides]

## Build & Run ##

```sh
$ git clone https://github.com/scalatra/scalatra-website-examples.git
$ cd scalatra-website-examples/2.8/persistence/scalatra-mongo
$ chmod +x sbt; sbt
> ~;jetty:stop;jetty:start
> browse
```

If `browse` doesn't launch your browser, manually open [http://localhost:8080/](http://localhost:8080/) in your browser.
Take a look at MongoController for endpoints and their usage.