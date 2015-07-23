import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N ='z'-'A'+1;
		Node[] V = new Node[N];
		int M = parseInt(br.readLine());
		for(int i=0;i<M;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = st.nextToken().charAt(0)-'A';
			int v = st.nextToken().charAt(0)-'A';
			int w = parseInt(st.nextToken());
			V[u].add(V[v],w);
		}
		int S = 0;
		int E = 25;
		List<Node> list = new LinkedList<>();
		boolean[] VISIT = new boolean[N];
		Node[] prev = new Node[N];
		list.add(V[S]);
		VISIT[S] = true;
		while(true){
			Node u = list.remove(0);
			if(u==V[E])break;
			for(Edge e:u.edges)
				if(!VISIT[e.end] && e.fwd>0){
					VISIT[e.end] = true;
					prev[e.end] = u;
					list.add(e.end);
				}
		}


		br.close();
	}

}

class Node{
	char index;
	List<Edges> edges;
	public Node(char i){
		index = i;
	}
	public void add(Node that, int w){
		edges.add(new Edge(this,that,w));
	}
}

class Edge{
	Node start;
	Node end;
	int fwd;
	int back;
}
