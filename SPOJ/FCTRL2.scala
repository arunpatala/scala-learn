import scala.io.Source
import scala.math.BigInt

object Main extends App{
	import Util._
	def fact(i:BigInt):BigInt = if(i==1) BigInt("1") else i*fact(i-1)
	readTail.map{s=>fact(BigInt(s))}
		.foreach(println)

}

object Util{

	def read = Source.fromInputStream(System.in).getLines().takeWhile(_!=null)
	def readTail =  read.tail
	def readTailTuple2 = readTail.map(_.split(" ").toList.tuple2)

	implicit class MyIterator[T](iter:Iterator[T]){
		def tuple = (iter.next,iter)
		def tail = tuple._2
	}
	implicit class MySeq[T](seq:Seq[T]){
		def tuple2 = (seq(0),seq(1))
	}
	implicit class MyBooleanTraversable(t:Traversable[Boolean]){
		def or = t.reduce(_||_)
	}
}

Main.main(Array())
