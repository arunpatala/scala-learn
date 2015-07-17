import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;

class Main{

	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0){
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = parseInt(st.nextToken());
		int M = parseInt(st.nextToken());
		char[][] GRID = new char[N][M];
		for(int i=0;i<N;i++)
			GRID[i] = br.readLine().toCharArray();
		boolean[][] VISIT = new boolean[N][M];
		List<Integer> x = new LinkedList<Integer>();
		List<Integer> y = new LinkedList<Integer>();
		for(int i=0;i<N;i++){
			if(GRID[i][0]=='.'){x.add(i);y.add(0);}
			if(M!=1 && GRID[i][M-1]=='.'){x.add(i);y.add(M-1);}
		}
		for(int i=0;i<M;i++){
			if(GRID[0][i]=='.'){x.add(0);y.add(i);}
			if(N!=1 && GRID[N-1][i]=='.'){x.add(N-1);y.add(i);}
		}
		if(x.size()!=2) System.out.println("invalid");
		else{
			int xi = x.get(0);
			int yi = y.get(0);
			int xi2 = x.get(1);
			int yi2 = y.get(1);
			
			VISIT[xi][yi] = true;
			x = new LinkedList<Integer>();
			y = new LinkedList<Integer>();
			x.add(xi);y.add(yi);
			while(x.size()>0){
					xi = x.remove(0);
					yi = y.remove(0);
					if(GRID[xi][yi]=='#')	continue;
					VISIT[xi][yi] = true;
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
			if(VISIT[xi2][yi2])System.out.println("valid");
			else System.out.println("invalid");
		}
		}
		out.flush();
		out.close();
		br.close();
	}

}

