package Equality

import java.util.InputMismatchException
import scala.annotation.tailrec

case class NumberWordPair(number: Int, spelling: String)

object Main extends App {
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

  private def spellingToNumber(spelling: String): NumberWordPair = {
    @tailrec
    def processWords(words: List[String], result: Int): Int = words match {
      case Nil => result
      case word :: rest =>
        val value = stringToInt(word)
        if (value < 1000) processWords(rest, result + value)
        else throw new InputMismatchException("Please enter number less than hundred")
    }

    val words = spelling.split(" ").toList
    val current = processWords(words, 0)
    NumberWordPair(current, spelling)
  }

  private def spellingsToNumbers(spellings: List[String]): List[NumberWordPair] = {
    spellings.map(word => spellingToNumber(word))
  }

  private val spelling = List("seven hundred seven", "twelve", "six")
  private val numberWordPair: List[NumberWordPair] = spellingsToNumbers(spelling)
  println(numberWordPair) // prints List(NumberWordPair(66,sixty six), NumberWordPair(12,twelve), NumberWordPair(6,six))
}
