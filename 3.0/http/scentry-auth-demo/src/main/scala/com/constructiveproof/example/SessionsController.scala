package com.constructiveproof.example

import org.scalatra._
import com.constructiveproof.example.auth.AuthenticationSupport

class SessionsController extends ScalatraServlet with AuthenticationSupport {

  before("/new") {
    logger.info("SessionsController: checking whether to run RememberMeStrategy: " + !isAuthenticated)

    if(!isAuthenticated) {
      scentry.authenticate("RememberMe")
    }
  }

  get("/new") {
    if (isAuthenticated) redirect("/")

    contentType="text/html"
    <html>
      <p>Please login:</p>
      <form action="/sessions" method="post">
        <p>
          <input type="text" name="login" /><br/>
          <input type="password" name="password" /><br/>
          <label>Remember Me:</label><input type="checkbox" name="rememberMe" value="true" />
        </p>
        <p>
          <input type="submit" />
        </p>
      </form>
    </html>
  }

  post("/") {
    scentry.authenticate()

    if (isAuthenticated) {
      redirect("/")
    } else {
      redirect("/sessions/new")
    }
  }

  // Never do this in a real app. State changes should never happen as a result of a GET request. However, this does
  // make it easier to illustrate the logout code.
  get("/logout") {
    scentry.logout()
    redirect("/")
  }

}
