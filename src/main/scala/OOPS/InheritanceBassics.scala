package OOPS

class Fruits {
  val name: String = "Guava"
  val amount: Int = 120
}

class Fruits2 extends Fruits {
  override val name: String = "Mango"
  override val amount: Int = 50

  def details(): Unit = {
    println("Fruit name: " + name)
    println("Total amount/kg : " + amount)
  }
}

class Fruits3(val seasonal: String) extends Fruits2 {
  override def details(): Unit = {
    println("Fruit name : " + "Mango")
    println("Total amount/kg " + "120")
  }
}

object Main extends App {
  // private val objFruits = new Fruits2
  //  objFruits.details()

  private val objFruits = new Fruits3("Summer")
  objFruits.details()
}
