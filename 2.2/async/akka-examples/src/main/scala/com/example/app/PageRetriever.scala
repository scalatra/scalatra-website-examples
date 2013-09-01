package com.example.app

import akka.actor.ActorSystem
import scala.concurrent.{Future, Promise, ExecutionContext}
import dispatch._
import org.scalatra._
import scala.util.{Left, Try}

object DispatchAkka {

  def retrievePage()(implicit ctx: ExecutionContext): Future[String] = {
    val prom = Promise[String]()
    dispatch.Http(url("http://slashdot.org/") OK as.String) onComplete {
      case r => r match {
        case Left(exception) => println(exception)
        case Right(content) => prom.complete(Try{content})
      }
    }
    prom.future
  }
}

class PageRetriever(system: ActorSystem) extends ScalatraServlet with FutureSupport {

  protected implicit def executor: ExecutionContext = system.dispatcher

  get("/") {
    new AsyncResult { val is =
      DispatchAkka.retrievePage()
    }
  }

}

