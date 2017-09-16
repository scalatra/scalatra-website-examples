import org.scalatra.example._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle with RiakJavaClientInit {

  override def init(context: ServletContext) {
    configureRiakJavaClient()
    context.mount(new SimpleRiakController, "/*")
  }

  override def destroy(context: ServletContext) {
    closeRiakJavaClient()
  }
}
