import scala.io.Source

object Main extends App{
	val index:Array[Double] = Stream.from(2)
			.scanLeft(0.0){(v,i)=>v+(1/i.toDouble)}
			.take(300).toArray

        Source.fromInputStream(System.in).getLines().takeWhile(_!="0.00")
	.map{ d =>
		(-1-java.util.Arrays.binarySearch(index,d.toDouble))+" cards(s)"
	}.foreach(println)
}
Main.main(Array())
