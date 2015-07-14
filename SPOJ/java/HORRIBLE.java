import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;

class Main{

	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			int[] A = new int[N];
			Node ST = new Node(A);
			int M = parseInt(st.nextToken());
			while(M--!=0)
			{
				st = new StringTokenizer(br.readLine());
				int c = parseInt(st.nextToken());
				int p = parseInt(st.nextToken());
				int q = parseInt(st.nextToken());
				if(c==1)
					System.out.println(ST.query(p-1,q-1));
				else {
					int v = parseInt(st.nextToken());
					ST.rupdate(p-1,q-1,v);
				}
				//System.out.println(ST);
			}
		}
		out.flush();
		out.close();
		br.close();
	}

}

class Stat{
	int sum = 0;
	int add = 0;
	int size = 0;
	public Stat(int a){
		sum = a;
		size = 1;
	}
	public Stat(Stat l, Stat r){
		size = l.size + r.size;
		sum = l.sum+ r.sum ;
	}
	public void update(int v){
		add += v;
	}
	public String getValue(){
		return sum+"";
	}
	public String toString(){
		return sum+","+add;
	}
}

class Node{

	Node left,right;
	int lo,hi,mid;
	Stat max;

	public Node(int[] A){
		this(A,0,A.length-1);
	}
	public Node(int[] A, int lo, int hi){
		this.hi = hi;
		this.lo = lo;
		this.mid = (lo+hi)/2;
		if(lo==hi){
			max = new Stat(A[lo]);
		}
		else{
			left = new Node(A,lo,mid);
			right = new Node(A,mid+1,hi);
			max = new Stat(left.max,right.max);
		}
	}

	public void rupdate(int xi, int xj, int x){
		int add = x*(xj-xi+1);
		if(lo==xi&&xj==hi) max.update(x);
		else {
			this.max.sum += add;
			if(xi<=mid) left.rupdate(xi,Math.min(mid,xj),x);
			if (xj>mid) right.rupdate(Math.max(mid+1,xi),xj,x);
		}
	}
	
	public int query(int low, int high){
		int range = Math.min(high,hi)-Math.max(low,lo)+1;
		int add = range * max.add;
		//System.out.println(lo+","+hi+","+add);
		if(low<=lo&&hi<=high) return add+max.sum;
		else if(high<=mid)return add+left.query(low,high) ;
		else if (low>mid) return add +right.query(low,high);
		else return add + (left.query(low,high)+right.query(low,high));
	}

	public String toString(){
		return "("+(left==null?"":left.toString())+"["+lo+","+max+","+hi+"]"+(right==null?"":right.toString())+")";
	}

}

