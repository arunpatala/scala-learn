import scala.io.Source
import scala.annotation.tailrec
import scala.math._


object Main extends App{
        val iter = Source.fromInputStream(System.in).getLines()
	val N = iter.next.toInt
	iter.take(N).map{_.toInt}.map{r =>
		4*pow(r,2) + 0.25
	}.zipWithIndex.map{case(d,i)=>"Case "+(i+1)+": %.2f".format(d)}.foreach(println)

}

