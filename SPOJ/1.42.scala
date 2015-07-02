import scala.io.Source
object Main extends App {
		Source.fromInputStream(System.in).getLines().takeWhile(_!="42").foreach(println)	
}

Main.main(Array())
