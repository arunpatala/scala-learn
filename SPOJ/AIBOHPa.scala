import scala.io.Source
import scala.annotation.tailrec
import scala.math.min
import java.io._



object Main extends App{
	
	def palin(S:String) = {
		val N = S.size
		val Z = Array.ofDim[Int](N+2,N+2) 
		for(l<-1 to N;i<-1 to N-l+1)
		{
			val j = i+l-1
			Z(i)(j) = if(S(i-1)==S(j-1))  Z(i+1)(j-1)
					else 1+min(Z(i+1)(j),Z(i)(j-1))
		}
		Z(1)(N)
	}

	val br = new BufferedReader(new InputStreamReader(System.in));	 
	val t = br.readLine().toInt;
	for(i <- 1 to t){
		System.out.println(palin(br.readLine))
	}

}

Main.main(Array())
