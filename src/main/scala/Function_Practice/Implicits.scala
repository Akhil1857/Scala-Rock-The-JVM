package Function_Practice

import scala.language.implicitConversions

object Implicits extends App {

  case class Person(name: String, age: Int)

  //Use of Implicits
  implicit def convertStringToPerson(person: Person): String = {
    person.name
  }

  def printName(name: String): String = {
    name
  }

  val data = Person("Akhil", 20)
  println(printName(data))

  //Use of Implicit Parameter
  implicit val num1: Int = 15
  implicit val num3: String = "10" //there will be only single implicit of single dataType to be understand by the compiler easily

  def multiply(num2: Int)(implicit num3: Int, num1: Int, num4: Int): Int = {
    num1 * num2 + num3 + num4
  }

  println(multiply(15))

  //
}
