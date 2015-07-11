import scala.io.Source
import scala.annotation.tailrec
import scala.math.max



object Main extends App{
        val iter = Source.fromInputStream(System.in).getLines()
	val N = iter.next.toInt
	def check(l:Long) = (0 to math.sqrt(l).toLong).map{i=>
					val j = math.sqrt(l-i*i); 
					j.toLong==j
				}.find(_==true)!=None
	iter.map(_.toLong).map{x=>if(check(x)) "Yes" else "No"}.foreach(println)
}
Main.main(Array())
