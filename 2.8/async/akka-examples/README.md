# akka-examples #

Corresponds to the guide at [http://scalatra.org/guides/2.8/async/akka.html](http://scalatra.org/guides/2.8/async/akka.html)

## Build & Run ##

```sh
$ git clone https://github.com/scalatra/scalatra-website-examples.git
$ cd scalatra-website-examples/2.8/async/akka-examples
$ chmod +x sbt
$ ./sbt ~jetty:start
```

First, open [http://localhost:8080/ask](http://localhost:8080/) in your browser. You'll see the "question and answer" in the browser.

Second, Open [http://localhost:8080/](http://localhost:8080/) in your browser. You'll see the "question and answer" in your terminal.
