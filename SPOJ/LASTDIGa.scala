import scala.io.Source
import scala.math.BigInt

object Main extends App{
	import Util._
	def digit(a:Int,n:Int):Int = if(a==0&&n==0) 0 
		else if(n==0) 1
		else if(n==1) a%10
		else if(n%1==0) (a*digit(a,n-1))%10
		else (digit(a,n/2)*digit(a,n/2))%10



	read2.map{ case(x,y) =>
		digit(x,y)	
	}.foreach(println)

}

object Util{

       def read = Source.fromInputStream(System.in).getLines().takeWhile(_!=null)
        def readTail =  {read.next;read}
        def readTailIntTuple2 = readTail.map(_.split(" ").map(_.toInt).toList).map{l=>(l(0),l(1))}
	def read2 = readTailIntTuple2
}

Main.main(Array())
