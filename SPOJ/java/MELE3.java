import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;
import static java.lang.Math.abs;

class Main{

	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = parseInt(st.nextToken());
			int N = parseInt(st.nextToken());
			Node[] V = new Node[K+1];
			for(int i=1;i<=K;i++)V[i]=new Node(i);
			for(int d=0;d<N;d++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int i = parseInt(st.nextToken());
				int j = parseInt(st.nextToken());
				V[i].add(j);
				V[j].add(i);
			}
				int A=1;int B=K;
				Queue<Node> q =  new PriorityQueue<>( (x1,x2) -> x1.dist-x2.dist );
				q.add(V[A]);
				V[A].dist = 0;
				int ret = 0;
				while(q.size()>0){
					Node n = q.poll();
					if(n.index==B) break;
					//System.out.println(n.index+" "+n.dist);
					for(Node ni:n.outs){
						if(ni.dist==Integer.MAX_VALUE || n.dist+ei.wt<ni.dist)
						{
							q.remove(ni);
							ni.dist = n.dist+ei.wt;
							q.add(ni);
						}
					}
				}
				System.out.println(V[B].dist);
			}
		}	
		br.close();
	}

}

class Node{
	List<Node> outs;
	int index;
	int dist;
	public Node(int i){
		index = i;	
		outs = new LinkedList<Edge>();
		dist = Integer.MAX_VALUE;
	}
	public void add(Node n){ outs.add(n);}
	public int dist(Node n){
		int ret = 0;
		if(n.index>index){
			int t = n.index-index;
			if(dist<t)return t;
			else if((dist-t)%(2*t)==0) return dist;
			else return  dist + (2*t-(dist-t)%(2*t));
		}
		else if(n.index<index){
			int t = n.index-index;
			else if(dist%(2*t)==0) return dist;
			else return dist + (2*t-dist%(2*t));
		}
	}

}

