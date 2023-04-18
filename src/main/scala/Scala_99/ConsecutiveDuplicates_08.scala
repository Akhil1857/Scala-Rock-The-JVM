package Scala_99

object ConsecutiveDuplicates_08 extends App {

  def removeConsecutive(list: List[Char]): List[Char] = {
    list.foldRight(List[Char]()) {
      (h, r) =>
        if (r.isEmpty || r.head != h) h :: r
        else r
    }
  }

  val list = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
  println(removeConsecutive(list))

}
