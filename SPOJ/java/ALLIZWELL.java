import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			int M = parseInt(st.nextToken());
			char[][] GRID = new char[N][M];
			for(int i=0;i<N;i++)
				GRID[i]=br.readLine().toCharArray();
			if(new Search(GRID).DFS())System.out.println("YES");
			else System.out.println("NO");
		}
		br.close();
	}

}

class Search{
	char[][] G;
	boolean[][] V;
	int N,M;
	char[] S = "ALLIZZWELL".toCharArray();
	public Search(char[][] g){
		G=g;
		N = G.length;
		M = G[0].length;
		V = new boolean[N][M];
	}
	public boolean DFS(){
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(DFS(i,j,0))return true;
		return false;
	}

	public boolean DFS(int i, int j, int k){
		if(k==S.length) return true;
		if(G[i][j]==S[k]){
			if(k==S.length-1) return true;
			System.out.println(i+","+j+","+k);
			for(int x=-1;x<=1;x++)
				for(int y=-1;y<=1;y++)
					if(!(x==0&&y==0))
					if(i+x>=0&&j+y>=0&&i+x<N&&j+y<M&&!V[i+x][j+y])
					{
						V[i+x][j+y]=true;
						if(DFS(i+x,j+y,k+1)) return true;
						V[i+x][j+y]=false;
					}
			return false;
		}
		else return false;

	}

	
}
