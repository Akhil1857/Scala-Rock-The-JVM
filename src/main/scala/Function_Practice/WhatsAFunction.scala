package Function_Practice

object WhatsAFunction extends App {

  private def stringConcat = new((String, String) => String) {
    override def apply(string1: String, string2: String): String = {
      string1 + string2
    }
  }

  println(stringConcat("Akhil", "Trivedi"))

  private val superAdder: Int => ((Int) => Int) = (number: Int) => (number2: Int) => number2 + number

  private val adder = superAdder(5)
  println(adder(4))
  println(superAdder(4)(9))
}
