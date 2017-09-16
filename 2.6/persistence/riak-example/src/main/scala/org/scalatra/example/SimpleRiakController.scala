package org.scalatra.example

import org.scalatra._

/**
 * This controller uses the Basho-supported riak-java-client, and the binary connection
 * defined in ScalatraBootstrap. It's very Java-esque (e.g. myData.getValue), but
 * the Java client is the supported one so you may want to either write a wrapper for it
 * or overlook that.
 * */
class SimpleRiakController extends RiakExampleStack with RiakSupport {

  /**
   * Insert a new object into the database. You can use the following from your console to try it out:
   * curl -i -X POST -d "key=super&value=duper" http://localhost:8080/insert
   */
  post("/insert") {
    val key = params("key")
    val value = params("value")
    myBucket.store(key, value).returnBody(true).execute
  }

  // Retrieve a previously stored object from Riak
  get("/by-key/:key") {
    val key = params("key")
    val myData = myBucket.fetch(key).execute
    myData.getValue
  }
  
}