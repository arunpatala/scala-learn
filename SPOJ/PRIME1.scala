import scala.io.Source

object Main extends App{
	import Util._
	val N = 10000
	def primes(n:Int) = (3 to n).foldLeft(Vector(2))((s,i)=>if(s.find(i%_==0)==None) s++Vector(i) else s)
	val ps =  primes(N).toSet 
	def isPrime(i:Int) = 	if(i==1) false
				else if(i==2||i==3) true
				else if(i<=N) ps.contains(i)
				else if(ps.find(i%_==0)!=None) false
				else (N+1 to i.sqrt).map(i%_==0).find(_==true)!=None

	read2.map{case(i,j)=> (i to j).filter(isPrime).toList}
		.foreach{x=>x.foreach(println);println}

}

object Util{

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
        implicit class MySeq[T](seq:Seq[T]){
                def tuple2 = (seq(0),seq(1))
        }
        implicit class MyBooleanTraversable(t:Traversable[Boolean]){
                def or = t.reduce(_||_)
        }
}

Main.main(Array())
