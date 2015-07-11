import scala.io.Source
import scala.annotation.tailrec
import scala.math.max
import scala.annotation.tailrec



object Main extends App{
	val mem = Array.ofDim[Int](800);
	def break(n:Int):Int = n.toString.map(_-'0').map(x=>x*x).sum

	def memoize(n:Int):Int = if(n==1) 0 
				else if(mem(n)!=0) mem(n)
			     else{
					mem(n) = -1
					mem(n) = memoize(break(n))+1
					mem(n)
			     }
	println(1+memoize(break(readLine().toInt)))
}
Main.main(Array())
