package Generics

class GenericsDemo[A] {
  def NTimesPrint(x: A, times: Int): List[A] = {
    if (times < 1) Nil
    else x :: NTimesPrint(x, times - 1)
  }
}

object GenericsDemo extends App {
  private val objGenericDemo = new GenericsDemo[String]
  print(objGenericDemo.NTimesPrint("Knoldus", 3))
}


