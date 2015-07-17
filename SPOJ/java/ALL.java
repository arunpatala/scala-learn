import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;
import static java.lang.Math.abs;

class Main{

	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N1 = parseInt(st.nextToken());
			int N2 = parseInt(st.nextToken());
			if(N1==0&&N2==0) break;
			Node[] V = new Node[N1+N2+1];
			for(int i=1;i<=N1+N2;i++)V[i]=new Node(i);
			int D = parseInt(st.nextToken());
			for(int d=0;d<D;d++)
			{
				st = new StringTokenizer(br.readLine());
				int x = parseInt(st.nextToken());
				int y = parseInt(st.nextToken());
				V[x].in(V[y]);
				V[y].out(V[x]);
			}
			List<Node> lst1 = new LinkedList<Node>();
			List<Node> lst2 = new LinkedList<Node>();
			for(int i=1;i<=N1;i++){if(V[i].ins.size()==0)lst1.add(V[i]);}
			for(int i=N1+1;i<=N1+N2;i++){if(V[i].ins.size()==0)lst2.add(V[i]);}
			int steps = 0;
			while(lst1.size()>0||lst2.size()>0){
				System.out.print(" LIST1 ");
				steps++;
				while(lst1.size()>0){
					Node n = lst1.remove(0);
					System.out.print(n.index+" ");
					for(Node ni:n.outs){
						ni.removeIn(n);
						if(ni.ins.size()==0)
							if(ni.index<=N1)lst1.add(ni);
							else lst2.add(ni);
					}
				}
				System.out.print(" LIST2 ");
				steps++;
				while(lst2.size()>0){
					Node n = lst2.remove(0);
					System.out.print(n.index+" ");
					for(Node ni:n.outs){
						ni.removeIn(n);
						if(ni.ins.size()==0)
							if(ni.index<=N1)lst1.add(ni);
							else lst2.add(ni);
					}
				}
			}
			System.out.println(steps+1);
		}
		br.close();
	}

}

class Node{
	List<Node> ins, outs;
	int index;
	public Node(int i){
		index = i;	
		ins = new LinkedList<Node>();
		outs = new LinkedList<Node>();
	}
	public void in(Node n){ ins.add(n);}
	public void removeIn(Node n){ ins.remove(n);}
	public void out(Node n){ outs.add(n);}

}

