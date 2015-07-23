import java.io.*;
import java.util.*;

class Main
{
	public static void main(String[] args) throws IOException
	{
		Graph g = new Graph();
	}
}

class Node{
	int index;
	List<Node> edges = LinkedList<>();
	int chosen;
	int notChosen;
	public Node(int i)
	{
		index = i;
	}
	public void addEdge(Node n){
		edges.add(n);
	}
	public void DFS(Node p){
		chosen = 1;
		notchosen = 0; // one of the children is chosen
		for(Node c:edges)
			if(c!=p)
			{
				DFS(c);
				chosen += min(c.notChosen,c.chosen);
				notchosen 
			}
	}
}

class Graph
{
	Node[] V;
	int N;
	public Graph() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		V=new Node[N+1];
		for(int i=1;i<=N;i++)
			V[i]=new Node(i);
		for(int i=1;i<N;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());		
			int v1=Integer.parseInt(st.nextToken());
			int v2=Integer.parseInt(st.nextToken());
			V[v1].add(V[v2]);
			V[v2].add(V[v1]);
		}
	}

	public void test()
	{
            depthFirst(1,-1);
            System.out.println(Math.min(VC1[1],VC2[1]));
        }

	
}


