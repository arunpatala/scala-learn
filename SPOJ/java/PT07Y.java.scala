import java.io._;
import java.util.StringTokenizer;
import java.lang.Integer;

object Main extends App{

		val br = new BufferedReader(new InputStreamReader(System.in));
		val st = new StringTokenizer(br.readLine());
		val N = Integer.parseInt(st.nextToken());
		val M = Integer.parseInt(st.nextToken());
		val E = Array.fill(N+1)(List[Int]());
		for(i<-0 until M)
		{
			val st1 = new StringTokenizer(br.readLine());		
			val v1=Integer.parseInt(st1.nextToken());
			val v2=Integer.parseInt(st1.nextToken());
			E(v1)=v2::E(v1);
			E(v2)=v1::E(v2);
		}
		val visited = Array.ofDim[Boolean](N+1);
		var valid = true;
		for(i<-1 to N;//1;i<=N&&valid;i++)
			if(!visited(i)))
				valid=DFS(i,-1)
		if(valid) println("YES");
		else  println("NO");

	def DFS(i:Int, p:Int):Boolean = {
		visited(i) = true;
		for(j <- E(i))
			if(j!=p){
				if(visited(j)) return false;
				if(!DFS(j,i)) return false;
			}
		return true;
	}


}

Main.main(Array())
