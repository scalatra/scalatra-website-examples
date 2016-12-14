Scalatra Swagger Flowershop
===========================

Corresponds to the guide at [http://scalatra.org/2.3/guides/swagger.html](http://scalatra.org/2.3/guides/swagger.html)

A sample API, including automatically generated, runnable API documentation,
to demonstrate Scalatra's Swagger functionality.

## Build & Run ##

```sh
$ git clone https://github.com/scalatra/scalatra-website-examples.git
$ cd scalatra-website-examples/2.3/swagger-example
$ chmod +x sbt
$ ./sbt
> container:start
```

Open your browser to http://petstore.swagger.wordnik.com/, and you'll see the default Swagger demo application - a Pet Store - and you'll be able to browse its documentation. 

The Pet Store documentation is showing because http://petstore.swagger.wordnik.com/api/resources.json is entered into the URL field by default.

Paste http://localhost:8080/api-docs/resources.json - into the URL field, delete the "special-key" key, then press the "Explore" button. You'll see a Swaggerized view of the API documentation for this application. Try clicking on the "GET /flowers" route to expand the operations underneath it, and then entering the word "rose" into the input box for the "name" parameter.

(c) Dave Hrycyszyn, 2013
