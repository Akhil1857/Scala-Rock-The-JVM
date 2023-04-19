package Options

import scala.util.{Try, Success, Failure}

object OptionsDemo extends App {

  private val myFirstOption: Option[List[Int]] = Some {
    List(1, 2, 3, 4, 5)
  }
  private val noOptions: Option[Int] = None

  println(myFirstOption)
  println(noOptions)

  private def unsafeMethod(): Option[Int] = None

  private def safeMethod(): Option[Int] = Some(2 + 5 + 7)

  val result = unsafeMethod().orElse(safeMethod())
  println(unsafeMethod().isEmpty)
  println(result)
  println(myFirstOption.map(list => list.map(_ * 2))) // Doubles the element of the list
  println(myFirstOption.map(list => list.filter(_ % 2 == 0)))


  //Use of Flatten...
  val list = List(List(1, 2), List(1, 2, 3), List(1, 9, 4))
  private val flattenList = list.flatten
  println(flattenList)

  //How to Create Multiple Constructor
  class Person(val name: String, val age: Int) {
    def this(name: String) {
      this(name, 0)
    }

    def print: String = s"$name is $age years old."
  }

  object Person {
    def apply(name: String, age: Int): Person = new Person(name, age)

    def apply(name: String): Person = new Person(name)

    def apply(): Person = new Person("Akhil Trivedi")
  }

  private val person1 = Person("Akhil", 30)
  private val person2 = Person("Bob")
  private val person3 = Person()

  println(person1.print)
  println(person2.print)
  println(person3.print)

  //Exception Handling
  //Program to print the factorial of the number

  def factorial(value: Int): Try[Int] = Try {
    if (value < 0) throw new IllegalArgumentException()

    def helperFact(number: Int, accumulator: Int): Int = {
      if (number == 0) accumulator
      else helperFact(number - 1, accumulator * number)
    }

    helperFact(value, 1)
  }

  private val resultFactorial = factorial(7)
  resultFactorial match {
    case Success(value) => print(value)
    case Failure(exception) => print(s"Please enter value>0 or 0 $exception")
  }



}
