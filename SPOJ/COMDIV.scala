import scala.io.Source
import scala.annotation.tailrec
import scala.math.min


object Main extends App{
        val iter = Source.fromInputStream(System.in).getLines().takeWhile(_!=null)
	val N = iter.next.toInt
val M = 1000
	val primes = (3 to M).foldLeft(Vector(2))((s,i)=>if(s.find(i%_==0)==None) s:+i else s)

	println(primes);

	def common(a:Int, b:Int) = {
		val f = for(p<-primes;if(a%p==0&&b%p==0))
				yield (p,math.min(div(a,p),div(b,p)))
		//f.filter(_._2!=0).foreach(println)
		f.filter(_._2!=0).map(_._2+1).reduce(_*_)
	}
	def div(n:Int,p:Int):Int = if(n%p==0) 1+div(n/p,p)
					else 0
	iter.take(N).map(_.split(" ")).map{ l=>
		common(l(0).toInt,l(1).toInt)
	}.foreach(println)
	

}
Main.main(Array())
