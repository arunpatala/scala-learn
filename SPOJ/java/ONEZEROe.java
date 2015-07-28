import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Math.pow;
import java.math.BigInteger;

class Main{


	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<BigInteger> L = new LinkedList<>();
		List<BigInteger> BFS = new LinkedList<>();
		BFS.add(new BigInteger("1"));
		while(true){
			BigInteger l = BFS.remove(0);
			//System.out.println(l);
			//if(l>(1L<<62))break;
			if(L.size()>10000000)break;
			//if(l>1000000)break;
			L.add(l);
			BFS.add(l.multiply(new BigInteger("10")));
			BFS.add(l.multiply(new BigInteger("10")).add(BigInteger.ONE));
		}
		//System.out.println(L.size());

		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			BigInteger A = new BigInteger(br.readLine());
			for(BigInteger l:L)
			{
				if(l.compareTo(A)>=0 && l.mod(A).intValue()==0){
					System.out.println(l);
					break;
				}
			}
		}
		br.close();
	}

}

