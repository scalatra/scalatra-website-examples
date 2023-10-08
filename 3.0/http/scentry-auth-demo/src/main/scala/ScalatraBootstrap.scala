import com.constructiveproof.example._
import org.scalatra._
import jakarta.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) = {
    context.mount(new ProtectedController, "/*")
    context.mount(new SessionsController, "/sessions/*")
  }
}
