import scala.io.Source

object Main extends App{
	val i = readLine().toInt;
	if(i%10==1) println("2")
	else {
		println("1")
		println(i%10-1)
	}
}

Main.main(Array())
