package org.scalatra.example

import org.mongodb.scala._


class MongoController(collection: MongoCollection[Document]) extends ScalatraMongoExample {

  /**
   * Insert a new object into the database. You can use the following from your console to try it out:
   * curl -i -H "Accept: application/json" -X POST -d "key=super&value=duper" http://localhost:8080/insert
   */
  post("/insert") {
    val key = params("key")
    val value = params("value")
    val newObj = Document(key -> value)
    collection.insertOne(newObj).results()
  }

  /**
   * Retrieve everything in the MongoDb collection we're currently using.
   */
  get("/") {
    collection.find().results().map(doc => doc.toJson())
  }

  /**
   * Query for the first object which matches the values given. If you copy/pasted the insert example above,
   * try http://localhost:8080/query/super/duper in your browser.
   */
  get("/query/:key/:value") {
    val q = Document(params("key") -> params("value"))
    collection.find(q).first().headResult().toJson()
  }

}
