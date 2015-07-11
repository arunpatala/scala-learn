import scala.io.Source
import scala.annotation.tailrec


object Main extends App{
	import Util._
	read17.foreach{ l=>
		val a3 = l(0)
		val al_3 = l(1)
		val sum = l(2)
		val n = sum*2/(a3+al_3)
		val d = (al_3-a3)/(n-5)
		val a = a3-2*d
		print(a)
		for(i<-1L until n)
			print(" "+(a+i*d))
		println()
	}
}

object Util{
	def read17 = readTail.map{_.split(" ").map{_.toLong}}
        def read = Source.fromInputStream(System.in).getLines().takeWhile(_!=null)
        def readTail =  {read.next;read}
}

Main.main(Array())
