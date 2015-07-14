import java.io.*;
import java.util.*;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 10;
		int M = 200;
		int[] A = new int[N];
		for(int t=0;t<N;t++)
			A[t] = parseInt(br.readLine());
		boolean[][] Z = new boolean[N][M+1];
		Z[0][0] = true;
		Z[0][A[0]]=true;
		for(int n=1;n<N;n++)
		{
			Z[n][0] = true;
			for(int m=1;m<=M;m++)
			{
				Z[n][m]=Z[n-1][m];
				if(m-A[n]>=0)
					Z[n][m] = Z[n][m] || Z[n-1][m-A[n]]; 
				//if(Z[n][m])System.out.print(n+","+m+" ");
			}
			//System.out.println();
		}
		int ret = 0;
		for(int m=0;m<=M;m++)
			if(Z[N-1][m])
				if(abs(100-ret)>abs(100-m))ret=m;
		System.out.println(ret);
		br.close();
	}

}
