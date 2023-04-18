package Scala_99

object NumberOfElementInList_04 extends App {

  private def listLength(list: List[Int], count: Int): Int = list match {
    case _ :: Nil => count + 1
    case _ :: tail => listLength(tail, count + 1)
    case Nil => 0
  }

  val list = List(1, 2, 5, 4, 6, 5, 89, 4, 8, 54, 5, 5)
  var count = 0
  print(listLength(list, count))

}
