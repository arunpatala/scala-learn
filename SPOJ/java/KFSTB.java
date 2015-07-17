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
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			int M = parseInt(st.nextToken());
			int S = parseInt(st.nextToken());
			int T = parseInt(st.nextToken());
			Node[] V = new Node[N+1];
			for(int i=1;i<=N;i++)
				V[i] = new Node(i);
			for(int i=0;i<M;i++)
			{
				st = new StringTokenizer(br.readLine());
				int u = parseInt(st.nextToken());
				int v = parseInt(st.nextToken());
				V[u].add(V[v]);
			}
			System.out.println(V[S].DFS(V[T]));
		}

		br.close();
	}

}

class Node{
	int index;
	List<Node> edges;
	public Node(int i){
		index=i;
		edges = new LinkedList<>();
	}
	public void add(Node n){
		edges.add(n);
	}
	public int DFS(Node t){
		if(this==t) return 1;
		int ret = 0;
		for(Node v:edges)
			ret= (ret+v.DFS(t))%1000000007;
		return ret;
	}

}
