import java.io.*;
import java.util.*;
import static java.lang.Math.min;
import static java.lang.Integer.parseInt;

class Main{



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
			int[] C = new int[N];
			int[] W = new int[N];
			for(int i=0;i<N;i++){
				st = new StringTokenizer(br.readLine());
				C[i] = parseInt(st.nextToken());
				W[i] = parseInt(st.nextToken());
			}
			int[][] MIN = new int[N][FE+1];
			for(int wt=1;wt<=FE;wt++)
			{
				if(wt>=W[0])
					if(wt-W[0]==0 || MIN[0][wt-W[0]]>0)
						MIN[0][wt]=MIN[0][wt-W[0]]+C[0];
				//System.out.print(MIN[0][wt]+" ");
			}
			//System.out.println();
			for(int i=1;i<N;i++)
			{
				for(int wt=1;wt<=FE;wt++)
				{
					if(wt>=W[i])
						if(wt-W[i]==0 || MIN[i][wt-W[i]]!=0)
							MIN[i][wt] = min(MIN[i][wt-W[i]]+C[i],MIN[i-1][wt]);
						else MIN[i][wt] = MIN[i-1][wt];
					//System.out.print(MIN[i][wt]+" ");
				}
				//System.out.println();
			}
			if(MIN[N-1][FE]==0)out.printf("This is impossible.\n");
			else out.printf("The minimum amount of money in the piggy-bank is %d.\n",MIN[N-1][FE]);
		}
		out.flush();
		out.close();
		br.close();
	}

}
