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
		for(int i=0;i<=N;i++)V[i]=new Node(i);
		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine());
			int u = parseInt(st.nextToken());
			int k = parseInt(st.nextToken());
			for(int j=0;j<k;j++)
			{
				int v = parseInt(st.nextToken());
				V[u].addIn(V[v]);
				V[v].addOut(V[u]);
			}
		}
		List<Node> lst = new LinkedList<>();
		for(int i=1;i<=N;i++)
			if(V[i].in.size()==0)
				lst.add(V[i]);
		while(lst.size()>0){
			Node u = lst.remove(0);
			System.out.print(u.index+" ");
			for(Node v:u.out){
				v.in.remove(u);
				if(v.in.size()==0)
					lst.add(v);
			}
		}
		System.out.println();

	}
}

class Node{
	List<Node> in,out;
	int index;
	public Node(int i){
		index=i;
		in = new LinkedList<>();
		out = new LinkedList<>();
	}
	public void addIn(Node n){
		in.add(n);
	}
	public void addOut(Node n){
		out.add(n);
	}
}
