import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;
import static java.lang.Math.abs;

class Main{

	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			int M = parseInt(st.nextToken());
			if(N==0&&M==0)break;
			st = new StringTokenizer(br.readLine());
			int S = parseInt(st.nextToken());
			int D = parseInt(st.nextToken());
			Node[] V = new Node[N];
			for(int i=0;i<N;i++)V[i]=new Node(i);
			for(int d=0;d<M;d++)
			{
				st = new StringTokenizer(br.readLine());
				int x = parseInt(st.nextToken());
				int y = parseInt(st.nextToken());
				int w = parseInt(st.nextToken());
				Edge e = new Edge(V[x],V[y],w);
				V[x].add(e);
				V[y].add(e);
			}
			Queue<Node> q =  new PriorityQueue<>( (x1,x2) -> x1.dist-x2.dist );
			q.add(V[S]);
			V[S].dist = 0;
			int ret = 0;
			while(q.size()>0){
				Node n = q.poll();
				for(Edge ei:n.e){
					Node ni = ei.nout;
					if(ni!=n && ni.dist==Integer.MAX_VALUE || n.dist+ei.wt<ni.dist)
					{
						q.remove(ni);
						ni.dist = n.dist+ei.wt;
						q.add(ni);
					}
				}
			}
			List<Edge> edges = (V[D].paths());
			for(Edge e:edges){
				e.nin.e.remove(e);
				e.nout.e.remove(e);
			}
			for(int i=0;i<N;i++)V[i].dist=Integer.MAX_VALUE;
			q =  new PriorityQueue<>( (x1,x2) -> x1.dist-x2.dist );
			q.add(V[S]);
			V[S].dist = 0;
			while(q.size()>0){
				Node n = q.poll();
				if(n.index==D)break;
				for(Edge ei:n.e){
					Node ni = ei.nout;
					if(ni!=n && ni.dist==Integer.MAX_VALUE || n.dist+ei.wt<ni.dist)
					{
						q.remove(ni);
						ni.dist = n.dist+ei.wt;
						q.add(ni);
					}
				}
			}
			if(V[D].dist==Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(V[D].dist);

		}			
		br.close();
	}

}

class Node{
	List<Edge> e;
	int index;
	int dist;
	public Node(int i){
		index = i;	
		e = new LinkedList<Edge>();
		dist = Integer.MAX_VALUE;
	}
	public void add(Edge ee){ e.add(ee); }
	public List<Edge> paths(){
		List<Edge> ret = new LinkedList<>();
		if(dist==0) return ret;
		for(Edge ei:e)
			if(ei.nout==this && dist==ei.nin.dist+ei.wt)
			{
				ret.add(ei);
				ret.addAll(ei.nin.paths());
			}
		return ret;
	}

}

class Edge{
	Node nin,nout;
	int wt;
	public Edge(Node ninc, Node noutc, int wc){
		nin = ninc;
		nout = noutc;
		wt = wc;
	}
	public String toString(){
		return nin.index+"->"+nout.index+":"+wt;
	}
}

