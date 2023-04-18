object SecondLargest extends App {
  val list = List(1, 2, 3, 4, 5, 6, 4, 5)
  private val list2 = list.toSet
  println(list2)
  private val list3 = list2.toList
  println(list3.sorted)
  println(list3.length - 1)
}
