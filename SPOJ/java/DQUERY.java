import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;

class Main{

	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for(int i=0;i<N;i++)
			A[i] = parseInt(st.nextToken());
		Node ST = new Node(A);
		System.out.println(ST);
		int M = parseInt(br.readLine());
		while(M--!=0)
		{
			st = new StringTokenizer(br.readLine());
			int x = parseInt(st.nextToken());
			int y = parseInt(st.nextToken());
			System.out.println(ST.query(x-1,y-1).getValue());
		}
		out.flush();
		out.close();
		br.close();
	}

}

class Stat{
	Set<Integer> dist = new TreeSet();
	public Stat(int a){
		dist.add(a);
	}
	public Stat(Stat l, Stat r){
		dist.addAll(l.dist);
		dist.addAll(r.dist);
	}
	public int getValue(){
		return dist.size();
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

