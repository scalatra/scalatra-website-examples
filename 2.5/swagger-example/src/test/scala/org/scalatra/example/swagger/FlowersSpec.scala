package org.scalatra.example.swagger

import org.scalatra.test.specs2._

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html
class FlowersSpec extends ScalatraSpec { def is =
  "GET / on Flowers"                     ^
    "should return status 200"                  ! root200^
                                                p^
  "GET / on Flowers with a name param"          ^
    "should return status 200"                  ! nameParamWorks^
                                                p^
  "GET /:slug on Flowers"                       ^
    "should return status 200"                  ! slugWorks
                                                end

  implicit val swagger = new FlowersSwagger
  addServlet(new FlowersController, "/flowers/*")

  def root200 = get("/flowers") {
    status must_== 200
  }

  def nameParamWorks = get("/flowers/?name=rose") {
    status must_== 200
  }

  def slugWorks = get("/flowers/red-rose") {
    status must_== 200
  }
}
