import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			if(N==0) break;
			int[] A = new int[N+1];
			int[][] DP = new int[N+1][N+1];
			int sum = 0;
			for(int i=1;i<=N;i++)
			{
				A[i] = parseInt(st.nextToken());
				sum += A[i];
			}
			for(int i=0;i<N;i++)
				DP[i][i]=A[i];
			for(int l=2;l<=N;l++)
				for(int i=1;i+l-1<=N;i++)
				{
					int j=i+l-1;
					int a = 0;
					if(A[i+1]>A[j]) a = DP[i+2][j];
					else a = DP[i+1][j-1];
					int b = 0;
					if(A[i]>A[j-1]) b = DP[i+1][j-1];
					else b = DP[i][j-2];
					DP[i][j] = max(a+A[i],b+A[j]);
				}
			System.out.println(sum-DP[1][N]);
		}
	}

}
