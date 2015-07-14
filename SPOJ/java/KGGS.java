import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;

class Main{

	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			A[i] = parseInt(st.nextToken());
		Node ST = new Node(A);
		int M = parseInt(br.readLine());
		while(M--!=0)
		{
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int x = parseInt(st.nextToken());
			int y = parseInt(st.nextToken());
			if(cmd.equals("Q"))
				System.out.println(ST.query(x-1,y-1));
			else {
				ST.update(x-1,y);
			}
		}
		out.flush();
		out.close();
		br.close();
	}

}

class Stat{
	int max, max2;
	public Stat(int a){
		max = a; max2 = -1;
	}
	public Stat(Stat l, Stat r){
		max = Math.max(l.max,r.max);
		int min = Math.min(l.max,r.max);
		max2 = Math.max(min,Math.max(l.max2,r.max2));
	}
	public String getValue(){
		return (max+max2)+"";
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

	public void update(int xi, int x){
		if(lo==xi&&xi==hi) max = new Stat(x);
		else {
			if(xi<=mid) left.update(xi,x);
			else if (xi>mid) right.update(xi,x);
			max = new Stat(left.max,right.max);
		}
	}
	
	public Stat query(int low, int high){
		if(low<=lo&&hi<=high) return max;
		else if(high<=mid)return left.query(low,high);
		else if (low>mid) return right.query(low,high);
		else return new Stat(left.query(low,high),right.query(low,high));
	}

	public String toString(){
		return "("+(left==null?"":left.toString())+"["+lo+","+max+","+hi+"]"+(right==null?"":right.toString())+")";
	}

}

