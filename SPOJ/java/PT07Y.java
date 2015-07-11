import java.io.*;
import java.util.*;

class Main{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		LinkedList<Integer>[] E =(LinkedList<Integer>[]) new LinkedList[N+1];
		for(int i=1;i<=N;i++)E[i]=new LinkedList<Integer>();
		for(int i=0;i<M;i++)
		{
			st = new StringTokenizer(br.readLine());		
			int v1=Integer.parseInt(st.nextToken());
			int v2=Integer.parseInt(st.nextToken());
			E[v1].add(new Integer(v2));
			E[v2].add(new Integer(v1));
		}
		boolean[] visited = new boolean[N+1];
		boolean valid = true;
		for(int i=1;i<=N&&valid;i++)
			if(!visited[i])valid=DFS(i,-1,E, visited);
		if(valid) System.out.println("YES");
		else  System.out.println("NO");
	}

	public static boolean DFS(int i, int p, LinkedList<Integer>[] edges, boolean[] visited){
		visited[i] = true;
		for(int j : edges[i])
			if(j!=p){
				if(visited[j]) return false;
				if(!DFS(j,i,edges,visited)) return false;
			}
		return true;
	}

}
