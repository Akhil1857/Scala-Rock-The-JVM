package Scala_99

import scala.annotation.tailrec

object Problem_17 extends App {

  @tailrec
  private def removeNthElement(index: Int, list: List[Int], newList: List[Int]): List[Int] = {
    if (index == 1) newList ::: list.tail

    else {
      removeNthElement(index - 1, list.tail, newList :+ list.head)
    }
  }

  val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 4)
  println(removeNthElement(1, list, List()))

}
