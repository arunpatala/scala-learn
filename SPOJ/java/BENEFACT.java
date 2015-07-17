import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = parseInt(br.readLine());
		while(t--!=0)
		{
			int N = parseInt(br.readLine());
			Node[] V = new Node[N+1];
			for(int i=1;i<=N;i++)
				V[i] = new Node(i);
			for(int i=0;i<N-1;i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int u = parseInt(st.nextToken());
				int v = parseInt(st.nextToken());
				int w = parseInt(st.nextToken());
				V[u].add(V[v],w);
				V[v].add(V[u],w);
			}
			V[1].DFS(null);
			System.out.println(V[1].d2);
		}

		br.close();
	}

}

class Node{
	int index;
	List<Edge> edges;
	int d1 = 0;
	int d2 = 0;
	public Node(int i){
		index=i;
		edges = new LinkedList<>();
	}
	public void add(Node n, int w){
		edges.add(new Edge(n,w));
	}
	public void DFS(Node p){
		System.out.println(index+" "+edges);
		List<Integer> d = new LinkedList<>();
		for(Edge e:edges){
			if(e.v!=p){
				e.v.DFS(this);
				d.add(e.v.d1+e.w);
				d2 = max(d2,e.v.d2);
			}
		}
		for(int di:d)
			d1 = max(d1,di);
		for(int i=0;i<d.size();i++)
			for( int j=i+1;j<d.size();j++)
				d2=max(d2,d.get(i)+d.get(j));
	}

}
class Edge{
	Node v;
	int w;
	public Edge(Node vc, int wc){
		v = vc;
		w = wc;
	}
	public String toString(){
		return v.index+":"+w;
	}
}
