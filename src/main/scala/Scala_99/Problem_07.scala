package Scala_99

object Problem_07 extends App {

  private def listFlat(list: List[Any]): List[Any] = list flatMap {
    case inside: List[_] => listFlat(inside)
    case e => List(e)
  }

  val list = List(List(1, 1), 2, List(3, List(5, 8)))
  println(listFlat(list))

}
