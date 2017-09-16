package org.scalatra.example

import org.scalatra.test.specs2._

// For more on Specs2, see https://etorreborre.github.io/specs2/website/SPECS2-3.6.2/quickstart.html
class AuthDemoSpec extends ScalatraSpec {
  def is =
    "GET / on AuthDemo" ^
      "should return status 401" ! root401 ^
      end

  addServlet(classOf[AuthDemo], "/*")

  def root401 = get("/") {
    status must_== 401
  }
}
