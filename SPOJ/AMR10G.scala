import scala.io.Source
import scala.annotation.tailrec
import scala.math.max



object Main extends App{
        val iter = Source.fromInputStream(System.in).getLines()
	val T = iter.next.toInt
	iter.take(2*T).grouped(2).map{ l=>
		val K = l(0).split(" ")(1).toInt
		val LST = l(1).split(" ").map(_.toInt).toList.sorted
		val N = LST.size
		LST.zip(LST.takeRight(N-K+1)).map{case(x,y) => y-x}.min
		//(K,LST)
	}.foreach(println)
}
Main.main(Array())
