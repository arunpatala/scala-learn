import scala.io.Source
import scala.annotation.tailrec
import scala.math.max



object Main extends App{

	def nCm(n:Int, m:Int):Long =  
	    if(m>n-m) nCm(n,n-m)
		else
		{
		    var ans=1L;
		    for(i<-0 until m) ans=ans*(n-i)/(i+1);
		    ans;
		}

	def read = Source.fromInputStream(System.in).getLines().takeWhile(_!=null)
	val N = read.next.toInt
	read.take(N).map(_.split(" ").map(_.toInt)).map{ l=>
		val N = l(0)
		val K = l(1)
		nCm(N-1,K-1)
	}.foreach(println)
	
}

Main.main(Array())
