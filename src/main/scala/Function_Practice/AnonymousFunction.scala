package Function_Practice

object AnonymousFunction extends App {

  private val superAdder = (number: Int) => (number2: Int) => number2 + number

  private val adder = superAdder(5)
  println(adder(4))
  println(superAdder(4)(9))


}
