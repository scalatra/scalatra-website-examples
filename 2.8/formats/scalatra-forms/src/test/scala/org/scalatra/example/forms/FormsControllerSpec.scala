package org.scalatra.example.forms

import org.scalatra.test.specs2._

class FormsControllerSpec extends ScalatraSpec { def is = s2"""
  GET / on FormsController
    should return status 200 $root
  POST / on FormsController
    with valid params should return status 200 $validParams
    with invalid params should return status 400 & body contains error message $invalidParams
"""

  addServlet(classOf[FormsController], "/*")

  def root = get("/") {
    status must_== 200
  }

  def validParams = post(
    uri = "/",
    params = Seq(
      ("text", "scalatra forms"), 
      ("email", "mail@scalatra.org"),
      ("number", ""),
      ("checkbox", "true")
    )
  ) {
    status must_== 200
  }

  def invalidParams = post(
    uri = "/",
    params = Seq(
      // An error occurs because it exceeds the limit of 100 characters
      ("text", "scalatra forms" * 10),
      ("email", "mail@scalatra.org"),
      ("number", ""),
      ("checkbox", "true")
    )
  ) {
    {
      status must_== 400
    } and {
      body must contain("Text cannot be longer than 100 characters.")
    }
  }
}
