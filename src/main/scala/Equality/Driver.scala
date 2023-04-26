package Equality

import scala.util.{Failure, Success}

object Driver extends App {

  private val convertor = new Convertor
  private val spelling = List("one hundred one","twelve","six")

  //Function Call
  convertor.spellingsToNumbers(spelling.map(_.toLowerCase)) match {
    case Success(value) => println(value) // prints List(NumberWordPair(0,(Error:-Value>100) Please Enter value <= 100), NumberWordPair(12,twelve), NumberWordPair(6,six))
    case Failure(ex) => println(s"Error+${ex.getMessage}")
  }

}