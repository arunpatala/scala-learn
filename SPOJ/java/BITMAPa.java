import java.io.*;
import java.util.*;
import static java.lang.Math.min;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t= parseInt(br.readLine());
		while(t--!=0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			int M = parseInt(st.nextToken());
			char[][] A = new char[N][M];
			for(int i=0;i<N;i++)
				A[i]=br.readLine().toCharArray();

			Grid g = new Grid(A,N,M);
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<M;j++)
					out.printf("%d ",g.H[i][j]-1);
				out.printf("\n");
			}
			br.readLine();
		}
		out.flush();
		out.close();
		br.close();
	}

}

class Grid{
	int[][] H;
	char[][] A;
	int N;
	int M;

	public Grid(char[][] Ac, int Nc, int Mc){
		A = Ac; N = Nc;M = Mc;
		H = new int[N][M];
		BFS();
	}

	public void BFS(){
		List<Integer> points = new LinkedList<Integer>();
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(A[i][j]=='1'){
					points.add(i);
					points.add(j);
					H[i][j]=1;
				}
		
		int h = 1;
		while(points.size()!=0)
		{
			List<Integer> nextPoints = new LinkedList<Integer>();
			h++;
			for(int i=0;i<points.size();i+=2)
			{
				int x = points.get(i);
				int y = points.get(i+1);
				if((x-1)>=0 && H[x-1][y]==0){H[x-1][y]=h;nextPoints.add(x-1);nextPoints.add(y);}
				if((x+1)<N && H[x+1][y]==0){H[x+1][y]=h;nextPoints.add(x+1);nextPoints.add(y);}
				if((y-1)>=0 && H[x][y-1]==0){H[x][y-1]=h;nextPoints.add(x);nextPoints.add(y-1);}
				if((y+1)<M && H[x][y+1]==0){H[x][y+1]=h;nextPoints.add(x);nextPoints.add(y+1);}
			}
			points = nextPoints;
		}
	}
}

