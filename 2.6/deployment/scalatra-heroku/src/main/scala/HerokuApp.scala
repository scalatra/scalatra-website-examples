package org.scalatra.example

import org.scalatra._

class HerokuApp extends ScalatraServlet {

  get("/") {
    <html>
      <body>
        <h1>This is
          <a href="http://scalatra.org/guides/2.5/deployment/heroku.html">
            scalatra-heroku
          </a>!
        </h1>
      </body>
    </html>
  }
}
