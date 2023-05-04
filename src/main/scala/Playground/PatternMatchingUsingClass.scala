package Playground

class Person(val age:Int,val name:String)
object Person{
  def unapply(person: Person):Option[(Int,String)] = Some((person.age,person.name))
}
object PatternMatchingUsingClass extends App{
  val person = new Person(10,"John")
  person match{
    case Person(age,name) => println(s"$name is $age year old")
    case _ => println("Data not found")
  }
}
