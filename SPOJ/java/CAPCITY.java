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
		Node[] V = new Node[N+1];
		for(int i=1;i<=N;i++)
			V[i] = new Node(i);
		for(int i=1;i<=N;i++)
		{
			st = new StringTokenizer(br.readLine());
			int u = parseInt(st.nextToken());
			int v = parseInt(st.nextToken());
			V[u].add(V[v]);
		}

		br.close();
	}

}

class Node{
	int index;
	boolean visited;
	List<Node> edges;
	public Node(){
		index=i;
		edges = new LinkedList<>();
	}
	public void add(Node n){
		edges.add(n);
	}
	public List<Node> DFS( int c){
		List<Node> ret = new LinkedList<>();
		visited = true;
		for(Node v:edges)
			if(!v.visited) ret.addAll(v.DFS(c));
		ret.add(this);
		return ret; 
	}

}
