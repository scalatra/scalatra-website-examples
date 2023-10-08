package com.example.app

import org.apache.pekko.actor.ActorSystem
import scalaj.http.{Http => SJHttp}

import org.scalatra._

import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.util.{Failure, Success, Try}

class FutureController(system: ActorSystem) extends ScalatraServlet with FutureSupport {

  protected implicit def executor: ExecutionContext = system.dispatcher

  get("/") {
    new AsyncResult { val is =
      HttpClient.retrievePage()
    }
  }

}

object HttpClient {
  def retrievePage()(implicit ctx: ExecutionContext): Future[String] = {
    Future {
      val response = SJHttp("https://scalatra.org/").asString
      response.body
    }
  }
}
