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
		List<Point> points = new LinkedList<Point>();
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(A[i][j]=='1')
					points.add(new Point(i,j));
		BFS(points);
	}

	public void BFS(List<Point> points){
		int h = 1;
		while(points.size()!=0)
		{
			for(Point pt:points) H[pt.x][pt.y] = h;
			List<Point> nextPoints = new LinkedList<Point>();
			for(Point pt:points) 
				//check here
				for(Point npt:pt.neigh())
					if(npt.x>=0 && npt.y>=0 && npt.x<N && npt.y<M)
						if(H[npt.x][npt.y]==0)
							nextPoints.add(npt);	
			h++;
			points = nextPoints;
		}
	}
}


class Point{
	int x; int y;
	public Point(int xc, int yc){
		x = xc; y = yc;
	}
}

