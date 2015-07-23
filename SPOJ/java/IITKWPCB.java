import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import java.math.BigInteger;

class Main{

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		for(int t=0;t<T;t++){
			long N = parseLong(br.readLine());
			if(N==1)System.out.println(0);
			for(long i=N/2;i>=1;i--)
				if(GCD(i,N)==1)
				{
					System.out.println(i);
					break;
				}
		}
	}

	public static long GCD(long a, long b){
		if(b==0) return a;
		else return GCD(b,a%b);

	}

}
