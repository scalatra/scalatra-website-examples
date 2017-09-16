package org.scalatra.example

import org.scalatra._

class AuthDemo extends ScalatraServlet with AuthenticationSupport {


  get("/*") {
    basicAuth
    <html>
      <body>
        <h1>Hello from Scalatra</h1>
        <p>You are authenticated.</p>
      </body>
    </html>
  }

}
