package Generics

abstract class Student {
  def name: String

  def age: Int
}

case class Boys(name: String, age: Int) extends Student

case class Girls(name: String, age: Int) extends Student

object VarianceDemo extends App {

  //Covariance
  private def studentNames(student: List[Student]): Unit = {
    student.foreach {
      student => println(student.name + " is " + student.age + " year old")
    }
  }

  private val boys: List[Boys] = List(Boys("Akhil", 23), Boys("Prakhar", 23))
  private val girls: List[Girls] = List(Girls("Deepshikha", 22), Girls("Shivani", 25))

  //Accessing list of the Boys
  studentNames(boys)
  //Accessing list of the Girls
  studentNames(girls)


}
