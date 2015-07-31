import java.util.*;
import java.io.*;
import java.lang.*;
import static java.lang.Integer.parseInt;
import static java.lang.Math.min;
/*
1
12
4 3 4 2 5
1 8
2 9 7
2 6 11
1 8
2 9 10
2 10 11
1 12
2 10 12
1 12
1 12
*/


class Main{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			int N = parseInt(br.readLine());
			Node[] V = new Node[N+1];
			for(int i=0;i<=N;i++)V[i]=new Node(i);
			for(int u=1;u<N;u++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int M = parseInt(st.nextToken());
				for(int j=0;j<M;j++)
				{
					int v = parseInt(st.nextToken());
					if(u==1||v==N) V[u].add(V[v],1);
					else V[u].add(V[v],Node.INF);
				}
			}
			Graph G = new Graph(V,V[1],V[N]);
			System.out.println(G.maxFlow());
			br.readLine();
		}
	}

}

class Graph{
	int N;
	Node[] V;
	Node src,dst;
	public Graph(Node[] Vc, Node srcc, Node dstc)
	{
		N = Vc.length;
		V=Vc;
		src=srcc;
		dst=dstc;
	}
	public Graph(Node[] Vc)
	{
		this(Vc,Vc[0],Vc[Vc.length-1]);
	}

	public void minCut()
	{
		maxFlow();
		for(int i=0;i<N;i++)
			if(V[i].visited)
			{
				System.out.println(i+":");
				for(Edge e:V[i].edges)
					if(!e.to.visited)
						System.out.println(e);
			}
		System.out.println();

	}

	public int maxFlow()
	{
		int f = 0;
		while(BFS())
			f+=flow();
		return f;
	}

	public boolean BFS()
	{
		for(int i=0;i<N;i++)V[i].visited=false;
		List<Node> lst = new LinkedList<>();
		lst.add(src);
		src.visited=true;
		while(lst.size()>0)
		{
			Node n = lst.remove(0);
			for(Edge e:n.edges)
				if(e.w!=0)
				if(!e.to.visited)
				{
					lst.add(e.to);
					e.to.visited=true;
					e.to.par=e;
				}
		}
		return V[N-1].visited;
	}

	public int flow()
	{
		Node dest = dst;
		int min=Integer.MAX_VALUE;
		while(dest!=src)
		{
			min = min(min,dest.par.w);
			//System.out.println(dest.par);
			dest=dest.par.from;
		}
		dest=dst;
		while(dest!=src)
		{
			dest.par.flow(min);
			dest=dest.par.from;
		}
		return min;
	}

}

class Node{
	public static final int INF = Integer.MAX_VALUE/2;
	List<Edge> edges = new LinkedList<>();
	boolean visited = false;
	Edge par;
	int index;
	public Node(int i){
		index=i;
	}
	public void add(Node n, int w)
	{
		Edge efwd = new Edge(this,n,w);
		Edge ebck = new Edge(n,this,0);
		efwd.e=ebck;
		ebck.e=efwd;
		edges.add(efwd);
		n.edges.add(ebck);
	}
}

class Edge{
	Node from;
	Node to;
	int w;
	Edge e;
	public Edge(Node f, Node t, int wc)
	{
		from=f;
		to=t;
		w=wc;
	}
	public void flow(int wc)
	{
			w-=wc;
			e.w+=wc;
	}
	public String toString()
	{
		return from.index+"->"+to.index+":"+w;
	}
}
