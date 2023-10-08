import org.apache.pekko.actor.{Props, ActorSystem}
import com.example.app._
import org.scalatra._
import jakarta.servlet.ServletContext


class ScalatraBootstrap extends LifeCycle {

  private val system = ActorSystem()
  private val myActor = system.actorOf(Props.apply[MyActor]())

  override def init(context: ServletContext): Unit = {
    context.mount(new FutureController(system), "/*")
    context.mount(new MyActorApp(system, myActor), "/actors/*")
  }

  override def destroy(context:ServletContext): Unit = {
    system.terminate()
  }
}
