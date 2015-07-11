import scala.io.Source

object Main extends App{
	import Util._
	readIter(readTail).map{ l => 
		def neigh(i:Int,j:Int) = List((i-1,j),(i+1,j),(i,j-1),(i,j+1)).filter{case(i,j) => l(i)(j)!='#'}

		def DFS((i,j):Pt,(pi,pj):Pt) = neigh(i,j).filter{_!=(pi,pj)}.foreach{DFS(_,(i,j))}


	}
}

object Util{

	def readUntil(str:String) = read.takeWhile(_!=str)
        def read = Source.fromInputStream(System.in).getLines().takeWhile(_!=null)
        def readTail =  read.tail
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
        implicit class MySeq[T](seq:Seq[T]){
                def tuple2 = (seq(0),seq(1))
        }
        implicit class MyBooleanTraversable(t:Traversable[Boolean]){
                def or = t.reduce(_||_)
        }
}

Main.main(Array())
