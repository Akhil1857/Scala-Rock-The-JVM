package Scala_99

import scala.annotation.tailrec

object Problem_03 extends App {

  @tailrec
  private def kthExtractor(kthElement: Int, list: List[Int]): Int = (kthElement, list) match {
    case (0, head :: _) => head
    case (kthElement, _ :: tail) => kthExtractor(kthElement - 1, tail)
    case (_, Nil) => throw new NoSuchElementException()
  }

  val list = List(2, 4, 59, 74, 32, 19)
  private val elementToFind = 2
  try{
    val result = kthExtractor(elementToFind, list)
    print(result)
  }catch{
    case e: NoSuchElementException => print("Element not Found")
  }
}

















