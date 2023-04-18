package Multithreading

class RunnableThread extends Runnable {
  val thread1 = new Runnable {
    override def run(): Unit = {
      println("This thread is using Thread1")
    }

  }
  val thread2 = new Runnable {
    override def run(): Unit = {
      print("Thread running using Runnable")
    }
  }

  override def run(): Unit = ???
}

object main extends App {
  private val runnableThread = new RunnableThread
  private val extendsThread = new Thread(runnableThread)
  extendsThread.start()
  println(extendsThread.getName)
}
