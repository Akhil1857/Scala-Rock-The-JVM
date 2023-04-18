package Multithreading

class ThreadDemo extends Thread {
  override def run(): Unit = {
    println("This the first thread")
  }
}

object Main extends App {
  private val threadDemo = new ThreadDemo
  threadDemo.start()

}
