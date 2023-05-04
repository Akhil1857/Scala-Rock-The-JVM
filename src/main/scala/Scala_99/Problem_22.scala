package Scala_99

import scala.annotation.tailrec

object Problem_22 extends App {

  @tailrec
  private def inBetween(start: Int, end: Int, list: List[Int]): List[Int] = {

    if (start <= end) inBetween(start+1, end, start :: list)
    else list.reverse
  }

  println(inBetween(-4, 9, List[Int]()))

}
