package Scala_99

object SecondLastElement_02 extends App {

  private def secondLast(list: List[Int]): Int = list match {
    case head :: second :: Nil => head
    case head :: second => secondLast(second)
    case _ => throw new NoSuchElementException()
  }

  val list = List(8, 5, 0, 9, 0, 4, 8, 0, 6)

  try {
    val result = secondLast(list)
    print(result)
  } catch {
    case e: NoSuchElementException => print("List doesn't contain the second Last Element")
  }


}
