# ScentryAuthDemo #

## Build & Run ##

```sh
$ git clone https://github.com/scalatra/scalatra-website-examples.git
$ cd scalatra-website-examples/3.0/http/scentry-auth-demo
$ chmod +x sbt
$ ./sbt ~jetty:start
```

Open [http://localhost:8080/](http://localhost:8080/) in your browser.

Log in as:

- user: foo
- password: bar

To logout, hit http://localhost:8080/sessions/logout. It's not a pretty route, and it's an unsafe GET, but it's the
easiest way to illustrate logout functionality.
