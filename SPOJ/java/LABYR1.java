import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;

class Main{

	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = parseInt(st.nextToken());
		int N = parseInt(st.nextToken());
		char[][] GRID = new char[N][M];
		int x0=0,y0=0;
		for(int i=0;i<N;i++)
		{
			GRID[i] = br.readLine().toCharArray();
			for(int j=0;j<M;j++)
				if(GRID[i][j]=='.')
					{x0=i;y0=j;}
		}
		boolean[][] VISIT = new boolean[N][M];
		int[][] Z1 = new int[N][M];
		int[][] Z2 = new int[N][M];
		DFS(x0,y0,GRID,VISIT,Z1,Z2);
		System.out.println(Z2[x0][y0]);
		out.flush();
		out.close();
		br.close();
	}
	
	public static void DFS(int xi, int yi, char[][] G, boolean[][] V,int[][] Z1, int[][] Z2)
	{
		System.out.println(xi+","+yi);
		V[xi][yi]=true;
		int N = G.length, M = G[0].length;
		int[] xx = {xi-1,xi-1,xi+1,xi+1};
		int[] yy = {yi-1,yi+1,yi-1,yi+1};
		List<Integer> z1 = new LinkedList<>();
		List<Integer> z2 = new LinkedList<>();
		for(int i=0;i<4;i++)
			if(xx[i]>=0&&xx[i]<N&&yy[i]>=0&&yy[i]<M&&G[xx[i]][yy[i]]=='.'&&!V[xx[i]][yy[i]])
			{
				DFS(xx[i],yy[i],G,V,Z1,Z2);
				z1.add(Z1[xx[i]][yy[i]]);
				z2.add(Z2[xx[i]][yy[i]]);
			}
		int max1 = 0;
		for(int w1:z1)
			max1=Math.max(max1,w1+1);
		Z1[xi][yi]=max1;
		int max2 = 0;
		for(int w2:z2)
			max2=Math.max(max2,w2);
		for(int i=0;i<z1.size();i++)
			for(int j=i+1;j<z1.size();j++)
					max2=Math.max(max2,z1.get(i)+z1.get(j)+2);
		Z2[xi][yi]=Math.max(max1,max2);

	}

}

/*
	
		Stack<Integer> x = new Stack<>();
		Stack<Integer> y = new Stack<>();
		//init
		while(x.size()>0)
		{
			int xi = x.poll();
			int yi = x.poll();
			int xx = {xi-1,xi-1,xi+1,xi+1};
			int yy = {yi-1,yi+1,yi-1,yi+1};
			for(int i=0;i<4;i++)
			if(xx[i]>=0&&xx[i]<N&&yy[i]>=0&&yy[i]<M&&!VISIT[xx[i]][yy[i]])
			{
				VISIT[xx[i]][yy[i]]=true;
				x.push(xx[i]);
				y.push(yy[i]);
			}
		}

*/
