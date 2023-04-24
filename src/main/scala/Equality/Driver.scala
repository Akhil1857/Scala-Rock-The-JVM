package Equality

object Driver extends App {

  private val convertor = new Convertor
  private val spelling = List("sixty six", "Twelve", "Six")
  private val numberWordPair: List[NumberWordPair] = convertor.spellingsToNumbers(spelling.map(_.toLowerCase)) //f:String => String

  println(numberWordPair) // prints List(NumberWordPair(66,sixty six), NumberWordPair(12,twelve), NumberWordPair(6,six))


}
