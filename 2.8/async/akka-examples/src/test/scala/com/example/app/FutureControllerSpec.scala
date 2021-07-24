package com.example.app

import org.scalatra.test.specs2._
import akka.actor.{ActorSystem}

class FutureControllerSpec extends ScalatraSpec { def is =
  "GET / on FutureController"                   ^
    "should return status 200"                  ! root200^
    end

  val system = ActorSystem()

  addServlet(new FutureController(system), "/*")

  def root200 = get("/") {
    status must_== 200
  }

}
