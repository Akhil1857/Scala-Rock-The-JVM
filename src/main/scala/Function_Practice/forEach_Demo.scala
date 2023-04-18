package Function_Practice

object forEach_Demo extends App {
  val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  private val squareList = list.map(x => x * x)
  println(squareList)

  val squareList2 = list.foreach(x => print(x * x + " "))


  //Use of for Comprehension
  private val list1 = List(1, 2, 3, 4, 5)
  private val chars = List('a', 'b', 'c', 'd')
  val result = for {
    n1 <- list1
    n2 <- chars
  } yield "" + n1 + n2
  println(result)

  //parallel Collection
  private val listPar = (1 to 1000).toList

  println(parallelCollection(listPar))
  println(foldExample(listPar))

  private def parallelCollection(list: List[Int]): Int = {
    var sum = 0
    list.foreach(sum += _)
    sum
  }

  private def foldExample(list: List[Int]): Int = {
    list.foldLeft(-1) { (a, b) => a + b }
    list.foldRight(-1) { (a, b) => a + b }
  }
}
