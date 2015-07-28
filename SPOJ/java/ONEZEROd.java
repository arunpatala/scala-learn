import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Math.pow;

class Main{


	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Long> L = new LinkedList<>();
		List<Long> BFS = new LinkedList<>();
		BFS.add(1L);
		while(true){
			long l = BFS.remove(0);
			//System.out.println(l);
			if(l>(1L<<62))break;
			//if(l>1000000)break;
			L.add(l);
			BFS.add(l*10);
			BFS.add(l*10+1);
		}
		//System.out.println(L.size());

		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			long A = parseLong(br.readLine());
			for(long l:L)
			{
				if(l>=A&&l%A==0){
					System.out.println(l);
					break;
				}
			}
		}
		br.close();
	}

}

