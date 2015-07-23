import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;

class Main{

	public static void main(String[] args) throws IOException{	
		int Inf = 25*25*10;
		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = parseInt(st.nextToken());
			int N = parseInt(st.nextToken());
			if(N==0&&M==0)break;
			char[][] GRID = new char[N][M];
			Node[][] V = new Node[N][M];
			for(int i=0;i<N;i++)
				GRID[i] = br.readLine().toCharArray();
			Queue<Node> q = new PriorityQueue<>((u,v)->u.dist-v.dist);
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
				{
					V[i][j]= new Node(i,j,GRID[i][j]);
					q.add(V[i][j]);
				}
			Node end = null;
			while(q.size()>0){
				//System.out.println(q);
				Node n = q.poll();
				n.visit = true;
				if(n.end){end=n;break;}
				int x = n.i;int y=n.j;
				int[] xx = {x-1,x+1,x,x};
				int[] yy = {y,y,y-1,y+1};
				for(int i=0;i<4;i++)
				{
					int xi=xx[i],yi=yy[i];
					if(xi>=0&&xi<N&&yi>=0&&yi<M)
					{
						Node nn = V[xi][yi];
						if(!nn.visit&&!nn.block)
							if(nn.dist==Inf || nn.dist>n.dist+nn.wt)
							{
								nn.dist=n.dist+nn.wt;
								q.remove(nn);
								q.add(nn);
							}
					}
				}
			}
			if(end!=null)
				out.printf("%d\n",end.dist);
			out.flush();
			br.readLine();

		}
		out.flush();
		out.close();
		br.close();
	}

}

class Node{
	int Inf = 25*25*10;
	boolean visit,start,end,block;
	int i,j;
	int dist;
	int wt = Inf;
	public Node(int ci, int cj, char c)
	{
		i=ci;j=cj;
		dist = Inf;
		if(c=='S') {start = true;dist=0;}
		else if(c=='D') {end = true;wt=0;}
		else if(c=='X') block = true;
		else wt = c-'0';
	}
	public String toString(){
		return "["+i+","+j+":"+wt+","+dist+"]";
	}
}

