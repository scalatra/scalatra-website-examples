package org.scalatra.example

import org.scalatra.test.specs2._

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html
class MyScalatraServletSpec extends ScalatraSpec { def is = s2"""
  GET / on HttpExample
    should return status 200 $root200
"""

  addServlet(classOf[HttpExample], "/*")

  def root200 = get("/") {
    status must_== 200
  }
}
