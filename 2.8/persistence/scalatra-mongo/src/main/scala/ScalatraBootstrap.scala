import org.scalatra._
import javax.servlet.ServletContext
import org.mongodb.scala.MongoClient
import org.scalatra.example.MongoController

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {

    // As you can see, there's not much to do in order to get MongoDb working with Scalatra.
    // We're connecting with default settings - localhost on port 27017 -
    // by calling MongoClient() with no arguments.
    val mongoClient = MongoClient()
    val mongoColl = mongoClient.getDatabase("mydb").getCollection("test_data")

    // pass a reference to the Mongo collection into your servlet when you mount it at application start:
    context.mount(new MongoController(mongoColl), "/*")

  }
}