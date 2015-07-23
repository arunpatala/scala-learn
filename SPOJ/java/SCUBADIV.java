import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	static int Inf = 1001 * 801;

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Z = parseInt(br.readLine());
		while(Z--!=0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = parseInt(st.nextToken();
			int A = parseInt(st.nextToken();
			int N = parseInt(br.readLine());
			int[][] DP = new int[T+1][A+1];
			for(int ti=0;ti<=T;ti++)
				for(int ai=0;ai<=A;ai++)
					DP[ti][ai]=Inf;
			DP[0][0]=0;
			for(int n=0;n<N;n++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int t = parseInt(st.nextToken();
				int a = parseInt(st.nextToken();
				int w = parseInt(st.nextToken();
				for(int ti=t;ti<=T;ti++)
					for(int ai=a;ai<=A;ai++)
						DP[ti][ai] = min(DP[ti][ai],DP[ti-t][ai-a]+w);
			}
		}
	}
}
