package org.scalatra.example

import org.scalatra._

class AuthDemo extends ScalatraServlet with AuthenticationSupport {

  get("/*") {
    val user: User = basicAuth().get

    <html>
      <body>
        <h1>Hello '{user.id}' from Scalatra Basic Authentication Demo</h1>
        <p>You are authenticated.</p>
      </body>
    </html>
  }

}
