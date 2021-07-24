Scalatra Swagger Flowershop
===========================

Corresponds to the guide at [http://scalatra.org/guides/2.8/swagger.html](http://scalatra.org/guides/2.8/swagger.html)

A sample API, including automatically generated, runnable API documentation,
to demonstrate Scalatra's Swagger functionality.

## Build & Run ##

```sh
$ git clone https://github.com/scalatra/scalatra-website-examples.git
$ cd scalatra-website-examples/2.8/swagger-example
$ chmod +x sbt
$ ./sbt ~jetty:start
```

You can see the pet store APIs specification at [http://localhost:8080/api-docs/swagger.json](http://localhost:8080/api-docs/swagger.json).
You can see Swagger-UI at [https://editor.swagger.io/](https://editor.swagger.io/) or [https://swagger.io/swagger-ui/](https://swagger.io/swagger-ui/).
