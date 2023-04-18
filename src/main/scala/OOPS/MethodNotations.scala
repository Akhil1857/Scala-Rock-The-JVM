package OOPS

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String) {
    def likes(movie: String): Boolean = movie == favouriteMovie

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
  }

  val mary = new Person("Akhil", "Farzi")
  println(mary.likes("Sultan"))
  println(mary likes "sultan")

  val tom = new Person("Tom", "Farzi")
  println(mary hangOutWith (tom))
}
