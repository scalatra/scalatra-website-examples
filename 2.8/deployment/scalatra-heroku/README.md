# scalatra-heroku #

Corresponds to the guide at [http://scalatra.org/guides/2.7/deployment/heroku.html](http://scalatra.org/guides/2.7/deployment/heroku.html).

## Build & Run ##

```sh
$ git clone https://github.com/scalatra/scalatra-website-examples.git
$ cd scalatra-website-examples/2.7/deployment/scalatra-heroku
$ chmod +x sbt
$ ./sbt stage
$ target/universal/stage/bin/heroku-example
```

Open [http://localhost:8080](http://localhost:8080).
