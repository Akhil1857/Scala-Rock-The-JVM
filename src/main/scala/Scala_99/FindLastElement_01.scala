package Scala_99

object FindLastElement_01 extends App {

  val list = List()
  try {
    val endElement = findLast(list)
    println(s"The last element of the list is $endElement")
  } catch {
    case e: NoSuchElementException => print("List is Empty")
  }


  private def findLast(list: List[Int]): Int = list match {
    case head :: Nil => head
    case _ :: tail => findLast(tail)
    case _ => throw new NoSuchElementException()

  }

}
