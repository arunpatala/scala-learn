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
                int K = parseInt(br.readLine());
                while(K--!=0)
                {
                        StringTokenizer st = new StringTokenizer(br.readLine());
                        int P = parseInt(st.nextToken());
                        int T = parseInt(st.nextToken());
                        int S = parseInt(st.nextToken());
                        int C = parseInt(st.nextToken());
                        Node[] V1 = new Node[P];
                        Node[] V2 = new Node[T];
                        for(int i=0;i<P;i++)
                        {
                                st = new StringTokenizer(br.readLine());
                                int x = parseInt(st.nextToken());
                                int y = parseInt(st.nextToken());
                                V1[i]=new Node(i,x,y);
                        }
                        for(int i=0;i<T;i++){
                                st = new StringTokenizer(br.readLine());
                                int x = parseInt(st.nextToken());
                                int y = parseInt(st.nextToken());
                                V2[i]=new Node(i+P,x,y);
                                for(int j=0;j<P;j++)
                                        V2[i].add(V1[j],S,C);
                        }
                        Graph G = new Graph(V2,V1);
                        System.out.println(G.HKA());
                }
        }

}


class Graph{
	Node[] U,V;
	Node NIL = new Node(0,0,0);
	int INF = Integer.MAX_VALUE/2;
	public Graph(Node[] Uc, Node[] Vc)
	{
		U=Uc;
		V=Vc;
	}

	public int HKA(){
		for(Node u:U)u.pair=NIL;
		for(Node v:V)v.pair=NIL;
		int matching = 0;
		while(BFS())
			for(Node u:U)
				if(u.pair==NIL&&DFS(u))
					matching++;
		return matching;
	}

	public boolean BFS()
	{
		List<Node> lst = new LinkedList<>();
		for(int i=0;i<U.length;i++)
			if(U[i].pair==NIL)
			{
				U[i].dist=0;
				lst.add(U[i]);
			}
			else U[i].dist=INF;
		NIL.dist = INF;
		while(lst.size()>0)
		{
			Node u = lst.remove(0);
			if(u.dist<NIL.dist)
				for(Node v:u.edges)
				if(v.pair.dist==INF)
				{
					v.pair.dist=u.dist+1;
					lst.add(v.pair);
				}
		}
		return NIL.dist != INF;
	}

	public boolean DFS(Node u)
	{
		if(u!=NIL)
		{
			for(Node v:u.edges)
				if(v.pair.dist==u.dist+1)
					if(DFS(v.pair))
					{
						v.pair=u;
						u.pair=v;
						return true;
					}
			u.dist=INF;
			return false;
		}
		return true;
	}

}

class Node{
	List<Node> edges = new LinkedList<>();
	Node pair;
	int index;
	int dist=0;
	boolean visited;
	int X,Y;
	public Node(int i, int Xc, int Yc){
		index=i;
		X=Xc;
		Y=Yc;
	}
	public void add(Node n, int S, int C)
        {
                int d = (abs(X-n.X)+abs(n.Y-Y))*200;
                int s = S*C;
                if(d<=s)add(n);
        }

	public void add(Node n)
	{
		edges.add(n);
	}
}
