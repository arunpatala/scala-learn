import java.io.*;
import java.lang.*;
import java.util.*;
import static java.lang.Integer.parseInt;

class Node implements Cloneable{
	int sum;
	int update;
	int size;
	public Node(int i, int s){
		sum=i;size=s;
	}
	public Node(int i){
		sum = i;
		size = 1;
	}
	public Node(Node l, Node r){
		size=l.size+r.size;
		sum=l.sum+r.sum;
	}
	public void update(int i){
		update+=i;
		sum+=(size*i);
	}
	public Node copy(){
		try{
			return (Node)(this.clone());
		}catch(CloneNotSupportedException e){
			return null;
		}
	}
	public String toString(){
		return "("+sum+","+update+","+size+")";
	}
}
class Tree{
	Node[] nodes;
	int N,L;
	public Tree(int[] C){
		L = C.length;
		int N = size(L);
		nodes = new Node[N];
		build(C);
	}
	public void build(int[] C){build(C,1,0,L-1);}
	public void build(int[] C, int i, int lo, int hi){
		if(lo==hi)nodes[i]=new Node(C[lo]);
		else{
			int mid = (lo+hi)/2, l=2*i, r=2*i+1;
			build(C,l,lo,mid);
			build(C,r,mid+1,hi);
			nodes[i] = new Node(nodes[l],nodes[r]);
		}
	}
	public void update(int i, int j, int v){update(1,0,L-1,i,j,v);}
	public void update(int idx, int lo, int hi, int i, int j, int v){
		if(lo==i&&j==hi)nodes[idx].update(v);
		else{
			int mid = (lo+hi)/2, l=2*idx, r=2*idx+1 ;
			if(j<=mid)update(l,lo,mid,i,j,v);
			else if(mid<i) update(r,mid+1,hi,i,j,v);
			else{
				update(l,lo,mid,i,mid,v);
				update(r,mid+1,hi,mid+1,j,v);
			}
			int update = nodes[idx].update;
			nodes[idx]=new Node(nodes[l],nodes[r]);
			nodes[idx].update(update);
		}
	}
	public int query(int i, int j){return query(1,0,L-1,i,j).sum;}
	public Node query(int idx, int lo, int hi, int i, int j){
		if(lo==hi)return nodes[idx].copy();
		else{
			Node ret;
			int mid = (lo+hi)/2, l=2*idx, r=2*idx+1 ;
			if(j<=mid)ret = query(l,lo,mid,i,j);
			else if(mid<i) ret = query(r,mid+1,hi,i,j);
			else{
				Node left = query(l,lo,mid,i,mid);
				Node right = query(r,mid+1,hi,mid+1,j);
				ret = new Node(left,right);
			}
			ret.update(nodes[idx].update);;
			return ret;
		}
	}
	public int size(int N){
		int size = 1;
		while(size<N)size<<=1;
		return size<<1;
	}
	public String toString(){
		return Arrays.toString(nodes);
	}
}
class Main{

        public static void main(String[] args) throws IOException{

                PrintWriter out = new PrintWriter(System.out);
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		for(int t=1;t<=T;t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			int M = parseInt(st.nextToken());
			Tree ST = new Tree(new int[N]);
				System.out.println(ST);
			while(M--!=0)
			{
				st = new StringTokenizer(br.readLine());
				int C = parseInt(st.nextToken());
				if(C==0)
				{
					int i = parseInt(st.nextToken());
					int j = parseInt(st.nextToken());
					int v = parseInt(st.nextToken());
					ST.update(i-1,j-1,v);
				}
				else{
					int i = parseInt(st.nextToken());
					int j = parseInt(st.nextToken());
					out.printf("%d\n",ST.query(i-1,j-1));
				}
				System.out.println(ST);
			}
		}
                out.flush();
                out.close();
                br.close();
        }

}

