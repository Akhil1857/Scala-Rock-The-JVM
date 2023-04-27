import Equality.{Convertor, NumberWordPair}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.util.Success

class IntegerToStringTest extends AnyFlatSpec with Matchers {
 val convertor = new Convertor

 "Convertor" should "return valid Integer value and error for number > 100" in {
  val inputString = List("one hundred one", "twelve", "six")
  val resultantList = convertor.spellingsToNumbers(inputString.map(_.toLowerCase))
  resultantList shouldBe Success(List(NumberWordPair(0,"(Error:-Value>100) Please Enter value <= 100"), NumberWordPair(12,"twelve"), NumberWordPair(6,"six")))
 }

 it should "return valid Integer value" in {
  val inputString = List("sixty five", "twelve", "six")
  val resultantList = convertor.spellingsToNumbers(inputString.map(_.toLowerCase))
  resultantList shouldBe Success(List(NumberWordPair(65, "sixty five"), NumberWordPair(12, "twelve"), NumberWordPair(6, "six")))
 }



}
