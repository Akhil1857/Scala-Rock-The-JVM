package OOPS

class Writer(name: String, surname: String, val year: Int) {
  def fullname(): String = name + surname

}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge() = yearOfRelease - author.year

  def isWrittenBy(author: Writer) = author == this.author

  def copy(newYearOfRelease: Int) = new Novel(name, yearOfRelease, author)
}

object main extends App {
  val person = new Writer("Adam", "Milne", 1869)
  val novel = new Novel("Green Land", 1890, person)

  println(novel.authorAge())
  println(novel.isWrittenBy(person))
}