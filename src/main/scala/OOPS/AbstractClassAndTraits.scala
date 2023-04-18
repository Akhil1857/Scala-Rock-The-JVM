package OOPS

object AbstractClassAndTraits extends App {
  private sealed trait Office { //Sealed Class/Trait can be inherit or implement in only This file.

    val noOfEmployee = 350 //Default value.(in case it is not defined in class which extends it.)

    def motive(): Unit
  }

  private sealed class Knoldus extends Office {
    override def motive(): Unit = {
      println("Motive of knoldus Go 1% Daily")
    }
  }

  private val knoldus = new Knoldus
  print(knoldus.noOfEmployee)


}
