package org.scalatra.example

import org.mongodb.scala.{Document, Observable}
import org.scalatra.ScalatraServlet

import scala.concurrent.Await
import scala.concurrent.duration._

/**
 * MongoDB helpers, taken from:
 * https://github.com/mongodb/mongo-scala-driver/blob/master/examples/src/test/scala/tour/Helpers.scala
 */
class ScalatraMongoExample extends ScalatraServlet {

  implicit class DocumentObservable[C](val observable: Observable[Document]) extends ImplicitObservable[Document] {
    override val converter: (Document) => String = (doc) => doc.toJson
  }

  implicit class GenericObservable[C](val observable: Observable[C]) extends ImplicitObservable[C] {
    override val converter: (C) => String = (doc) => doc.toString
  }

  trait ImplicitObservable[C] {
    val observable: Observable[C]
    val converter: (C) => String

    def results(): Seq[C] = Await.result(observable.toFuture(), 10.seconds)
    def headResult(): C = Await.result(observable.head(), 10.seconds)
    def printResults(initial: String = ""): Unit = {
      if (initial.length > 0) print(initial)
      results().foreach(res => println(converter(res)))
    }
    def printHeadResult(initial: String = ""): Unit = println(s"${initial}${converter(headResult())}")
  }
}
