import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] DP = solve();
		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int C = parseInt(st.nextToken());
			int N = parseInt(st.nextToken());
			System.out.println(C+" "+DP[N]);
		}
	}

	public static long[] solve(){
		int N = 64;
		long[][] DP = new long[N+1][10];
		for(int i=0;i<=9;i++)DP[1][i]=1;
		for(int n=2;n<=N;n++)
			for(int j=0;j<=9;j++)
				for(int i=j;i<=9;i++)
				{
					DP[n][j]+=DP[n-1][i];
				}
		long[] ret = new long[N+1];
		for(int i=1;i<=N;i++)
			for(int j=0;j<=9;j++)
				ret[i] += DP[i][j];
		return ret;
	}

}
