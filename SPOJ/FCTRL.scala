import scala.io.Source

object Main extends App{
	import Util._
	def fives(n:Int) = Stream.from(1).map(x=>n/(math.pow(5,x).toInt)).takeWhile(_!=0).sum
	readTail.map{s=>fives(s.toInt)}
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
