package Function_Practice

object PartialFunction extends App {
  def stringConcat(string1: String, string2: String): String = {
    string1 + string2
  }

  val result = stringConcat(_, "Trivedi")
  println(result("Akhil"))

  //
  //  private def add(a:String)(b:String)(f:(String=>String)) = stringConcat(a,b)
  //  val sum = add(2)_
  //    print(sum(5))


}


