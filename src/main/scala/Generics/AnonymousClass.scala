package Generics

object AnonymousClass extends App {
  private abstract class Animal {
    def name: String
  }

  //Anonymous Class
  private val animal = new Animal {
    override def name: String = "Dog"
  }
  print(animal.getClass)

}
