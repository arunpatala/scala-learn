import java.util.*;
import java.io.*;
import java.lang.*;
import static java.lang.Integer.parseInt;
import static java.lang.Math.max;
import static java.lang.Math.min;

class Main{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = parseInt(st.nextToken());
		int M = parseInt(st.nextToken());
		int K = parseInt(st.nextToken());
		Node[] V = new Node[N+1];
		for(int i=0;i<=N;i++)V[i]=new Node(i);
		Node dest = V[0];
		st = new StringTokenizer(br.readLine());
		for(int k=0;k<K;k++){
			int u = parseInt(st.nextToken());
			V[u].add(dest,1);
		}
		List<Edge> edges = new LinkedList<>();
		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine());
			int u = parseInt(st.nextToken());
			int v = parseInt(st.nextToken());
			edges.add(V[u].add(V[v]));
		}
		Graph G = new Graph(V,V[1],dest);
		System.out.println(G);
		G.maxFlow();
		int max=0;
		for(Edge e:edges)
		{
			System.out.println("EDGE:"+e);
			max=max(max,e.flow);
		}
		System.out.println(max);
		System.out.println(G);
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
		return dst.visited;
	}

	public int flow()
	{
		Node dest = dst;
		int min=Node.INF;
		while(dest!=src)
		{
			min = min(min,dest.par.w);
			System.out.println(dest.par);
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
	public String toString(){
		return Arrays.toString(V);
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
	public Edge add(Node n){
		return add(n,INF,INF);
	}
	public void add(Node n, int w){
		add(n,w,0);
	}
	public Edge add(Node n, int w1, int w2)
	{
		Edge efwd = new Edge(this,n,w1);
		Edge ebck = new Edge(n,this,w2);
		efwd.e=ebck;
		ebck.e=efwd;
		edges.add(efwd);
		n.edges.add(ebck);
		return efwd;
	}
	public String toString(){
		return edges.toString();
	}
}

class Edge{
	Node from;
	Node to;
	int w;
	Edge e;
	int flow=0;
	public Edge(Node f, Node t, int wc)
	{
		from=f;
		to=t;
		w=wc;
	}
	public void flow(int wc)
	{
		w-=wc;
		flow+=wc;
		e.w+=wc;
		e.flow-=wc;
	}
	public String toString()
	{
		return from.index+"->"+to.index+":"+w+","+flow;
	}
}
