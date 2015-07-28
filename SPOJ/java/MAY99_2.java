import java.io.*;
import java.util.*;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

class Main{

	public static char[] A = {'m','a','n','k','u'};

	public static String solve(long N){
		if(N==0) return "";
		double P = log((N*4.0/5)+1)/log(5);
		int i = (int)(P);
		long l = 5*((long)(pow(5,i))-1)/4;
		int idx = (int)((N-l)/l);
		System.out.println(N+","+i+","+l+","+idx);
		return A[idx-1]+solve((N-l-1)%l+1);
	}


	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = parseInt(br.readLine());
		for(int t=0;t<T;t++)
		{
			long N = parseLong(br.readLine());
			System.out.println(solve(N));
		}
		out.flush();
		out.close();
		br.close();
	}

}
