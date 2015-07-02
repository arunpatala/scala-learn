import scala.io.Source

object Main extends App{
	import Util._
	readTailTuple2.map{case(x,y)=>(x.reverse.toInt+y.reverse.toInt).toString.reverse.toInt}
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
