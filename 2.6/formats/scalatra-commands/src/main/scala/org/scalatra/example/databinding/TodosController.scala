package org.scalatra.example.commands

import org.scalatra._
import scalate.ScalateSupport

// Json handling
import json._
import org.json4s.{DefaultFormats, Formats}

// Scalatra's command support
import org.scalatra.commands._

// Our models
import models._

// Our data
import data._

// Our commands
import commandsupport._

// Logger
import utils._

class TodosController extends ScalatraServlet with ScalateSupport 
  with JacksonJsonParsing with JacksonJsonSupport {

  protected implicit val jsonFormats: Formats = DefaultFormats

  get("/") {
    contentType="text/html"
    ssp("/todos/index", "todos" -> TodoData.all, "remaining" -> TodoData.remaining)
  }

  post("/todos") {
    TodoData.add(TodoData.newTodo(params("name")))
    redirect("/")
  }

  get("/todos/:id") {
    TodoData.all find (_.id == params("id").toInt) match {
      case Some(todo) => todo
      case None => halt(404)
    }
  }

  notFound {
    // remove content type in case it was set through an action
    contentType = null
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound()
  }
}
