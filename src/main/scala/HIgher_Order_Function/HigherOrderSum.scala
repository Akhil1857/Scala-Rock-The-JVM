package HIgher_Order_Function

class HigherOrderSum {

  def incrementSum(f: Int => Int, times: Int, finalResult: Int): Int = {
    if (times <= 0)
      finalResult
    else incrementSum(sum, times - 1, sum(finalResult))

  }

  def sum(number1: Int): Int = {
    number1 + number1
  }

}

object Main extends App {
  private val higherOrderSum = new HigherOrderSum
  print(higherOrderSum.incrementSum(higherOrderSum.sum, 10, 1))
}