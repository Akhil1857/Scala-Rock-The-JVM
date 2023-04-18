package Function_Practice

import scala.io.StdIn._

//Greeting function.
object Greeting_child extends App {
  def greeting(name: String, age: Int): String = {
    s"Hi my name is $name and I am $age year old"
  }

  val name: String = readLine("Enter your name")
  println("Enter your age ")
  val age: Int = readInt()
  print(greeting(name, age))
}

//factorial recursive function

object Factorial extends App {
  def factorial(number: Int): Int = {
    var fact = 1
    if (number <= 0)
      return fact
    else
      return number * factorial(number - 1)
  }

  print(factorial(8))
}

//fibonacci series upto n term
object Fibonacci extends App {
  def fibonacci(n_place: Int): Int = {
    if (n_place == 1 || n_place == 2)
      return 1
    else
      return fibonacci(n_place - 1) + fibonacci(n_place - 2)
  }

  print(fibonacci(8))
}

//String concat

object StringConcat extends App {
  def stringmerge(name: String, time: Int, finalString: String): String = {
    if (time <= 0) finalString
    else
      stringmerge(name, time - 1, name + finalString)
  }

  print(stringmerge("Akhil", 5, ""))
}

//