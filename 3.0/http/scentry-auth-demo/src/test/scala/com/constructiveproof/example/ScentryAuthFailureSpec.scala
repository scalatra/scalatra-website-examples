package com.constructiveproof.example

import org.scalatra.test.specs2._

import java.net.URI

class ScentryAuthFailureSpec extends ScalatraSpec { def is = s2"""
Authenticate by invalid account should redirect login screen $redirectLoginScreen
"""

  addServlet(new ProtectedController, "/*")
  addServlet(new SessionsController, "/sessions/*")

  def redirectLoginScreen = session {

    val login = get("/sessions/new") {
      status must_== 200
    }

    var location: URI = null
    val redirection = post(
      uri = "/sessions",
      params = Seq(("login", "bar"), ("password", "baz"), ("rememberMe", "true"))
    ) {
      { status must_== 302 } and { header("Location") must endWith("/sessions/new") }
    }

    login and redirection
  }
}
