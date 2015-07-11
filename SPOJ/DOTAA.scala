import scala.io.Source
import scala.annotation.tailrec
import scala.math.max



object Main extends App{
	import Util._
	def meth(reader:Iterator[String]):Unit = {
		val nmD = reader.next.split(" ").map(_.toInt)
		val n = nmD(0);val m = nmD(1);val D = nmD(2);
		val lst = reader.take(n).map(_.toInt).map{ i =>
			if(i%D==0) (i/D)-1
			else i/D
		}.sum
		if(lst>m) println("YES") else println("NO")
	}

	val iter =  Source.fromInputStream(System.in).getLines()
	val T = iter.next.toInt
	for(i<-(1 to T))
		{meth(iter)}


}


Main.main(Array())
