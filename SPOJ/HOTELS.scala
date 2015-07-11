import scala.io.Source
import scala.annotation.tailrec
import scala.math.max


object Main extends App{

	def best(right:List[Int],sum:Int,M:Int,left:List[Int]):Int = if(right.size==0) sum
		else {
			println((right,sum,left))
			if(right.head+sum<=M) best(right.tail,right.head+sum,M,left:+right.head)
			else best(right,sum-left.head,M,left.tail)
		}


	val n::m::Nil = readLine.split(" ").map(_.toInt).toList
	val lst = readLine.split(" ").map(_.toInt).toList
	println(best(lst,0,m,List()));

}


Main.main(Array())
