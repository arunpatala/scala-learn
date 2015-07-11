import scala.io.Source
import scala.annotation.tailrec
import scala.math._


object Main extends App{
	import Util._
	readTail.map{ s =>
		val n = s.size
		val mid = n/2
		var change = -1
		for(a<-mid until n;if(change== -1)){
			if(s(a)<s(n-1-a))change=a
			else if(s(a)>s(n-1-a)) change=mid
		}
		if(change== -1) change = mid
		(change,s(change))
		if(change==mid&&n%2==0&&s(mid)>=s(mid-1)) change=mid-1
		val bi = BigInt(s)+BigInt("1"+("0"*(n-1-change)))
		val res = bi.toString
		if(res.size%2==0)
			res.slice(0,(res.size/2)) + res.slice(0,(res.size/2)).reverse 
		else 
			res.slice(0,1+(res.size/2)) + res.slice(0,(res.size/2)).reverse 
	}.printn
}

object Util{

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



}

Main.main(Array())
