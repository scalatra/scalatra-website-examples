import org.scalatra.example.swagger._
import org.scalatra.LifeCycle
import jakarta.servlet.ServletContext
import org.scalatra.swagger.Swagger

class ScalatraBootstrap extends LifeCycle {

  implicit val swagger: Swagger = new FlowersSwagger

  override def init(context: ServletContext) = {
    // This is tentative. We will rewrite it once the official version of Scalatra 2.7 is released.
    context.setInitParameter("org.scalatra.cors.allowedOrigins", "http://petstore.swagger.io")
    context.mount(new FlowersController, "/flowers", "flowers")
    context.mount(new ResourcesApp, "/api-docs")
  }
}
