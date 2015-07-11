import scala.io.Source
import scala.math.BigInt

object Main extends App{
	val l = readLine().toInt
	val out = (1 to math.sqrt(l).toInt).map{ i=>
		(l/i)-(i-1)
	}.sum
	println(out)

}

object Util{

       def read = Source.fromInputStream(System.in).getLines().takeWhile(_!=null)
        def readTail =  {read.next;read}
        def readTailIntTuple2 = readTail.map(_.split(" ").map(_.toInt).toList).map{l=>(l(0),l(1))}
	def read2 = readTailIntTuple2
}

Main.main(Array())
