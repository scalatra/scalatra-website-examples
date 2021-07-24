package org.scalatra.example

import org.scalatra.test.specs2._
import org.apache.http.impl.client.{ CloseableHttpClient, HttpClientBuilder }

class GZipSpec extends ScalatraSpec { def is = s2"""
GET / on GZipApp
  should return status 200 and header "Content-Encoding: gzip" $gzip
"""

  addServlet(classOf[GZipApp], "/*")

  def gzip = get("/", Seq.empty, Map("Accept-Encoding" -> "gzip")) {
    { status must_== 200 } and { header("Content-Encoding") must_== "gzip" }
  }

  override protected def createClient: CloseableHttpClient = {
    val builder = HttpClientBuilder.create()
    builder.disableContentCompression()
    builder.build()
  }

}
