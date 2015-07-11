import scala.io.Source
import scala.annotation.tailrec
import scala.math.min


object Main extends App{
        val iter = Source.fromInputStream(System.in).getLines().takeWhile(_!=null)
	val N = iter.next.toInt
	val ABCD  = iter.take(N).toList.map(_.split(" ").map(_.toInt).toList)
	val A = ABCD.map(_(0))
	val B = ABCD.map(_(1))
	val C = ABCD.map(_(2))
	val D = ABCD.map(_(3))
	val AB = A.flatMap(a=>B.map(a+_)).toList.sorted.reverse
	val CD = C.flatMap(c=>D.map(c+_)).toList.sorted
	//println(AB.size+CD.size)
	println(merge(AB,CD))

	def merge(AB:List[Int],CD:List[Int]):Int = if(AB.isEmpty||CD.isEmpty) 0
		else{
			val sum = AB.head+CD.head;
			if(sum<0)merge(AB,CD.tail)
			else if(sum>0)merge(AB.tail,CD)
			else{
				val i = AB.takeWhile(_==AB.head).size
				val j = CD.takeWhile(_==CD.head).size
				(i*j)+ merge(AB.dropWhile(_==AB.head),CD.dropWhile(_==CD.head))
			}
		}

}
Main.main(Array())
