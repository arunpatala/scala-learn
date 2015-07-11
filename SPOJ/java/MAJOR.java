import java.io.*;
import java.util.*;
import static java.lang.Math.min;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = parseInt(br.readLine());
		while(t--!=0)
		{
			int[] C = new int[2001];
			int N = parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ret = -1;
			for(int i=0;i<N;i++)
			{
				int j = parseInt(st.nextToken());
				C[j]++;
				if(C[j]>N/2) ret = j;
			}
			if(ret==-1)
				out.printf("NO\n");
			else out.printf("YES %d\n",ret);

		}
		out.flush();
		out.close();
		br.close();
	}

}
