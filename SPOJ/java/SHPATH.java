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
				String city = br.readLine();
				map.put(city,i);
				int M = parseInt(br.readLine());
				for(int j=0;j<M;j++)
				{
					StringTokenizer st = new StringTokenizer(br.readLine());
					int y = parseInt(st.nextToken());
					int w = parseInt(st.nextToken());
					V[i].add(V[y],w);
				}
			}
			int M = parseInt(br.readLine());
			for(int m=0;m<M;m++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = map.get(st.nextToken());
			int E = map.get(st.nextToken());

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
			out.printf("%d\n",V[E].dist);
			}
		

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

