package Scala_99

import scala.annotation.tailrec

object Problem_09 extends App {

  private def letterSeparation(list: List[Char]): List[List[Char]] = {
    @tailrec
    def helper(list: List[Char], resultantList: List[List[Char]]): List[List[Char]] = {
      list match {
        case head::tail => helper(list.dropWhile(_ == list.head), resultantList :+ list.takeWhile(_ == list.head))
        case _ => resultantList
      }
    }

    helper(list, List())
  }

  val list = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
  //val list = List('a')

  println(letterSeparation(list))

}
