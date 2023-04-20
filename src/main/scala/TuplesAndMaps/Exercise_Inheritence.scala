package TuplesAndMaps

abstract class MyList {
  def head: Int

  def tail: MyList

  def isEmpty: Boolean

  def add(element: Int): MyList

  def printElements: String

  override def toString: String = "[" + printElements + "]"

}

object Empty extends MyList {
  override def head: Int = throw new NoSuchElementException()

  override def tail: MyList = throw new NoSuchElementException()

  override def isEmpty: Boolean = false

  override def add(element: Int): MyList = new NonEmpty(element, Empty)

  override def printElements: String = ""

}

class NonEmpty(headList: Int, tailList: MyList) extends MyList {
  def head: Int = headList

  def tail: MyList = tailList

  def isEmpty: Boolean = false

  def add(element: Int): MyList = new NonEmpty(element, this)

  def printElements: String = {
    if (tailList.isEmpty) "" + headList
    else headList + " " + tailList.printElements
  }
}


object Main2 extends App {
  private val nonEmpty = new NonEmpty(1, new NonEmpty(5, new NonEmpty(9, Empty)))
  println(nonEmpty.head)
  println(nonEmpty.tail.head)
  println(nonEmpty.toString)

}


