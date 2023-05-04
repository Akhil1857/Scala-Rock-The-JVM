package Scala_99

object Problem_16 extends App {

   private def duplicate(list:List[Char]):List[Char] = {
     list.flatMap(a => List(a,a))
   }

  val list = List('a', 'b', 'c', 'c', 'd')
  println(duplicate(list))
}
