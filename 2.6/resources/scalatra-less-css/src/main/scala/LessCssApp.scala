package org.scalatra.example

import org.scalatra._

class LessCssApp extends ScalatraServlet {

  get("/") {
    <html>
      <head>
        <link rel="stylesheet" type="text/css" href="compiled/styles.css" />
      </head>
      <body>
        <h1>This is
          <a href="http://scalatra.org/guides/2.5/resources/less-css.html">resources/less-css</a>!
        </h1>
      </body>
    </html>
  }
}
