import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;
import static java.lang.Math.abs;

class Main{

	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = 500;
			int M = parseInt(br.readLine());
			Node[] V = new Node[N+1];
			for(int i=0;i<=N;i++)V[i]=new Node(i);
			for(int d=0;d<M;d++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = parseInt(st.nextToken());
				int y = parseInt(st.nextToken());
				int w = parseInt(st.nextToken());
				V[x].add(V[y],w);
				V[y].add(V[x],w);
			}
			int S = parseInt(br.readLine());
			Queue<Node> q =  new PriorityQueue<>( (x1,x2) -> x1.dist-x2.dist );
			V[S].dist = 0;
			q.add(V[S]);
			while(q.size()>0){
				Node n = q.poll();
				if(n.visit)continue;
				n.visit=true;
				for(Edge ei:n.e){
					Node ni = ei.n;
					if(!ni.visit)
					if(ni.dist==Integer.MAX_VALUE || n.dist+ei.wt<ni.dist)
					{
						ni.dist = n.dist+ei.wt;
						q.add(ni);
					}
				}
			}
			int P = parseInt(br.readLine());
			for(int i=0;i<P;i++)
			{
				int E = parseInt(br.readLine());
				if(V[E].dist==Integer.MAX_VALUE)
					out.printf("NO PATH\n");
				else out.printf("%d\n",V[E].dist);
			}
			out.flush();
			out.close();
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

