import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= parseInt(br.readLine());
		int n = N;
		int[] A = new int[N];
		for(int i=0;i<N;i++)
			A[i] = parseInt(br.readLine());
		int[][] S = new int[N][N];
		int[][] Z = new int[N][N];
		for(int i=0;i<n;i++){
			Z[i][i] = A[i];
			S[i][i] = A[i];
		}
		for(int len=2;len<=n;len++)
			for(int i=0;i<=n-len;i++)
		{
			int j = i+len-1;
			S[i][j] = S[i][j-1]+A[j];
			Z[i][j] = S[i][j] + max(Z[i][j-1],Z[i+1][j]);
		}
		System.out.println(Z[0][n-1]);

		br.close();
	}

}
