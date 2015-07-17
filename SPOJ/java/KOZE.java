import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;

class Main{

	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = parseInt(st.nextToken());
		int M = parseInt(st.nextToken());
		char[][] GRID = new char[N][M];
		for(int i=0;i<N;i++)
			GRID[i] = br.readLine().toCharArray();
		boolean[][] VISIT = new boolean[N][M];
		int sheep =0; int wolves = 0;
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(!VISIT[i][j] && GRID[i][j]!='#')
				{
					System.out.println("GRID:"+i+","+j);
					List<Integer> x = new LinkedList<Integer>();
					List<Integer> y = new LinkedList<Integer>();
					VISIT[i][j]=true;
					int k=0;int v=0; boolean open = false;
					x.add(i);y.add(j);
			while(x.size()>0){
	
					int xi = x.remove(0);
					int yi = y.remove(0);
					if(GRID[xi][yi]=='#')	continue;
					if(GRID[xi][yi]=='k')	k++;
					if(GRID[xi][yi]=='v')	v++;
					if(xi==0||yi==0||xi==N-1||yi==M-1) open=true;
					if(xi!=0 && !VISIT[xi-1][yi])
					{
						VISIT[xi-1][yi]=true;
						x.add(xi-1);
						y.add(yi);
					}
					if(yi!=0 && !VISIT[xi][yi-1])
					{
						VISIT[xi][yi-1]=true;
						x.add(xi);
						y.add(yi-1);
					}
					if(xi!=N-1 && !VISIT[xi+1][yi])
					{
						VISIT[xi+1][yi]=true;
						x.add(xi+1);
						y.add(yi);
					}
					if(yi!=M-1 && !VISIT[xi][yi+1])
					{
						VISIT[xi][yi+1]=true;
						x.add(xi);
						y.add(yi+1);
					}
				}
				System.out.println(k+","+v+","+open);
				if(open){wolves+=v;sheep+=k;}
				else {if(k>v) sheep+=k; else wolves+=v;}
			}
		System.out.println(sheep+" "+wolves);
		out.flush();
		out.close();
		br.close();
	}

}

