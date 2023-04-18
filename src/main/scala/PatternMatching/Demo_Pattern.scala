package PatternMatching

object Demo_Pattern extends App {
  val list = List(1, 2, 3, 4)
  val result = list match {
    case listOfInteger: List[Int] => print("World")
    case listOfString: List[String] => print("Hello")
    case _ => ""
  }

  // Exercise
  private trait Expression

  private case class Number(n: Int) extends Expression

  private case class Sum(exp1: Expression, exp2: Expression) extends Expression

  private case class Product(exp1: Expression, exp2: Expression) extends Expression

  private def show(expression: Expression): String = expression match {
    case Number(n) => s"$n"
    case Sum(exp1, exp2) => show(exp1) + " + " + show(exp2)
    case Product(exp1, exp2) =>
      def maybeParentheses(exp: Expression) = exp match {
        case Product(_, _) => show(exp)
        case Number(_) => show(exp)
        case _ => "(" + show(exp) + ")"
      }

      maybeParentheses(exp1) + " * " + maybeParentheses(exp2)
  }

  println(show(Product(Sum(Number(2), Number(3)), Number(5))))


  //Drop Every Nth Element from the List
  private def drop[A](index: Int, list: List[A]): List[A] = {
    def dropRecursion(temp: Int, updateList: List[A]): List[A] = (temp, updateList) match {
      case (_, Nil) => Nil
      case (1, _ :: tail) => dropRecursion(index, tail)
      case (_, head :: tail) => head :: dropRecursion(temp - 1, tail)
    }

    dropRecursion(index, list)
  }

  val list2 = List(1, 2, 3, 4, 5, 6)
  println(drop(3, list2))
  println(list2.splitAt(3))

}
