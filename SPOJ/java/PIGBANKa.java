import java.io.*;
import java.util.*;
import static java.lang.Math.min;
import static java.lang.Integer.parseInt;

class Main{
	static int Inf = 1000000000;



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = parseInt(br.readLine());
		for(int t=0;t<T;t++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int E = parseInt(st.nextToken());
			int F = parseInt(st.nextToken());
			int FE = F-E;
			int N = parseInt(br.readLine());
			int[] MIN = new int[FE+1];
			for(int wt=0;wt<=FE;wt++)MIN[wt]=Inf;
			MIN[0]=0;
			for(int i=0;i<N;i++)
			{
				st = new StringTokenizer(br.readLine());
				int C = parseInt(st.nextToken());
				int W = parseInt(st.nextToken());
				for(int wt=W;wt<=FE;wt++)
					if(MIN[wt]>MIN[wt-W]+C)
						MIN[wt]=MIN[wt-W]+C;
			}
			if(MIN[FE]==Inf)out.printf("This is impossible.\n");
			else out.printf("The minimum amount of money in the piggy-bank is %d.\n",MIN[FE]);
		}
		out.flush();
		out.close();
		br.close();
	}

}
