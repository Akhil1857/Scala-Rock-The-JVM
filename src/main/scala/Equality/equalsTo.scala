package Equality

object EqualsTo extends App {


  private val firstList = List(1, 2, 3, 4)
  private val secondList = List(1, 2, 3, 4)
  private val thirdList = List(11, 22, 33, 44)

  println(firstList eq secondList)
  println(firstList.equals(secondList))
  println(firstList == secondList)

  println(firstList eq thirdList)
  println(firstList.equals(thirdList))
  println(firstList == thirdList)


}
