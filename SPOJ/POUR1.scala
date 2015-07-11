import scala.io.Source

object Main extends App{
	import Util._
	val k;
	var i = 0;
	var j = 0;
	if(A(i)+K==A(j)){
		
	}else if(A(i)+K<A(j)) j++
	else i++


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
