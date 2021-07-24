package com.constructiveproof.example

import org.scalatra._
import scalate.ScalateSupport
import com.constructiveproof.example.auth.AuthenticationSupport

class ProtectedController extends ScentryauthdemoStack with AuthenticationSupport {

  /**
   * Require that users be logged in before they can hit any of the routes in this controller.
   */
  before() {
    requireLogin()
  }

  get("/") {
    "This is a protected controller action. If you can see it, you're logged in."
  }
}


