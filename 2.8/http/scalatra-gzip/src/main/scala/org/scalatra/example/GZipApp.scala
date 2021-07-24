package org.scalatra.example

import org.scalatra._

class GZipApp extends ScalatraServlet with ContentEncodingSupport {
 get("/") {
  <html>
      <body>
        <h1>This is
          <a href="http://scalatra.org/guides/2.8/http/gzip.html">
            http/gzip
          </a>!
        </h1>
      </body>
    </html>
  }
}
