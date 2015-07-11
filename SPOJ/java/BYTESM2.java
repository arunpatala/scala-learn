import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = parseInt(br.readLine());
		while(t--!=0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = parseInt(st.nextToken());
			int m = parseInt(st.nextToken());
			int[][] B = new int[2][m+2];
			int ret = 0;
			for(int i=0;i<n;i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=1;j<=m;j++)
				{
					int aij = parseInt(st.nextToken());
					B[i%2][j] = aij+max(B[(i+1)%2][j-1],max(B[(i+1)%2][j],B[(i+1)%2][j+1]));
					ret = max(ret,B[i%2][j]);
				}
			}
			out.printf("%d\n",ret);
		}
		out.flush();
		out.close();
		br.close();
	}

}

