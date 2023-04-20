package TuplesAndMaps

object TuplesAndMapExercise extends App {
  private val aTuple = (2, "hello Scala", 15)
  println(aTuple._1)
  println(aTuple.copy(_2 = "Hello Scala World"))

  private val phonebook = Map(("Akhil", 8090), ("Nikhil", 4991), ("AKHIL", 909)).withDefaultValue(-1)
  println(phonebook)

  //map operations
  println(phonebook.contains("Akhil"))
  println(phonebook.getOrElse("Akhil", "Not present as a Key"))

  //Add a pair into the Map
  val newPair = "Prakhar" -> 1000
  val updatedPhonebook = phonebook + newPair
  println(updatedPhonebook)

  //Functions on the Maps map,flatMap,filter
  println(phonebook.map(contact => contact._1.toLowerCase() -> contact._2))

  //filterKeys
  println(updatedPhonebook.view.filterKeys(contact => contact.startsWith("A")))
  //mapValues
  println(phonebook.view.mapValues(number => number * 10))
  println(updatedPhonebook.toList)


  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], person1: String, person2: String): Map[String, Set[String]] = {
    val friendsA = network(person1)
    val friendsB = network(person2)

    network + (person1 -> (friendsA + person2)) + (person2 -> (friendsB + person1))

  }

  def unfriend(network: Map[String, Set[String]], person1: String, person2: String): Map[String, Set[String]] = {
    val friendsA = network(person1)
    val friendsB = network(person2)

    network + (person1 -> (friendsA - person2)) + (person2 -> (friendsB - person1))
  }

  //  def remove(network: Map[String,Set[String]],person:String):Map[String,Set[String]]={
  //
  //  }
  val empty: Map[String, Set[String]] = Map()
  val network = add(empty, "Bob")
  println(network)
  val newNetwork = add(network, "Jim")
  println(newNetwork)
  println(friend(newNetwork, "Bob", "Jim"))
  println(unfriend(friend(newNetwork, "Bob", "Jim"), "Bob", "Jim"))

  //Jim,Bob,Mary
  val people = add(add(add(empty, "Jim"), "Bob"), "Mary")
  println(people)
  val jimBob = friend(people, "Bob", "Mary")
  println(jimBob)
  val BobMary = friend(jimBob, "Bob", "Jim")
  println(BobMary)

  def nFriends(network: Map[String, Set[String]], person: String): Int = {
    if (!network.contains(person)) 0
    else network(person).size
  }

  println(nFriends(BobMary, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String = {
    network.maxBy(friends => friends._2.size)._1
  }

  println(mostFriends(BobMary))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int = {
    network.count(_._2.isEmpty)
  }

  println(nPeopleWithNoFriends(network))


}
