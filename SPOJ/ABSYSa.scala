import scala.io.Source

object Main extends App{
	import Util._
	readTail.grouped(2).map(_(1)).map{ s =>
		val b = s.split(" ").filter(_!="").toArray			
		if(b(0).contains("machula")) b(0) = (b(4).toInt-b(2).toInt).toString
		else if(b(2).contains("machula")) b(2) = (b(4).toInt-b(0).toInt).toString
		else if(b(4).contains("machula")) b(4) = (b(2).toInt+b(0).toInt).toString
		b.mkString(" ")
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
