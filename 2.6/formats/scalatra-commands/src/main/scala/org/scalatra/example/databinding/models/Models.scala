package org.scalatra.example.commands.models

/** A Todo object to use as a data model */
case class Todo(id: Int, name: String, done: Boolean = false)