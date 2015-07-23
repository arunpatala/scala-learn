import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = br.readLine();
			if(s==null) break;
			int N = parseInt(s);
			int[] A = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
				A[i] = parseInt(st.nextToken());
			int[][] DP = new int[N][N];
			int[][] C = new int[N][N];
			for(int i=0;i<N;i++){
				DP[i][i]=0;
				C[i][i] = A[i];
			}
			for(int l=2;l<=N;l++)
				for(int i=0;i+l-1<N;i++)
				{
					int j = i+l-1;
					DP[i][j]=Integer.MAX_VALUE;
					for(int k=i;k<j;k++)
					{
						int dp = DP[i][k]+DP[k+1][j]+(C[i][k]*C[k+1][j]);
						if(dp<DP[i][j]){
							DP[i][j] = dp;
							C[i][j] = (C[i][k]+C[k+1][j])%100;
						}
					}
				}
			System.out.println(DP[0][N-1]);
		}
		
		br.close();
	}

}
