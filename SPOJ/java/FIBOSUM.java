import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Long.parseLong;

class Main{

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = parseLong(br.readLine());
		Fib f = new Fib();
		long mod = 1000000007;
		while(N--!=0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			long A = parseLong(st.nextToken());
			long B = parseLong(st.nextToken());
			//F(A)+F(A+1)+...+F(B)
			// F(A,B) = F(A-1,B-1) + F(A-2,B-2)
			// F(0,B) = F(0,B-1) + F(0,B-2)
			long sum = (f.fibN2(B+2)-f.fibN2(A+1)+mod)%mod;
			System.out.println(sum);
		}
		br.close();
	}

}

class Fib{

	/*
	F(N) = F(N-1)+F(N-2);
	| F(N+1)  F(N) | = |F(N)   F(N-1)| |1 1| 
	| F(N)  F(N-1) |   |F(N-1) F(N-2)| |1 0|
	*/
	long A[][] = { { 1, 1 }, { 1, 0 } };
	long mod = 1000000007;
	long[][][] DP = new long[32][0][0];
	public Fib(){
		DP[1] = A;
		for(int i=2;i<32;i++)
			DP[i] = mult(DP[i-1],DP[i-1]);
	}

	long fibN2(long N){
		if(N==0) return 0;
		N--;
		long ret[][] = { { 1, 0 }, { 0, 1 } };
		int i = 1;
		while(N!=0){
			if(N%2==1) ret = mult(ret,DP[i]);
			i++;
			N=N/2;
		}
		return ret[0][0];
	}

	long fibN(long N){
		if(N==0)return 0;
		long[][] ret = A;
		for(long i=2;i<N;i++)
			ret = mult(ret,A);
		return ret[0][0];
	}

	long[][] mult(long[][] F, long[][] M)
	{
		long[][] ret = new long[2][2];
		ret[0][0] =  (F[0][0]*M[0][0] + F[0][1]*M[1][0])%mod;
		ret[0][1] =  (F[0][0]*M[0][1] + F[0][1]*M[1][1])%mod;
		ret[1][0] =  (F[1][0]*M[0][0] + F[1][1]*M[1][0])%mod;
		ret[1][1] =  (F[1][0]*M[0][1] + F[1][1]*M[1][1])%mod;
		return ret;
	}

}
