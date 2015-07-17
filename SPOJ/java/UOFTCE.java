import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;

class Main{

	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			int M = parseInt(st.nextToken());
			char[][] GRID = new char[N][M];
			for(int i=0;i<N;i++)
				GRID[i] = br.readLine().toCharArray();
			int ci=0,cj=0;
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
					if(GRID[i][j]=='C')
					{
						ci=i;
						cj=j;
					}
			List<Integer> x = new LinkedList<Integer>();
			List<Integer> y = new LinkedList<Integer>();
			x.add(ci);
			y.add(cj);
			boolean[][] VISIT = new boolean[N][M];
			VISIT[ci][cj]=true;
			int step = 0;
			int maxSteps = 0;
			int ret = 0;
			int stores = 0;
			while(x.size()>0){
				List<Integer> xnew = new LinkedList<Integer>();
				List<Integer> ynew = new LinkedList<Integer>();
	
				for(int i=0;i<x.size();i++)
				{
					int xi = x.get(i);
					int yi = y.get(i);
					if(GRID[xi][yi]=='#')continue;
					if(GRID[xi][yi]=='S'){
						ret += step;
						stores++;
						maxSteps = Math.max(maxSteps,step);
					}
					System.out.println(xi+","+yi+","+GRID[xi][yi]+","+step);
					if(xi!=0 && !VISIT[xi-1][yi])
					{
						VISIT[xi-1][yi]=true;
						xnew.add(xi-1);
						ynew.add(yi);
					}
					if(yi!=0 && !VISIT[xi][yi-1])
					{
						VISIT[xi][yi-1]=true;
						xnew.add(xi);
						ynew.add(yi-1);
					}
					if(xi!=N-1 && !VISIT[xi+1][yi])
					{
						VISIT[xi+1][yi]=true;
						xnew.add(xi+1);
						ynew.add(yi);
					}
					if(yi!=M-1 && !VISIT[xi][yi+1])
					{
						VISIT[xi][yi+1]=true;
						xnew.add(xi);
						ynew.add(yi+1);
					}
				}
				step = step + 1;
				x=xnew;
				y=ynew;
			}
			System.out.println(60*stores+ret*2-maxSteps);

		}
		out.flush();
		out.close();
		br.close();
	}

}

