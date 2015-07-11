import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = parseInt(br.readLine());
		int s = 1;
		while(t--!=0)
		{
			int N = parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(N==0){
				out.printf("Case %d: %d\n",s++,0);
				continue;
			}
			int[] A = new int[N+1];
			for(int i=1;i<=N;i++)
				A[i] = parseInt(st.nextToken());
			long[] Z = new long[N+1];
			Z[1]=A[1];
			for(int i=2;i<=N;i++)
				Z[i] = max(Z[i-1],A[i]+Z[i-2]);
			out.printf("Case %d: %d\n",s++,Z[N]);

		}
		out.flush();
		out.close();
		br.close();
	}

}
