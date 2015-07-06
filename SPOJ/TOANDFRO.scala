import scala.io.Source

object Main extends App{
	import Util._
	read4.map{case (n,w)=>w.toArray
			.grouped(n.toInt)
			.zipWithIndex
			.map{case(a,i) => if(i%2==0) a else a.reverse}
			.map{_.map{_.toString}}
			.reduce{(x,y) => x.zip(y).map{case(x,y)=>x+y}}
			.mkString
		}.foreach(println)
}

object Util{

        def read = Source.fromInputStream(System.in).getLines().takeWhile(_!=null)
        def readTail =  read.tail
        def readTailTuple2 = readTail.map(_.split(" ").toList.tuple2)
        def readTailIntTuple2 = readTail.map(_.split(" ").map(_.toInt).toList.tuple2)
	def read2 = readTailIntTuple2
	def read4 = read.grouped(2).takeWhile(_.size==2).map{_.tuple2}

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
        implicit class MySeq[T](seq:Seq[T]){
                def tuple2 = (seq(0),seq(1))
        }
        implicit class MyBooleanTraversable(t:Traversable[Boolean]){
                def or = t.reduce(_||_)
        }
}

Main.main(Array())
