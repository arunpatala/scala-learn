import scala.io.Source
import scala.annotation.tailrec
import scala.math.max



object Main extends App{
	import Util._

	@tailrec def check(l:List[Int], k:Int, d:Int):Boolean = if(k==0) true
		else check(l.tail.right(_>l.head+d),k-1,d)

	@tailrec def binsearch(l:List[Int], k:Int, min:Int, max:Int):Int = if(min>=max) min
		else {
			val mid = (min+max)/2
			val valid = binsearch(l,k,mid)
			if(valid) binsearch(l,k,mid,max)
			else binsearch(l,k,min,mid-1)
		}

	read21.map{ case (head :: tail) => binsearch(tail,head)

	}.println

}

object Util{


	def read21 = readIter(readTail)

	def readIter(read:Iterator[String]):Stream[List[Int]] = if(read.isEmpty) Stream.Empty
						else read.next.sInt.toList.tuple2 match{ case(n,m) =>
								(m::read.take(n).toList.toInt.toList) #:: readIter(read)
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
