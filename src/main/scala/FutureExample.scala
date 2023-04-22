import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object FutureExample extends App {

  private def divide(numerator: Int, denominator: Int): Future[Int] = Future {
    if (denominator == 0) throw new Exception("Divide by 0")
    else numerator / denominator
  }

  val result: Future[Int] = divide(10, 0).recover {
    case _: IllegalArgumentException => 0
  }

  result.onComplete {
    case Success(value) => println(s"Result $value")
    case Failure(exp) => println(s"Failed with exception: $exp")
  }


  //Question Answer
  private val listInt = List("1", "2", "3", "4")
  private val result1 = listInt.map(num => num * 2) //String => String
  println(result1)

  val list = List("1", "2", "3", "4")
  private val result2 = list.map(num => num.toInt * 2) //Int =>Int
  println(result2)


  private trait Test {
    def printName() = "Test"
  }

  private val qaTest = new Test {
    override def printName(): String = "QATest"
  }

  println(qaTest.printName())

  //Function0[],Function1[],.......Function22[]
  //map Study (Higher order Function)


}