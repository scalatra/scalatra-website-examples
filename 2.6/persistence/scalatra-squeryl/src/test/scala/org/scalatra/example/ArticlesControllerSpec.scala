package org.scalatra.example

import org.scalatra.example.data.DatabaseInit
import org.scalatra.test.scalatest._
import org.scalatest.{ FunSuite, BeforeAndAfter }
import org.scalatra.example.models.BlogDb
import org.h2.engine.Session

class ArticlesControllerSpec extends FunSuite with ScalatraSuite with DatabaseInit with BeforeAndAfter {
  addServlet(classOf[ArticlesController], "/*")
  
  before {
    configureDb()
  }
  
  after {
    closeDbConnection()
  }
  
  test("simple get") {
    get("/create-db") {
      status should equal (302)
    }

    get("/") {
      status should equal (200)
    }
  }
}

