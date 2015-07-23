import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			br.readLine();
			int N = parseInt(br.readLine());
			Node[] V = new Node[N+1];
			for(int i=1;i<=N;i++)V[i]=new Node(i);
			for(int u=1;u<=N;u++)
			{
				br.readLine();
				int M = parseInt(br.readLine());
				for(int i=1;i<=M;i++)
				{
					StringTokenizer st = new StringTokenizer(br.readLine());
					int v = parseInt(st.nextToken());
					int w = parseInt(st.nextToken());
					V[u].add(V[v],w);
					V[v].add(V[u],w);
				}
			}
			Queue<Edge> q = new PriorityQueue<>((u,v)->u.w-v.w);
			q.addAll(V[1].edges);
			boolean[] VISITED = new boolean[N+1];
			VISITED[1]=true;
			int ret = 0;
			for(int i=1;i<N;i++)
			{
				//System.out.println(q);
				Edge e=q.poll();	
				while(VISITED[e.v.index]){
					e=q.poll();
				}
				ret += e.w;
				//System.out.println(e);
				VISITED[e.v.index]=true;
				q.addAll(e.v.edges);
			}
			System.out.println(ret);
		}
	}
}

class Node{
	List<Edge> edges;
	int index;
	public Node(int i){
		index = i;
		edges = new LinkedList<>();
	}
	public void add(Node n, int w){
		edges.add(new Edge(this,n,w));
	}
}
class Edge{
	Node u,v;
	int w;
	public Edge(Node uc, Node vc, int wc){
		u=uc;v=vc;w=wc;
	}
	public String toString(){
		return u.index+"->"+v.index+":"+w;
	}
}

