import java.util.*;
import java.io.*;
import java.lang.*;
import static java.lang.Integer.parseInt;
import static java.lang.Math.*;



class Main{
        public static void main(String[] args)throws IOException
        {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter out = new PrintWriter(System.out);
                int T = parseInt(br.readLine());
                while(T--!=0)
                {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			int M = parseInt(st.nextToken());
			char[][] G = new char[N][0];
			Node[][] GU = new Node[N][M];
			Node[][] GV = new Node[N][M];
			List<Node> ulst = new LinkedList<>();
			List<Node> vlst = new LinkedList<>();
			for(int i=0;i<N;i++)
			{
				G[i] = br.readLine().toCharArray();
				for(int j=0;j<M;j++)
				if(G[i][j]=='*')
				{
					if(i!=0&&GV[i-1][j]!=null)GV[i][j]=GV[i-1][j];
					else {GV[i][j]=new Node(j);vlst.add(GV[i][j]);}
					if(j!=0&&GU[i][j-1]!=null)GU[i][j]=GU[i][j-1];
					else {GU[i][j]=new Node(j);ulst.add(GU[i][j]);}
					GV[i][j].add(GU[i][j]);
					GU[i][j].add(GV[i][j]);
				}
			}
			Graph g = new Graph(ulst,vlst);
			System.out.println(g.HKA());
		}
		out.close();
		br.close();
	}
}


class Graph{
	Node[] U,V;
	Node NIL = new Node(0);
	int INF = Integer.MAX_VALUE/2;
	public Graph(Node[] Uc, Node[] Vc)
	{
		U=Uc;
		V=Vc;
	}
	public Graph(List<Node> Uc, List<Node> Vc)
	{
		this(Uc.toArray(new Node[0]),Vc.toArray(new Node[0]));
	}

	public boolean BFS()

}

class Node{
	List<Node> edges = new LinkedList<>();
	Node pair;
	int index;
	int dist=0;
	boolean visited;
	public Node(int i){
		index=i;
	}
	public void add(Node n)
	{
		if(!edges.contains(n))
			edges.add(n);
	}
}
