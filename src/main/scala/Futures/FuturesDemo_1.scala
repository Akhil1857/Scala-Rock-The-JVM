package Futures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}

object SocialNetwork extends App {

  private def increment(number: Int): Int = {
    Thread.sleep(2000)
    number + 1
  }

  private val aFuture = Future(
    increment(5)
  )
  println(aFuture.value)
  Thread.sleep(3000)

  aFuture.onComplete(t => t match {
    case Success(value) => println(value)
    case Failure(exception) => println(exception)
  })

  //mini social network

  case class Profile(id: String, name: String) {
    def poke(anotherProfile: Profile): Unit =
      println(s"${this.name} poking ${anotherProfile.name}")
  }

  val names = Map(
    "fb.id.01-John" -> "John",
    "fb.id.02-bill" -> "Bill",
    "fb.id.03-dummy" -> "Dummy"
  )
  val friends = Map(
    "fb.id.01-John" -> "fb.id.02-bill"
  )

  private def fetchProfile(id: String): Future[Profile] = Future {

    Thread.sleep(30)
    Profile(id, names(id))
  }

  private def fetchBestFriend(profile: Profile): Future[Profile] = Future {
    Thread.sleep(40)
    val bfId = friends(profile.id)
    Profile(bfId, names(bfId))
  }

  //John to poke bill
  private val john = fetchProfile("fb.id.01-John")
  john.onComplete {
    case Success(johnProfile) =>
      val bill = fetchBestFriend(johnProfile)
      bill.onComplete {
        case Success(billProfile) => johnProfile.poke(billProfile)
        case Failure(e) => e.printStackTrace()
      }
    case Failure(ex) => println(ex.getStackTrace())
  }
  Thread.sleep(1000)

  //Functional Composition
  //map,flatMap,filter

  val nameOnWall = john.map(profile => profile.name)
  Thread.sleep(1000)
  println(nameOnWall)
  val johnBestFriends = john.flatMap(profile => SocialNetwork.fetchBestFriend(profile))
  Thread.sleep(1000)
  println(johnBestFriends)
  val billBestFriendRestricted = johnBestFriends.filter(profile => profile.name.startsWith("X"))
  Thread.sleep(1000)
  println(billBestFriendRestricted)

  //fallbacks
  val aProfileNoMatterwhat = SocialNetwork.fetchProfile(id = "unknown - id").recover {
    case e: Throwable => Profile("fb.id.03-dumm","Forever Alone")
  }
  Thread.sleep(500)
  println(aProfileNoMatterwhat)

  val aFetchProfileNoMatterwhat = SocialNetwork.fetchProfile(id = "fb.id.02-bill").recoverWith {
    case e: Throwable => Future(SocialNetwork.fetchProfile("fb.id.02-dummy"))
  }
  Thread.sleep(500)
  println(aFetchProfileNoMatterwhat)

  // online banking app

  case class User(name:String)
  case class Transaction(sender:String,receiver:String,amount:Double,status:String)

  object BankingApp {
    val name = "Banking"

    def fetchUser(name:String):Future[User] = Future {
      Thread.sleep(500)
      User(name)
    }
    def createTransaction(user:User, merchantName: String,amount:Double):Future[Transaction] =Future {
      Thread.sleep(1000)
      Transaction(user.name,merchantName,amount,"Fails")
    }

    def purchase(username:String,item:String,merchantName:String,cost:Double):String = {
      //fetch the user from the Database
      //create a Transaction
      //Wait for the transaction to finish

      val transactiionStatus = for {
        user <- fetchUser(username)
        transaction <- createTransaction(user,merchantName,cost)
      }yield transaction.status

      Await.result(transactiionStatus,2.seconds)
    }
  }

  println(BankingApp.purchase("John","Bag","SkyBags",3000))


}