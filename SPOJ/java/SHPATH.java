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
			int N = parseInt(br.readLine());
			Map<String,Integer> map = new HashMap<>();
			Node[] V = new Node[N+1];
			for(int i=1;i<=N;i++)V[i]=new Node(i);
			for(int i=1;i<=N;i++)
			{
				map.put(br.readLine(),i);
				int M = parseInt(br.readLine());
				for(int d=0;d<M;d++)
				{
					StringTokenizer st = new StringTokenizer(br.readLine());
					int y = parseInt(st.nextToken());
					int w = parseInt(st.nextToken());
					V[i].out(V[y],w);
					V[y].out(V[i],w);
				}
			}
			int K = parseInt(br.readLine());
			for(int k=0;k<K;k++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				int A = map.get(st.nextToken());
				int B = map.get(st.nextToken());
				for(int i=1;i<=N;i++) V[i].dist = Integer.MAX_VALUE;
				Queue<Node> q =  new PriorityQueue<>( (x1,x2) -> x1.dist-x2.dist );
				q.add(V[A]);
				V[A].dist = 0;
				int ret = 0;
				while(q.size()>0){
					Node n = q.poll();
					if(n.index==B) break;
					//System.out.println(n.index+" "+n.dist);
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
				System.out.println(V[B].dist);
			}
		}	
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

