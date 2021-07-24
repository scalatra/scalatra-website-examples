package com.example.app

import akka.actor.{Actor, ActorRef, ActorSystem}
import akka.pattern.ask
import akka.util.Timeout
import org.scalatra.{Accepted, FutureSupport, ScalatraServlet}

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

class MyActorApp(system:ActorSystem, myActor:ActorRef) extends ScalatraServlet with FutureSupport {

  import scala.language.postfixOps

  implicit val timeout = new Timeout(2 seconds)
  protected implicit def executor: ExecutionContext = system.dispatcher

  // You'll see the output from this in the browser.
  get("/ask") {
    myActor ? "Do stuff and give me an answer"
  }

  // You'll see the output from this in your terminal.
  get("/tell") {
    myActor ! "Hey, you know what?"
    Accepted()
  }

}

class MyActor extends Actor {
  def receive = {
    case "Do stuff and give me an answer" => sender ! "The answer is 42"
    case "Hey, you know what?" => println("Yeah I know... oh boy do I know")
  }

}
