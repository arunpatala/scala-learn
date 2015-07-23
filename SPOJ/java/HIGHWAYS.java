import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;
import static java.lang.Math.abs;

class Main{

	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			int M = parseInt(st.nextToken());
			int S = parseInt(st.nextToken());
			int E = parseInt(st.nextToken());
			Node[] V = new Node[N+1];
			for(int i=1;i<=N;i++)V[i]=new Node(i);
			for(int d=0;d<M;d++)
			{
				st = new StringTokenizer(br.readLine());
				int x = parseInt(st.nextToken());
				int y = parseInt(st.nextToken());
				int w = parseInt(st.nextToken());
				V[x].add(V[y],w);
				V[y].add(V[x],w);
			}
			Queue<Node> q =  new PriorityQueue<>( (x1,x2) -> x1.dist-x2.dist );
			V[S].dist = 0;
			for(int i=1;i<=N;i++)q.add(V[i]);
			while(q.size()>0){
				Node n = q.poll();
				n.visit=true;
				if(n==V[E])break;
				for(Edge ei:n.e){
					Node ni = ei.n;
					if(ni.dist==Integer.MAX_VALUE || n.dist+ei.wt<ni.dist)
					{
						q.remove(ni);
						ni.dist = n.dist+ei.wt;
						q.add(ni);
					}
				}
			}
			if(V[E].dist==Integer.MAX_VALUE)
				System.out.println("NONE");
			else System.out.println(V[E].dist);
		

		}			
		br.close();
	}

}

class Node{
	List<Edge> e;
	int index;
	int dist;
	boolean visit;
	public Node(int i){
		index = i;	
		e = new LinkedList<Edge>();
		dist = Integer.MAX_VALUE;
	}
	public void add(Node n, int w){ e.add(new Edge(n,w));}
	public String toString(){
		return index+":"+dist;
	}
}

class Edge{
	Node n;
	int wt;
	public Edge(Node nc, int wc){
		n = nc;
		wt = wc;
	}
	public String toString(){
		return n.index+":"+wt;
	}
}

