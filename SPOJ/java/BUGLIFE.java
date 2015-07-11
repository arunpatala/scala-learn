import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = parseInt(br.readLine());
		int s= 1;
		while(T--!=0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			int M = parseInt(st.nextToken());
			LinkedList<Integer>[] E =(LinkedList<Integer>[]) new LinkedList[N+1];
			for(int i=1;i<=N;i++)E[i]=new LinkedList<Integer>();


			for(int i=0;i<M;i++)
			{
				st = new StringTokenizer(br.readLine());
				int u = parseInt(st.nextToken());
				int v = parseInt(st.nextToken());
				 E[u].add(new Integer(v));
				 E[v].add(new Integer(u));
			}
			boolean bool = true;
			int[] visited = new int[N+1];
			for(int i=1;i<=N;i++)
				if(visited[i]==0)
					bool = bool && DFS(i,-1,E,visited);
			out.printf("Scenario #%d:\n",s++);
			if(bool)out.printf("No suspicious bugs found!\n");
			else out.printf("Suspicious bugs found!\n");

		}
		out.flush();
		out.close();
		br.close();
	}

        public static boolean DFS(int i, int p, LinkedList<Integer>[] edges, int[] visited){
		//System.out.println(i+","+p);
		if(p==-1)visited[i]=1;
		else visited[i] = (2-visited[p]);
                for(int j : edges[i])
                        if(j!=p){
                                if(visited[j]!=0 && visited[j]==visited[i]) return false;
                                else if(visited[j]==0 && !DFS(j,i,edges,visited)) return false;
                        }
                return true;
        }

}
