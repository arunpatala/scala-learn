import scala.io.Source
import scala.annotation.tailrec
import scala.math.max
import scala.math.BigInt



object Main extends App{
	val iter = Source.fromInputStream(System.in).getLines()
	val N = iter.next.toInt
	@tailrec def gcd(a:Int,b:Int):Int = {
		if(b==0) a
		else gcd(b,a%b)
	}
	iter.take(N).map{_.split(" ")}.map{ case l  =>
		val a = l(0).toInt
		val b = BigInt(l(1))
		if(a==0) b
		else if(b==0) a
		else gcd(a,(b%a).toInt)
	}.foreach(println)

}
Main.main(Array());
