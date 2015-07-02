import scala.io.Source

object Main extends App{
	import Util._

	def parse(s:String):(Tree,String) = s.head match {
			case '(' => val (t,s1) = parse(s.tail); 
					val (t2,s2) = parse(s1.tail)
					(Node(s1.head,t,t2),s2.tail)
			case _ => (Leaf(s.head),s.tail)
	}
	readTail.map{parse}.map{_._1}.foreach(println)
}
class Tree
case class Node(op:Char,left:Tree,right:Tree) extends Tree
{
	override def toString = left+""+right+""+op
}
case class Leaf(name:Char) extends Tree
{
	override def toString = name+""
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
	implicit class MyString(s:String){
		def wolast = s.substring(0,s.size-1)
        }

}

Main.main(Array())
