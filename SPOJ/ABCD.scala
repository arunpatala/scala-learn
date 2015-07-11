import scala.io.Source
import scala.annotation.tailrec
import scala.math.max



object Main extends App{
	import Util._

	def diff(a:Char,b:Char,c:Char):Char = List('A','B','C','D').find(d=>d!=a&&d!=b&&d!=c).get
	readTail.map{
		s =>
			s.grouped(2).scanLeft(List('A','B')){ case(p,c) => 
				val a = diff(p(1),c(0),c(1)); 
				val b = diff(a,c(0),c(1)); 
				List(a,b)
			}.tail.flatten.mkString
	}.printn


}

object Util{


	def read21 = readIter(readTail)

	def readIter(read:Iterator[String]):Stream[List[String]] = if(read.isEmpty) Stream.Empty
						else read.next.sInt.toList.tuple2 match{ case(n,m) =>
								read.take(n).toList #:: readIter(read)
						}
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

        implicit class MyString(s:String){
		def sInt = s.split(" ").toInt
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
	def memoize[A,B](f:(A=>B)):(A=>B) = {
		val map = scala.collection.mutable.Map[A,B]()
		def fret(a:A) = {
			if(!map.contains(a)) map(a) = f(a)
			map(a)
		}
		fret
	}
	def memoize2[A,B](f:(A=>B),b:B):(A=>B) = {
		val map = scala.collection.mutable.Map[A,B]()
		def fret(a:A) = {
			println(a)
			if(!map.contains(a)) {
				map(a) = b
				map(a) = f(a)
			}
			map(a)
		}
		fret
	}




}

Main.main(Array())
