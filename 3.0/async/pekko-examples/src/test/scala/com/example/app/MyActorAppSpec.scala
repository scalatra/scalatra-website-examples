package com.example.app

import org.scalatra.test.specs2._
import org.apache.pekko.actor.{Props, ActorSystem}

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html
class MyActorAppSpec extends ScalatraSpec { def is = s2"""
  GET /ask on MyActorApp
    should return status 200 $ask200
  GET /tell on MyActorApp
    should return status 202 $tell202
"""

  val system = ActorSystem()
  val myActor = system.actorOf(Props[MyActor])

  addServlet(new MyActorApp(system, myActor), "/*")

  def ask200 = get("/ask") {
    status must_== 200
  }

  def tell202 = get("/tell") {
    status must_== 202
  }
}
