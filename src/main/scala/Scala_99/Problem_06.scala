package Scala_99

object Problem_06 extends App {

  private def reverseList(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case head :: tail => reverseList(tail) ::: List(head)
  }

  private def palindromeCheck(firstList: List[Int], secondList: List[Int]): Boolean = {
    firstList.equals(secondList)
  }

  val firstList = List(1, 2, 3, 2, 1)
  val secondList = reverseList(firstList)
  print(palindromeCheck(firstList, secondList))

}
