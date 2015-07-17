import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = parseInt(st.nextToken());
		int M = parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int A = parseInt(st.nextToken());
		int B = parseInt(st.nextToken());
		int K = parseInt(st.nextToken());
		int G = parseInt(st.nextToken());
		int[] GA = new int[G];
		st = new StringTokenizer(br.readLine());
		for(int g=0;g<G;g++) GA[g]=parseInt(st.nextToken());

		Node[] V = new Node[N+1];
		for(int m=1;m<=N;m++)V[m]=new Node(m);
		for(int m=0;m<M;m++)
		{
			st = new StringTokenizer(br.readLine());
			int u = parseInt(st.nextToken());
			int v = parseInt(st.nextToken());
			int w = parseInt(st.nextToken());
			V[u].add(v,w);
			V[v].add(u,w);
		}
		Queue<Node> q =  new PriorityQueue<>((u,v)->u.dist-v.dist);
		V[A].dist=0;
		q.add(V[A]);
		while(q.size()>0)
		{
			Node n = q.remove(0);
			while(Edge e:n.edges)
			{
				Node ni = e.n;
				if(ni.dist!=Integer.MAX_VALUE || n.dist+e.w<ni.dist)
				{
					q.remove(ni);
					ni.dist = n.dist + e.w;
					if( e.min<n.dist< e.max) ni.dist = e.max+e.w;
					q.add(ni);
				}
			}
		}
		br.close();
	}

}
public Node{
	int index;
	List<Edge> edges;
	public Node(int i){
		index =i;
		edges = LinkedList<>();
	}
	public void add(Node n, int w){
		edges.add(new Edge(n,w));
	}
}
public Edge{
	Node n;int w;
	public Edge(Node n, int w)
	{
		this.n=n;this.w=w;
	}
}
