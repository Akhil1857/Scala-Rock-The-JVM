package Playground

trait Show[T] {
  def show(value: T): String
}

object ImplicitAssignment extends App {
  implicit def intToString[T <: Any]: Show[T] = {
    (t: T) => t.toString
  }

  val result = implicitly[Show[Int]].show(5)
  println(result)

}
