import java.io.*;
import java.util.*;
import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Math.pow;

class Main{
	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String S = br.readLine();
			if(S==null)break;
			int N = parseInt(br.readLine());
			Node[] V = new Node[N+1];
			for(int i=1;i<=N;i++)V[i]=new Node(i);
			for(int i=1;i<=N;i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int u = parseInt(st.nextToken());
				int M = parseInt(st.nextToken());
				for(int j=1;j<=M;j++)
				{
					int v = parseInt(st.nextToken());
					V[u].c.add(V[v]);
					V[v].par = V[u];
				}	
			}
		}
		br.close();
	}
}

class Node{
	int index;
	Node p;
	int bestIfChosen;
	List<Node> c = new LinkedList<>();
	public Node(int i)
	{
		index=i;
	}
	public void solve(){
		//pair with any of its children
	}
}
