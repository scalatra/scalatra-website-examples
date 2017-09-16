package org.scalatra.example

import org.scalatra._
import com.mongodb.casbah.Imports._
import org.scalatra.json.JacksonJsonSupport
import org.json4s._
import org.json4s.mongo.{JObjectParser, ObjectIdSerializer}

/**
 * This is a simple approach for converting MongoDB results to JSON strings.
 */
trait SimpleMongoDbJsonConversion extends ScalatraBase with ApiFormats {

  // renders DBObject and MongoCursor as String making use of standard toString() methods
  def renderMongo = {
    case dbo: DBObject =>
      contentType = formats("json")
      dbo.toString

    case xs: TraversableOnce[_] => // handles a MongoCursor
      contentType = formats("json")
      val l = xs map (x => x.toString) mkString(",")
      "[" + l + "]"

  }: RenderPipeline

  // hook into render pipeline
  override protected def renderPipeline = renderMongo orElse super.renderPipeline

}

/**
 * This is alternative approach using json4s and scalatra-json.
 */
trait Json4sMongoDbJsonConversion extends JacksonJsonSupport {

  // required by scalatra-json
  implicit val jsonFormats = DefaultFormats + new ObjectIdSerializer

  // converts DBObject and MongoCursor to json4s JValue
  // JValue is handled by scalatra-json and converted to string there
  // scalatra-json also takes care of setting the content type
  def transformMongoObjectsToJson4s = {
    case dbo: DBObject => JObjectParser.serialize(dbo)


    case xs: TraversableOnce[_] =>
      // handle MongoCursor
      JArray(xs.toList.map { x => JObjectParser.serialize(x) })
  }: RenderPipeline

  // hook into render pipeline
  override protected def renderPipeline = transformMongoObjectsToJson4s orElse super.renderPipeline

}