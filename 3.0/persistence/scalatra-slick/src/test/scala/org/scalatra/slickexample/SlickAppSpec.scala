package org.scalatra.slickexample

import org.scalatra.test.specs2._
import org.specs2.specification._
import com.mchange.v2.c3p0.ComboPooledDataSource
import slick.jdbc.H2Profile.api._

class SlickAppSpec extends ScalatraSpec with AfterAll { def is = sequential ^ s2"""
  GET /db/create-db on SlickApp should
    return status 200 $createDB
  GET /coffees on SlickApp should
    return status 200 & body contains coffees list $readDB
  GET /db/drop-db on SlickApp should
    return status 200 $dropDB
"""

  val cpds = new ComboPooledDataSource
  val database = Database.forDataSource(cpds, None)

  addServlet(new SlickApp(database), "/*")

  def createDB = get("/db/create-db") {
    status must_== 200
  }

  def readDB = get("/coffees") {
    { status must_== 200 } and {
      body must contain("Colombian") and contain("French_Roast_Decaf")
    }
  }

  def dropDB = get("/db/drop-db") {
    status must_== 200
  }

  override def afterAll(): Unit = cpds.close
}
