import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;
import java.math.BigInteger;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = parseInt(st.nextToken());
		int M = parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for(int i=0;i<N;i++)
			A[i] = parseInt(st.nextToken());
		int sum=0,msum=0,i=0,j=0;
		while(i<N){
			if(sum+A[i]<=M){
				sum+=A[i++];
				if(msum<sum)msum=sum;
			}else{
				sum-=A[j++];
			}
		}
		System.out.println(msum);
		br.close();

	}

	public static int GCD(int a, int b){
		if(b==0) return a;
		else return GCD(b,a%b);

	}

}
