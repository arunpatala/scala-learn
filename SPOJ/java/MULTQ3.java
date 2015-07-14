import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;

class Main{

	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = parseInt(st.nextToken());
		int M = parseInt(st.nextToken());
		int[] A = new int[N];
		Node ST = new Node(A);
		while(M--!=0)
		{
			st = new StringTokenizer(br.readLine());
			int c = parseInt(st.nextToken());
			int p = parseInt(st.nextToken());
			int q = parseInt(st.nextToken());
			if(c==1)
				System.out.println(ST.query(p,q));
			else {
				ST.rupdate(p-1,q-1);
			}
			//System.out.println(ST);
		}
		out.flush();
		out.close();
		br.close();
	}

}

class Stat{
	int[] count = new int[3];
	int add;
	public Stat(int a){
		count[a%3]++;
	}
	public Stat(Stat l, Stat r){
		for(int i=0;i<3;i++)
			count[i] = l.count[(i+l.add)%3]+r.count[(i+r.add)%3];
	}
	public void update(){
		add = (add+1)%3;
	}
	public int getValue(){
		return count[0];
	}
	public String toString(){
		return getValue()+"";
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

	public void rupdate(int xi, int xj){
		if(lo==xi&&xj==hi) max.update();
		else {
			if(xi<=mid) left.rupdate(xi,Math.min(mid,xj));
			if (xj>mid) right.rupdate(Math.max(mid+1,xi),xj);
			max = new Stat(left.max,right.max);
		}
	}
	
	public Stat query(int low, int high){
		//System.out.println(lo+","+hi+","+add);
		if(low<=lo&&hi<=high) return max;
		else if(high<=mid)return new Stat(left.query(low,high),right.max) ;
		else if (low>mid) return new Stat(left.max,right.query(low,high));
		else return new Stat(left.query(low,high),right.query(low,high));
	}

	public String toString(){
		return "("+(left==null?"":left.toString())+"["+lo+","+max+","+hi+"]"+(right==null?"":right.toString())+")";
	}

}

