package org.scalatra.example

import org.scalatra.example.data.DatabaseInit
import org.scalatra.test.scalatest._
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite
import org.scalatra.example.models.BlogDb
import org.h2.engine.Session

class ArticlesControllerSpec extends AnyFunSuite with ScalatraSuite with DatabaseInit with BeforeAndAfter {
  addServlet(classOf[ArticlesController], "/*")
  
  before {
    configureDb
  }
  
  after {
    closeDbConnection
  }
  
  test("post article") {
    get("/create-db") {
      status should equal (302)
    }

    get("/") {
      status should equal (200)
    }

    post(
      uri = "/articles",
      params = Seq(
        ("title", "Scalatra news"),
        ("body",  "new Scalatra release!!")
      )
    ) {
      status should equal(302)
    }

    get("/") {
      body should include("Scalatra news")
    }
  }
}
