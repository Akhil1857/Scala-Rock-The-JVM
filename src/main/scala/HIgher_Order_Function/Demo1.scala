//package HIgher_Order_Function
//
//import scala.Byte.MaxValue.*
//
//class PolymorphicMethod[A] {
//  def applyFunction(f: (A, A) => A, x: A, y: A): A = {
//    f(x, y)
//  }
//
//  def add[A](x: A, y: A): A = x + y
//
//  def multiply[A](x: A, y: A): A = x * y
//
//  println(applyFunction(add, 5, 6))
//  println(applyFunction(multiply, 0, 5))
//
//  def applyNTimes[A](number: A, times: A,f: (A => A) ): A = {
//    if (times == 0) number
//    else applyNTimes(f(number), times - 1,f)
//  }
//  def square[A](number: A): A = {
//    number * number
//  }
//
//  println(applyNTimes( 2, 4,square()))
//}
//val n = new PolymorphicMethod[Int]
//n.applyFunction(10,4,square)