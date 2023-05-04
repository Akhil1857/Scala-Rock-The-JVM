package Scala_99

object Problem_08 extends App {

  def removeConsecutive(list: List[Char]): List[Char] = {
    list.foldRight(List[Char]()) {
      (h, r) =>
        if (r.isEmpty || r.head != h) h :: r
        else r
    }
  }

  val list = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
  println(removeConsecutive(list))
  val list1 = List(1,2,3,4,5)
  val newList =  6 +: list1
  val sum = newList.foldLeft(1)((a,b)=>a+b)
  val sum2 = newList.fold(0)((a,b)=>a+b)
}
