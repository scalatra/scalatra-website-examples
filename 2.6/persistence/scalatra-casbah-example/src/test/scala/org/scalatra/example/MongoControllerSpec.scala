package org.scalatra.example

import org.scalatra.test.specs2._
import com.mongodb.casbah.Imports._

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html
class MongoControllerSpec extends ScalatraSpec { def is =
  "GET / on MongoController"                     ^
    "should return status 200"                  ! root200^
                                                end

  val mongoClient =  MongoClient()
  val mongoColl = mongoClient("casbah_test")("test_data")
  addServlet(new MongoController(mongoColl), "/*")

  def root200 = get("/") {
    status must_== 200
  }
}
