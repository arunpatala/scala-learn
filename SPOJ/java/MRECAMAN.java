import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 500000;
		//int N = 50;
		int[] A = compute(N);
		while(true){
			int K = parseInt(br.readLine());
			if(K==-1)break;
			System.out.println(A[K]);
		}
	}

	public static int[] compute(int N)
	{
		int[] A = new int[N+1];
		boolean[] B = new boolean[10*N+1];
		B[0]=true;
		for(int i=1;i<=N;i++)
		{
			int ai = A[i-1]-i;
			if(ai>0 && !B[ai])
				A[i] = ai;
			else A[i] = A[i-1]+i;
			B[A[i]]=true;
			//System.out.println(i+","+A[i]);
		}
		return A;
		
	}
}
