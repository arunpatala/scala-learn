import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken();
			int M = parseInt(st.nextToken();
			Node[] V = new Node[N+1];
			for(int i=1;i<=N;i++)
				V[i] = new Node(i);
			for(int j=1;j<=M;j++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int u = parseInt(st.nextToken();
				int v = parseInt(st.nextToken();
				int p = parseInt(st.nextToken();
				V[u].add(V[v],p);
				V[v].add(V[u],p);
			}
			Queue<Node> q = new PriorityQueue<>();
			q.addAll(V);
			while(q.size()>0)
			{
				Node n = q.poll();
				if(n==V[N])break;
				n.visit = true;
				for(Edge e:n.edges)
					if(!e.n.visited)
					{
						if(e.n.dist==Integer.MAX_VALUE || e.n.dist>n.dist+e.w)
						{
							q.remove(e.n);
							e.dist=n.dist+e.w;
							q.add(e.n);
						}
					}
			}
			System.out.println(V[N].dist);
		}
	}
}

class Node{
	int index;
	int dist = Integer.MAX_VALUE;
	int visited = false;
	List<Edge> edges;
	public Node(int i){
		index = i;
		edges = new LinkedList<>();
	}
	public void add(Node n,int p){
		edges.add(new Edge(n,p));
	}
}

class Edge{
	public Edge(Node nc, int wc)
	{
		n=nc;
		w=wc;
	}
	Node n;
	int w;
}

