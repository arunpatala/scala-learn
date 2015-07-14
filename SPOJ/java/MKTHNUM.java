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
		st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for(int i=0;i<N;i++)
			A[i] = parseInt(st.nextToken());
		Node ST = new Node(A);
		System.out.println(ST);
		while(M--!=0)
		{
			st = new StringTokenizer(br.readLine());
			int x = parseInt(st.nextToken());
			int y = parseInt(st.nextToken());
			int k = parseInt(st.nextToken());
			System.out.println(ST.query(x-1,y-1).getValue(k-1));
		}
		out.flush();
		out.close();
		br.close();
	}

}

class Stat{
	int[] C;
	int length = 0;
	public Stat(int a){
		C = new int[]{a};
		length = 1;
	}


	public int getValue(int k){
		return C[k];
	}
	public String toString(){
		return getValue(0)+"";
	}
	public Stat(Stat l, Stat r){
		int[] A = l.C;
		int[] B = r.C;
		int ai=0,bi=0,ci=0;
		int al=l.length,bl=r.length;
		C = new int[al+bl];
		while(ai<al&&bi<bl){
			//if(A[ai]==B[bi]){C[ci++]=A[ai++];bi++;}
			if(A[ai]<B[bi]){C[ci++]=A[ai++];}
			else C[ci++] = B[bi++];
		}
		while(ai<al)C[ci++]=A[ai++];
		while(bi<bl)C[ci++]=B[bi++];
		length = ci;
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

