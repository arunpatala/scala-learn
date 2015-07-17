import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;
import static java.lang.Math.abs;

class Main{

	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = parseInt(br.readLine());
			int E = parseInt(br.readLine());
			int T = parseInt(br.readLine());
			int M = parseInt(br.readLine());
			Node[] V = new Node[N+1];
			for(int i=1;i<=N;i++)V[i]=new Node(i);
			for(int d=0;d<M;d++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = parseInt(st.nextToken());
				int y = parseInt(st.nextToken());
				int w = parseInt(st.nextToken());
				V[x].out(V[y],w);
			}
			Queue<Node> q =  new PriorityQueue<>( (x1,x2) -> x1.dist-x2.dist );
			q.add(V[E]);
			V[E].dist = 0;
			int ret = 0;
			while(q.size()>0){
				Node n = q.poll();
				if(n.dist<=T) ret++;
				System.out.println(n.index+" "+n.dist);
				for(Edge ei:n.outs){
					Node ni = ei.n;
					if(ni.dist==Integer.MAX_VALUE || n.dist+ei.wt<ni.dist)
					{
						q.remove(ni);
						ni.dist = n.dist+ei.wt;
						q.add(ni);
					}
				}
			}
			System.out.println(ret);
			
		br.close();
	}

}

class Node{
	List<Edge> outs;
	int index;
	int dist;
	public Node(int i){
		index = i;	
		outs = new LinkedList<Edge>();
		dist = Integer.MAX_VALUE;
	}
	public void out(Node n,int wt){ outs.add(new Edge(n,wt));}

}

class Edge{
	Node n;
	int wt;
	public Edge(Node nc, int wc){
		n = nc;
		wt = wc;

	}
}

