import java.util.*;
import java.io.*;
import java.lang.*;
import static java.lang.Integer.parseInt;
import static java.lang.Math.min;

class Main{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = parseInt(st.nextToken());
		int M = parseInt(st.nextToken());
		Node[] V = new Node[N+1];
		for(int i=0;i<=N;i++)V[i]=new Node(i);
		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine());
			int u = parseInt(st.nextToken());
			int v = parseInt(st.nextToken());
			int w = parseInt(st.nextToken());
			V[u].add(V[v],w);
		}
		Graph G = new Graph(V,V[1],V[N]);
		System.out.println(G.maxFlow());
		//G.minCut();
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
		Edge ebck = new Edge(n,this,w);
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
