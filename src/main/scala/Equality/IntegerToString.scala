package Equality

import scala.annotation.tailrec
import scala.util.{Failure, Success, Try}

case class NumberWordPair(number: Int, spelling: String)

class Convertor {

  private val stringToInt = Map(
    "zero" -> 0,
    "one" -> 1,
    "two" -> 2,
    "three" -> 3,
    "four" -> 4,
    "five" -> 5,
    "six" -> 6,
    "seven" -> 7,
    "eight" -> 8,
    "nine" -> 9,
    "ten" -> 10,
    "eleven" -> 11,
    "twelve" -> 12,
    "thirteen" -> 13,
    "fourteen" -> 14,
    "fifteen" -> 15,
    "sixteen" -> 16,
    "seventeen" -> 17,
    "eighteen" -> 18,
    "nineteen" -> 19,
    "twenty" -> 20,
    "thirty" -> 30,
    "forty" -> 40,
    "fifty" -> 50,
    "sixty" -> 60,
    "seventy" -> 70,
    "eighty" -> 80,
    "ninety" -> 90,
    "hundred" -> 100
  )

  private def spellingToNumber(spelling: String): Try[NumberWordPair] = {
    @tailrec
    def processWords(words: List[String], result: Int): Try[Int] = {
      words match {
        case Nil => Success(result)
        case word :: rest =>
          val value = stringToInt(word)
          if (result <= 100) processWords(rest, result + value)
          else Failure(new IllegalArgumentException())
      }
    }

    val words = spelling.split(" ").toList
    processWords(words, 0) match {
      case Success(value) => Success(NumberWordPair(value, spelling))
      case Failure(exception) => Failure(exception)

    }
  }

  def spellingsToNumbers(spellings: List[String]): List[NumberWordPair] = {
    spellings.map(word => spellingToNumber(word) match {
      case Success(value) => value
      case Failure(ex) => NumberWordPair(0, s"(Error:-Value>100) Please Enter value <= 100")
    })
  }

}

