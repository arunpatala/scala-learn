import scala.io.Source

object Main extends App{
	import Util._
	val N = 32000
	val primes = Array.fill(N+1)(true)
	primes(1) = false
	for(i<- 2 to N; if(primes(i)))
		for(j<- 2*i to N by i)
			primes(j) = false

	val prime = primes.zipWithIndex.filter(_._1).map(_._2).tail.toList
	
	def primesN(i:Int,j:Int) = {
		val pij = Array.fill(j-i+1)(true)
		for(p<-prime)
			for(pj <- p*((i.toDouble/p).ceil.toInt) to j by p; if(pj!=p))
			{	
				//println(p,pj)
				pij(pj-i) = false
			}
		pij.zipWithIndex.filter(_._1).map(_._2+i).filter(_!=1).toList
	}
	read2.foreach{ case(i,j)=> primesN(i,j).foreach(println);println }
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
