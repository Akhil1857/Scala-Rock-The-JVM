package Scala_99

object Problem_31 extends App {

  def isPrime(number: Int, counter: Int): Boolean = {
    if (number % counter != 0 && counter < number) isPrime(number, counter + 1)
    else if (counter == number) true
    else false

  }

  val number = 1
  println(isPrime(number, 1))

}
