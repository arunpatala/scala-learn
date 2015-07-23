import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		for(int t=0;t<T;t++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Integer> A = new LinkedList<>();
			while(st.hasMoreTokens())
				A.add(parseInt(st.nextToken()));
			int[] AA = toArray(A);
			int max = 1;
			while(true)
			{
				st = new StringTokenizer(br.readLine());
				List<Integer> B = new LinkedList<>();
				while(st.hasMoreTokens())
					B.add(parseInt(st.nextToken()));
				if(B.size()==1)break;
				int res = LCS(AA,toArray(B));
				if(max<res)max=res;
			}
			System.out.println(max-1);
		}
	}

	public static int[] toArray(List<Integer> lst)
	{
		int[] ret = new int[lst.size()];
		for(int i=0;i<lst.size();i++)ret[i]=lst.get(i);
		return ret;
	}

	public static int LCS(int[] A, int[] B)
	{
		int N = A.length;
		int M = B.length;
		int[][] DP = new int[N+1][M+1];
		for(int i=1;i<=N;i++)
			for(int j=1;j<=M;j++)
			{
				if(A[i-1]==B[j-1])
					DP[i][j] = max(DP[i][j],DP[i-1][j-1]+1);
				else DP[i][j]=max(DP[i-1][j],DP[i][j-1]);
			}
		return DP[N][M];
	}
}
