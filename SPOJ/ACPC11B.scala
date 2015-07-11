import scala.io.Source
import scala.annotation.tailrec
import scala.math.max



object Main extends App{
        val iter = Source.fromInputStream(System.in).getLines().takeWhile(_!=null)
	val T = iter.next.toInt
	iter.grouped(2).take(T).map{ l =>
		(l(0).split(" ").map(_.toInt).tail.toList,l(1).split(" ").map(_.toInt).tail.toList)
	}.map{	case(a,b) =>
		val lst = a.map{ai=>(ai,"A")} ++ b.map{bi=>(bi,"B")}
		lst.sortBy(_._1).sliding(2).map(l=>(l(0),l(1))).map{case ((xi,xl),(yi,yl)) => 
			if(xl==yl) Int.MaxValue else yi-xi
			}.min
	}.foreach(println)
}
Main.main(Array())
