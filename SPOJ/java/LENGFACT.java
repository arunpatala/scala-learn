import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;
import java.math.BigInteger;

class Main{

	public static void main(String[] args) throws IOException{	
		int N = 500000000;
		BigInteger[] bi = new BigInteger[N+1];
		bi[0] = new BigInteger("0");
		bi[1] = new BigInteger("1");
		for(int i=2;i<=N;i++)
			bi[i]=bi[i-1].multiply(new BigInteger(i+""));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			int M = Integer.parseInt(br.readLine());
			System.out.println(bi[M].toString().length());
		}
		br.close();
	}

}
