package com.example.app

import akka.actor.{ActorRef, Actor, Props, ActorSystem}
import akka.util.Timeout
import org.scalatra.{FutureSupport, Accepted, ScalatraServlet}
import scala.concurrent.ExecutionContext

class MyActorApp(system:ActorSystem, myActor:ActorRef) extends ScalatraServlet with FutureSupport {

  import _root_.akka.pattern.ask
  implicit val timeout = Timeout(10)

  // You'll see the output from this in the browser.
  get("/async") {
    myActor ? "Do stuff and give me an answer"
  }

  // You'll see the output from this in your terminal.
  get("/fire-forget") {
    myActor ! "Hey, you know what?"
    Accepted()
  }

  protected implicit def executor: ExecutionContext = system.dispatcher
}

class MyActor extends Actor {
  def receive = {
    case "Do stuff and give me an answer" => sender ! "The answer is 42"
    case "Hey, you know what?" => println("Yeah I know... oh boy do I know")
  }

}
