import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			int N = parseInt(br.readLine());
			if(N==0)break;
			boolean valid = true;
			int[] V = new int[N];
			for(int i=0;i<N;i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int A = parseInt(st.nextToken());
				int B = parseInt(st.nextToken());
				int idx = i+B;
				if(idx<0||idx>=N||V[idx]!=0)valid=false;
				else V[idx]=A;
			}
			if(valid)
			{
				for(int i=0;i<N;i++)
					out.printf("%d ",V[i]);
				out.printf("\n");
			}
			else out.printf("-1\n");
		}
		out.flush();
		out.close();
		br.close();
	}
}

