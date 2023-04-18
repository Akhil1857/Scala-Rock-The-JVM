package HIgher_Order_Function

object MapDemo extends App {
  private val capitals = Map("India" -> "Delhi", "Japan" -> "Tokyo")
  println(capitals get "Japan")
  private val capital2 = capitals ++ Map("India" -> "Dehradun")
  println(capital2)
}
