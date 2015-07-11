import scala.io.Source
import scala.annotation.tailrec
import scala.math.max


object Main extends App{
	import Util._
	readUntil("-1".make(8).mkString(" ")).map{_.sInt}.map{ l=>
		val maxCakes = {
				for(i<- 0 until 4)
					(l(i).toDouble/l(i+4)).ciel
				}.max
		l.sublist(4,7).map(_*maxCakes).zip(l.sublist(0,3)).map{
			case(x,y) => y - x
		}.mkString(" ")
	}.printn

}

object Util{

	def read0 = readIter(readUntil("0"))

	def readIter(read:Iterator[String]):Stream[List[String]] = if(read.isEmpty) Stream.Empty
						else read.next.toInt match{ case n  =>
								read.take(n).toList #:: readIter(read)
						}
	def readUntil(str:String) = read.takeWhile(_!=str)

        def read = Source.fromInputStream(System.in).getLines().takeWhile(_!=null)
        def readTail =  read.tail

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
