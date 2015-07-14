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
			StringTokenizer st = new StringTokenizer(br.readLine());
			int budget = parseInt(st.nextToken());
			int num = parseInt(st.nextToken());
			if(num==0 && budget==0)break;
			int[] francs = new int[num];
			int[] fun = new int[num];
			for(int i=0;i<num;i++){
				st = new StringTokenizer(br.readLine());
				francs[i] = parseInt(st.nextToken());
				fun[i] = parseInt(st.nextToken());
			}
			int[][] funCost = new int[num][budget+1];
			for(int b=0;b<=budget;b++)
				if(b>=francs[0])
					funCost[0][b] = fun[0];
			for(int p=1;p<num;p++)
			{
				for(int b=0;b<=budget;b++)
				{
					if(b>=francs[p])
						funCost[p][b] = fun[p] + funCost[p-1][b-francs[p]];
					funCost[p][b] = max(funCost[p][b], funCost[p-1][b]);
					//System.out.print(funCost[p][b]+" ");
				}
				//System.out.println();
			}
			int ci = budget;
			while(funCost[num-1][budget]==funCost[num-1][ci])ci--;
			out.printf("%d %d\n",ci+1,funCost[num-1][ci+1]);

			br.readLine();
		}
		out.flush();
		out.close();
		br.close();
	}

}
