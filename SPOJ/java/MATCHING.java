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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = parseInt(st.nextToken());
		int M = parseInt(st.nextToken());
		int P = parseInt(st.nextToken());
		Node[] U = new Node[N+1];
		for(int i=0;i<=N;i++)U[i]=new Node(i);
		Node[] V = new Node[M+1];
		for(int i=0;i<=M;i++)V[i]=new Node(i);
		for(int i=0;i<P;i++)
		{
			st = new StringTokenizer(br.readLine());
			int x = parseInt(st.nextToken());
			int y = parseInt(st.nextToken());
			U[x].add(V[y]);
			V[y].add(U[x]);
		}
		Graph G = new Graph(U,V);
		System.out.println(G.HKA());
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
		edges.add(n);
	}
}
