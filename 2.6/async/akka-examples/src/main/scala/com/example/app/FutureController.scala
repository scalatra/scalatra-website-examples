package com.example.app

import akka.actor.ActorSystem
import dispatch._
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
    val prom = Promise[String]()
    dispatch.Http(url("http://scalatra.org/") OK as.String) onComplete {
      case Success(content) => prom.complete(Try(content))
      case Failure(exception) => println(exception)
    }
    prom.future
  }
}
