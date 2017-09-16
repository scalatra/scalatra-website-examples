package org.scalatra.example.commands.commandsupport

// the model code from this application
import org.scalatra.example.commands.models._

// the Scalatra validator base code
import org.scalatra.validation.Validators.{PredicateValidator, Validator}

// the Scalatra command handlers
import org.scalatra.commands._

// Scalatra's JSON-handling code
import org.scalatra.json._
import org.json4s.{DefaultFormats, Formats}

/**
 * A class to keep our custom String validations in.
 * 
 * Note that it takes a FieldDescriptor[String] binding as a parameter.
 * This is so that we can pimp the FieldDescriptor. 
 */
class TodosStringValidations(b: FieldDescriptor[String]) {

  // define a validation which we can apply to a [Field]
  def startsWithCap(message: String = "%s must start with a capital letter.") = b.validateWith(s =>
    _  => new PredicateValidator[String](b.name, """^[A-Z,0-9]""".r.findFirstIn(_).isDefined, message).validate(s)
  )
}

/** Set up an abstract class to inherit from, so we don't need to keep on
 *  repeating the `extends ModelCommand[T]` in every command we make.
 */
abstract class TodosCommand[S](implicit mf: Manifest[S]) extends JsonCommand {
  
  /**
   * Decorate the [org.scalatra.commands.FieldDescriptor] class with our [TodosStringValidations]
   * 
   * This adds the validation to the binding for the FieldDescriptor's b.validateWith function.
   */
  implicit def todoStringValidators(b: FieldDescriptor[String]) = new TodosStringValidations(b)
}

/** A command to validate and create Todo objects. */
class CreateTodoCommand extends TodosCommand[Todo] { 

  // add json format handling so the command can do automatic conversions.
  protected implicit val jsonFormats = DefaultFormats

  // the validation conditions on the name field.
  val name: Field[String] = asType[String]("name").notBlank.minLength(3).startsWithCap()
  
}