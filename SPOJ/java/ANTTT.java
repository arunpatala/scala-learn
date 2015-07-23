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
			Node[] V = new Node[N+1];
			for(int i=1;i<=N;i++)
			{
				st = new StringTokenizer(br.readLine());
				int x1 = parseInt(st.nextToken());
				int y1 = parseInt(st.nextToken());
				int x2 = parseInt(st.nextToken());
				int y2 = parseInt(st.nextToken());
				V[i] = new Node(i,x1,y1,x2,y2);
			}
			int c = 0;
			for(int i=1;i<=N;i++)
				if(!V[i].visited)V[i].DFS(c++);
			for(int i=0;i<M;i++)
			{
				st = new StringTokenizer(br.readLine());
				int a = parseInt(st.nextToken());
				int b = parseInt(st.nextToken());
				if(V[a].c==V[b].c) System.out.println("YES");
				else System.out.println("NO");
			}
		}

		br.close();
	}

}

class Node{
	int index;
	int x1,y1,x2,y2;
	List<Node> edges;
	boolean visited;
	int c;
	public Node(int i,int x1,int y1,int x2, int y2){
		index=i;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		edges = new LinkedList<>();
	}
	public void add(Node n){
		if(this.inter(n) && n.inter(this)){
			edges.add(n);
		}
	}

	public boolean inter(Node n){
		int sign1 = ((n.x1-x1)*(n.y2-y1)) - ((n.x2-x1)*(n.y1-y1)); 
		int sign2 = ((n.x1-x2)*(n.y2-y2)) - ((n.x2-x2)*(n.y1-y2)); 
		if(sign1*sign2<0) return true;	
		else return false;
	}
	public void DFS( int c){
		this.c = c;
		visited = true;
		for(Node v:edges)
			if(!v.visited) v.DFS(c); 
	}

}
