package org.scalatra.example.commands.data

import org.scalatra.example.commands.models._
import org.scalatra.example.commands.commandsupport._
import org.scalatra.example.commands.utils.Logging
import scalaz._
import Scalaz._
import scala.util.control.Exception._
import org.scalatra.validation._
import org.scalatra.commands._
import java.util.concurrent.atomic.AtomicInteger

/** A fake datastore which keeps Todo objects in RAM.
 *
 * Logging is just here to satisfy the compiler. 
 */
object TodoData extends Logging {

  /** A counter variable to fake out auto-incrementing keys for us **/
  val idCounter = new AtomicInteger(3)

  /** Some fake todos data so we can simulate retrievals. */
  var all = List(
      Todo(1, "Shampoo the cat", true),
      Todo(2, "Wax the floor"),
      Todo(3, "Scrub the rug"))

  /** Returns the number of Todos which are not yet Todone. **/
  def remaining = {
    all.filterNot(_.done == true).length
  }

  /** Instantiates a new `Todo` object with an auto-incremented primary key id. 
   */
  def newTodo(name: String) = Todo(idCounter.incrementAndGet, name)
  
  /** Adds a new Todo object to the existing list of todos.
   * 
   * The method returns a ModelValidation[Todo], which is carried around in the
   * todo.successNel. Think of "successNel" as being like a two part variable 
   * name. The result is either 
   * Success[Model] or Failure[NonEmptyList[ValdationError]]. So you're getting
   * back either "success" OR a non-empty list ("Nel"). This type signature is
   * in turn dictated by the return value needed by the `handle` method, above.
   * 
   * If any exceptions happen as we're doing work here, the errorFail method 
   * will be called, due to the allCatch.withApply (which is equivalent to a
   * try {} catch {} block. 
   */
  def add(todo: Todo): ModelValidation[Todo] = {
    allCatch.withApply(errorFail) {
      all ::= todo
      all = all.sortWith((e1, e2) => (e1.id < e2.id))
      todo.successNel
    }
  }

  /** Throw a validation error if something explodes when adding a Todo **/
  def errorFail(ex: Throwable) = ValidationError(ex.getMessage, UnknownError).failureNel
}
