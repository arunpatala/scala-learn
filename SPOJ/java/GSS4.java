import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;

class Main{

	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		char[] S = br.readLine().toCharArray();
		int[] A = new int[N];
		for(int i=0;i<N;i++)
			A[i] = S[i];
		int flip = '('+')';
		Node ST = new Node(A);
		int M = parseInt(br.readLine());
		while(M--!=0)
		{
			int c = parseInt(br.readLine());
			if(c==0)
				System.out.println(ST.max.getValue());
			else {
				int i = c-1;
				A[i] = flip - A[i];
				ST.update(i,A[i]);
			}
			//System.out.println(ST);
		}
		out.flush();
		out.close();
		br.close();
	}

}

class Stat{
	int sum = 0;
	int size = 0;
	public Stat(int a){
		sum = a;
		size = 1;
	}
	public Stat(Stat l, Stat r){
		sum = l.sum + r.sum;
	}
	public String getValue(){
		return sum+"";
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
		if(lo==xi&&xi==hi) max = new Stat(x);
		else {
			if(xi<=mid) left.update(xi,x);
			else if (xi>mid) right.update(xi,x);
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

