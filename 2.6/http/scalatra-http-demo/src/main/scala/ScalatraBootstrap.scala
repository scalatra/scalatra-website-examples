import org.scalatra.example._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new CookiesExample, "/cookies-example")
    context.mount(new FileUploadExample, "/upload")
    context.mount(new FilterExample, "/")
    context.mount(new HttpExample, "/*")
  }
}
