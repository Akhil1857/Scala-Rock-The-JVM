package Equality

import scala.annotation.tailrec

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

  private def spellingToNumber(spelling: String): Option[NumberWordPair] = {
    @tailrec
    def processWords(words: List[String], result: Int): Option[Int] = {
      words match {
        case Nil => Some(result)
        case word :: rest =>
          val value = stringToInt(word)
          if (result <= 100) processWords(rest, result + value)
          else None
      }
    }

    val words = spelling.split(" ").toList
    processWords(words, 0) match {
      case Some(digit) => Some(NumberWordPair(digit, spelling))
      case None => None
    }
  }

  def spellingsToNumbers(spellings: List[String]): Option[List[NumberWordPair]] =Option {
    spellings.map(word => spellingToNumber(word) match {
      case Some(value) => value
      case None => NumberWordPair(0, s"(Error:-Value>100) Please Enter value <= 100")
    })
  }

}