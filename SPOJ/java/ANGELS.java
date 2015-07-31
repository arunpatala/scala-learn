import java.util.*;
import java.io.*;
import java.lang.*;
import static java.lang.Integer.parseInt;
import static java.lang.Math.*;



class Main{
        public static void main(String[] args)throws IOException
        {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter out = new PrintWriter(System.out);
                int T = parseInt(br.readLine());
                while(T--!=0)
                {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			int M = parseInt(st.nextToken());
			char[][] G = new char[N][M];
			Node[][] GU = new Node[N][M];
			Node[][] GV = new Node[N][M];
			List<Node> ulst = new LinkedList<>();
			List<Node> vlst = new LinkedList<>();
			for(int i=0;i<N;i++)
			{
				char[] C = br.readLine().toCharArray();
				for(int j=0;j<M;j++)
				{
					G[i][j]=C[2*j];
					if(G[i][j]=='H'||G[i][j]=='D')
					{
						if(i!=0&&GV[i-1][j]!=null)GV[i][j]=GV[i-1][j];
						else  GV[i][j]=new Node(j);
						if(j!=0&&GU[i][j-1]!=null)GU[i][j]=GU[i][j-1];
						else  GU[i][j]=new Node(j);
					}
				}
			}
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
				{
					if(GU[i][j]!=null&&G[i][j]=='H'&&!ulst.contains(GU[i][j]))
						ulst.add(GU[i][j]);
					if(GV[i][j]!=null&&G[i][j]=='H'&&!vlst.contains(GV[i][j]))
						vlst.add(GV[i][j]);
				}
			Graph g = new Graph(ulst,vlst);
			System.out.println(g.HKA());
		}
		out.close();
		br.close();
	}
}


class Graph{
	Node[] U,V;
	Node NIL = new Node(0);
	int INF = Integer.MAX_VALUE/2;
	public Graph(Node[] Uc, Node[] Vc)
	{
		U=Uc;
		V=Vc;
	}
	public Graph(List<Node> Uc, List<Node> Vc)
	{
		this(Uc.toArray(new Node[0]),Vc.toArray(new Node[0]));
	}

	public int HKA(){
		for(Node u:U)u.pair=NIL;
		for(Node v:V)v.pair=NIL;
		int matching = 0;
		while(BFS())
			for(Node u:U)
				if(u.pair==NIL&&DFS(u))
					matching++;
		return matching;
	}

	public boolean BFS()
	{
		List<Node> lst = new LinkedList<>();
		for(int i=0;i<U.length;i++)
			if(U[i].pair==NIL)
			{
				U[i].dist=0;
				lst.add(U[i]);
			}
			else U[i].dist=INF;
		NIL.dist = INF;
		while(lst.size()>0)
		{
			Node u = lst.remove(0);
			if(u.dist<NIL.dist)
				for(Node v:u.edges)
				if(v.pair.dist==INF)
				{
					v.pair.dist=u.dist+1;
					lst.add(v.pair);
				}
		}
		return NIL.dist != INF;
	}

	public boolean DFS(Node u)
	{
		if(u!=NIL)
		{
			for(Node v:u.edges)
				if(v.pair.dist==u.dist+1)
					if(DFS(v.pair))
					{
						v.pair=u;
						u.pair=v;
						return true;
					}
			u.dist=INF;
			return false;
		}
		return true;
	}

}

class Node{
	List<Node> edges = new LinkedList<>();
	Node pair;
	int index;
	int dist=0;
	boolean visited;
	public Node(int i){
		index=i;
	}
	public void add(Node n)
	{
		if(!edges.contains(n))
			edges.add(n);
	}
}
