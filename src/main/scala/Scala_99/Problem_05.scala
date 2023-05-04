package Scala_99

object Problem_05 extends App {

  private def reverseList(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case head :: tail => reverseList(tail) ::: List(head)
  }

  val list = List(1, 5, 4, 9, 3, 8)
  print(reverseList(list))

}
