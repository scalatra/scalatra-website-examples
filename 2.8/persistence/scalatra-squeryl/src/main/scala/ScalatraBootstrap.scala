import org.scalatra.LifeCycle
import javax.servlet.ServletContext
import org.scalatra.example.ArticlesController
import org.scalatra.example.data.DatabaseInit

class ScalatraBootstrap extends LifeCycle with DatabaseInit {

  override def init(context: ServletContext) = {
    configureDb
    context mount (new ArticlesController, "/*")
  }
  
  override def destroy(context:ServletContext) = {
    closeDbConnection
  }
}
