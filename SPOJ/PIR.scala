import scala.io.Source
import scala.annotation.tailrec
import scala.math.max
import scala.annotation.tailrec



object Main extends App{
	import Util._
	val l = readTail.toInt.toList
	val n = l.size
	//val lsum = l.scanLeft(0){ case (sum,li) => sum+li }.tail
	val Z = Array.ofDim[Int](n,n)
	val S = Array.ofDim[Int](n,n)
	for(i<-0 until n){ Z(i)(i) = l(i);S(i)(i) = l(i);}
	for(len<-2 to n;i<-0 to n-len){
		val j = i+len-1;
		S(i)(j) = S(i)(j-1)+l(j)
		Z(i)(j) = S(i)(j) + math.max(Z(i)(j-1),Z(i+1)(j))
	}
	println(Z(0)(n-1))
}

object Util{


	def read21 = readIter(readTail)

	def readIter(read:Iterator[String]):Stream[List[String]] = if(read.isEmpty) Stream.Empty
						else read.next.sInt.toList.tuple2 match{ case(n,m) =>
								read.take(n).toList #:: readIter(read)
						}

	def read18 = readTail.grouped(2).map(_(1))
	def read17 = readTail.map{_.sInt.toList.tuple2}.toList
	def read16 = read.map{_.sInt.toList.tuple2}.toList

	def read15 = read11.grouped(2).map(_(1).sInt)

	def round(d:Double) = BigDecimal(d).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
	def read13 = read.takeWhile(_!="0").toInt
	def read12 = readTail.grouped(4).map(l=>(l(2).sInt,l(3).sInt))
	def read11 = read.takeWhile(_!="0")
	def read10 = readTail.toInt
	def read9 = read.takeWhile(_!="0").grouped(2).map(_(1).split(" ").map{_.toInt})
	def read8 = read.map{_.toDouble}.takeWhile(_!=0)
	def read7 = {
		def grp[T](iter:Iterator[T]):Stream[List[T]] = 
			if(!iter.hasNext) Stream.Empty
			else iter.takeWhile(_!="").toList #:: grp(iter)
		grp(readTail.tail)
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
