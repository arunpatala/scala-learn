import scala.io.Source

object Main extends App{
	//(1 to 100).map(sol).zipWithIndex.map{case(n,i)=>(n,1+i-(n*(n-1))/2)}.map{case(x,y) => (x-y+1,y)}
	import Util._
	def sol(c:Int)= (0.5*(math.sqrt(1+8*c)-1)).ceil.toInt
	def nn(n:Int) = (n*(n+1)/2)
	def calc(i:Int) = { val n = sol(i); val ii = i-nn(n-1);
				if(n%2!=0) (n-ii+1,ii) else (ii,n-ii+1) }
	//(1 to 100).map{calc}.printn
	read10.map(i=>(i,calc(i))).map{
		case(i,(x,y)) => "TERM "+i+" IS "+x+"/"+y	
	}.printn
}

object Util{

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
