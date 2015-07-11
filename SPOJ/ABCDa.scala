import scala.io.Source
import scala.annotation.tailrec
import scala.math.max



object Main extends App{

	def diff(a:Char,b:Char,c:Char):Char = List('A','B','C','D').find(d=>d!=a&&d!=b&&d!=c).get
	val N = readLine().toInt
	val S = readLine()
	val O = Array.ofDim[Char](2*N)
	var p = 'A'
	for(i<- 0 until N)
	{
		p = diff(p,S(2*i),S(2*i+1))
		O(2*i) = p
		p = diff(p,S(2*i),S(2*i+1))
		O(2*i+1) = p
	}
	println(O.mkString)


}

Main.main(Array())
