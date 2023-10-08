package org.scalatra.example.swagger

import org.scalatra.test.specs2._
import org.scalatra.swagger.Swagger

class FlowersSpec extends ScalatraSpec { def is = s2"""
  GET / on Flowers 
    should return status 200 $root200
  GET / on Flowers with a name param
    should return status 200 $nameParamWorks
  GET /:slug on Flowers
    should return status 200 $slugWorks
"""

  implicit val swagger: Swagger = new FlowersSwagger
  addServlet(new FlowersController, "/flowers/*")

  def root200 = get("/flowers") {
    status must_== 200
  }

  def nameParamWorks = get("/flowers/?name=rose") {
    status must_== 200
  }

  def slugWorks = get("/flowers/red-rose") {
    status must_== 200
  }
}
