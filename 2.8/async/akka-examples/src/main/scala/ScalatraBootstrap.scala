import _root_.akka.actor.{Props, ActorSystem}
import com.example.app._
import org.scalatra._
import javax.servlet.ServletContext


class ScalatraBootstrap extends LifeCycle {

  val system = ActorSystem()
  val myActor = system.actorOf(Props[MyActor])

  override def init(context: ServletContext) {
    context.mount(new FutureController(system), "/*")
    context.mount(new MyActorApp(system, myActor), "/actors/*")
  }

  override def destroy(context:ServletContext) {
    system.terminate()
  }
}
