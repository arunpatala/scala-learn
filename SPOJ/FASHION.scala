import scala.io.Source

object Main extends App{
	import Util._
	read8.map{ case(x,y) => x.sorted.zip(y.sorted).map{case(x,y)=>x*y}.sum }.printn

}

object Util{

	def read8 = readTail.grouped(3).map{l=>(l(1).split(" ").toInt,l(2).split(" ").toInt)}

	def read7 = {
		def grp(iter:Iterator[Int]):Stream[Iterator[Int]] = 
			if(!iter.hasNext) Stream.Empty
			else iter.take(iter.next) #:: grp(iter)
		grp(read6)
	}

	def read6 = read.toInt.takeWhile(_ != -1)

	def read5 = read.map(_.split(" ").toInt.toArray).takeWhile{l=>(!(l(0)==0&&l(1)==0&&l(2)==0))}
        def read = Source.fromInputStream(System.in).getLines().takeWhile(_!=null)
        def readTail =  read.tail
        def readTailTuple2 = readTail.map(_.split(" ").toList.tuple2)
        def readTailIntTuple2 = readTail.map(_.split(" ").map(_.toInt).toList.tuple2)
	def read2 = readTailIntTuple2
	def time[R](block: => R): R = {
		    val t0 = System.nanoTime()
		    val result = block    // call-by-name
		    val t1 = System.nanoTime()
		    println("Elapsed time: " + (t1 - t0)/1000000 + "ms")
		    result
		}

        implicit class MyInt(i:Int){
		def sqrt = math.sqrt(i).toInt
	}
        implicit class MyIterator[T](iter:Iterator[T]){
                def tuple = (iter.next,iter)
                def tail = tuple._2
        }
        implicit class MyIteratorStr(iter:Iterator[String]){
		def toInt = iter.map{_.toInt}
	}
        implicit class MySeq[T](seq:Seq[T]){
                def tuple2 = (seq(0),seq(1))
        }
        implicit class MyBooleanTraversable(t:Traversable[Boolean]){
                def or = t.reduce(_||_)
        }
	implicit class MyTravsOnce[T](seq:TraversableOnce[T]){
		def printn = seq.foreach(println)
		def mprintn = seq.map{x=>println(x);x}
        }
        implicit class MySeqString(seq:Traversable[String]){
		def toInt = seq.map{_.toInt}
        }
        implicit class MyArrayStr(seq:Array[String]){
		def toInt = seq.map{_.toInt}
        }

}

Main.main(Array())
