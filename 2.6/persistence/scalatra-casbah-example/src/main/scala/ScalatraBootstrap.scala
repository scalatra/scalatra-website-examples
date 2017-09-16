import com.mongodb.casbah.Imports._
import org.scalatra.example._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {

  val mongoClient =  MongoClient()

  override def init(context: ServletContext) {

     // As you can see, there's not much to do in order to get MongoDb working with Scalatra.
     // We're connecting with default settings - localhost on port 27017 - by calling MongoClient() with no arguments.
    val mongoColl = mongoClient("casbah_test")("test_data")

    // pass a reference to the Mongo collection into your servlet when you mount it at application start:
    context.mount(new MongoController(mongoColl), "/*")

  }

  override def destroy(context: ServletContext) {
    mongoClient.close
  }
}
