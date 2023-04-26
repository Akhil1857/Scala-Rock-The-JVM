package Equality

object Driver extends App {

  private val convertor = new Convertor
  private val spelling = List("twenty hundred one", "Twelve", "Six")

  //Function Call
  convertor.spellingsToNumbers(spelling.map(_.toLowerCase)) match {
    case Some(value) => println(value) // prints List(NumberWordPair(0,(Error:-Value>100) Please Enter value <= 100), NumberWordPair(12,twelve), NumberWordPair(6,six))
    case None => print("Error")
  }

}