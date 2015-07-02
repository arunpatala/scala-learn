import scala.io.Source

object Main extends App{
	import Util._
	read.map("OUT:"+_).foreach(println)

}

object Util{

	def read = Source.fromInputStream(System.in).getLines().takeWhile(_!=null)
}

Main.main(Array())
