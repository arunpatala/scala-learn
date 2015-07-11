import scala.io.Source
import scala.math.BigInt

object Main extends App{
	import Util._
	val l = List(0) :: (1 to 9).map{i =>
		i :: Stream.from(2).map{math.pow(i,_).toInt%10}.takeWhile(_!=i).toList
	}.toList
	//l.foreach(println)
	read2.map{ case(x,y) =>
		if(x==0 && y==0) 1
		else if(x==0) 0
		else if(y==0) 1
		else{ val li = l(x%10)
		li(((y%li.size)-1+li.size)%li.size) }
	}.foreach(println)

}

object Util{

       def read = Source.fromInputStream(System.in).getLines().takeWhile(_!=null)
        def readTail =  {read.next;read}
        def readTailIntTuple2 = readTail.map(_.split(" ").map(_.toInt).toList).map{l=>(l(0),l(1))}
	def read2 = readTailIntTuple2
}

Main.main(Array())
