import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import static java.lang.Math.*;

class Main{



	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		int sqrtN = ceil(sqrt(N));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N+1];
		int[] sA = new int[sqrtN];
		int[] S = new int[N+1];
		for(int i=1;i<=N;i++) {
			A[i] = parseInt(st.nextToken());
			S[i] = S[i-1]+A[i];
		}
		for(int i=0;i<sqrtN;i++)
			for(int j=1;j<=sqrtN;j++)
				if((i*sqrtN+j)<=N)
				sA[i]+=A[i*sqrtN+j];


		int M = parseInt(br.readLine());
		while(M--!=0)
		{
			st = new StringTokenizer(br.readLine());
			int x = parseInt(st.nextToken());
			int y = parseInt(st.nextToken());
			int mx = Integer.MIN_VALUE;
			int xs = ceil(sqrt(x));
			int ys = ceil(sqrt(y));
			for(int si=xs;si<ys;si++)
				sum += sA[si];
			for(int xi=x;xi<xs*sqrtN;xi++)
				sum 
			System.out.println(mx);
		}
		out.flush();
		out.close();
		br.close();
	}

}
