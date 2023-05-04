package Scala_99

import scala.annotation.tailrec

object Problem_18 extends App {

  private def subList(start:Int,end:Int,list:List[Char]):List[Char] = {

    @tailrec
    def slice(count:Int, userList:List[Char], result:List[Char]):List[Char] = (count,userList) match {
      case(_,Nil) => result.reverse
      case (c,head::tail) if end<= c => result.reverse
      case (c,head::tail) if start <= c => slice(c+1,tail,head::result)
      case (c,_ ::tail) => slice(c+1,tail,result)
    }
    slice(0,list,Nil)



  }
  println(subList(3,7,List('a', 'b', 'c', 'd', 'e', 'f', 'g','h', 'i', 'j', 'k')))

}
