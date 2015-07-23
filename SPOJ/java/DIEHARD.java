import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = parseInt(st.nextToken();
			int A = parseInt(st.nextToken();
			int[][][] DP = new int[H][A][3];
			
			DP[h][a][0] = max(DP[h-3][a+2][1] , DP[h-3][a+2][2]);
			DP[h][a][1] = max(DP[h-5][a-10][2] , DP[h-5][a-10][0]);
			DP[h][a][2] = max(DP[h-20][a+5][0] , DP[h-20][a+5][1]);
		}
	}

	public static boolean play(int K, int L, int N)
	{
		if(N<K) return N%2==1;
		else if(N<L) 
		
	}
}
