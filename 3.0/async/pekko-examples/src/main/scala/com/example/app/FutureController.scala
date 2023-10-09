package com.example.app

import org.apache.pekko.actor.ActorSystem
import sttp.client3._

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
      val backend = HttpClientSyncBackend()
      val request = basicRequest.get(uri"https://scalatra.org/").response(asStringAlways)
      val response = request.send(backend)
      response.body
    }
  }
}
