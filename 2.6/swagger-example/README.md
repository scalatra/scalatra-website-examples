Scalatra Swagger Flowershop
===========================

Corresponds to the guide at [http://scalatra.org/guides/2.5/swagger.html](http://scalatra.org/guides/2.5/swagger.html)

A sample API, including automatically generated, runnable API documentation,
to demonstrate Scalatra's Swagger functionality.

## Build & Run ##

```sh
$ git clone https://github.com/scalatra/scalatra-website-examples.git
$ cd scalatra-website-examples/2.5/swagger-example
$ chmod +x sbt
$ ./sbt ~jetty:start
```

You can see the pet store APIs specification at [http://localhost:8080/api-docs/swagger.json](http://localhost:8080/api-docs/swagger.json).
