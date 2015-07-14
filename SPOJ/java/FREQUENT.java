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
			System.out.println(ST.query(x-1,y-1).getValue());
		}
		out.flush();
		out.close();
		br.close();
	}

}

class Stat{
	int maxc,maxa,leftc,lefta,rightc,righta;
	public Stat(int a){
		maxc = leftc = rightc = 1;
		maxa = lefta = righta = a;
	}
	public Stat(Stat l, Stat r){
		if(l.maxc>r.rightc){
			maxc = l.maxc;maxa = l.maxa;
		}else{
			maxc = r.maxc;maxa = r.maxa;
		}
		if(r.lefta==l.righta && maxc<r.leftc+l.rightc)
			maxc = r.leftc+l.rightc;
		if(l.lefta==r.lefta){
			leftc=l.leftc+r.leftc;lefta=l.lefta;
			if(leftc>maxc){maxc=leftc;maxa=lefta;}
		}else{leftc=l.leftc;lefta=l.lefta;}
		if(r.righta==l.righta){
			rightc=r.rightc+l.rightc;righta=r.righta;
			if(rightc>maxc){maxc=rightc;maxa=righta;}
		}else{rightc=r.rightc;righta=r.righta;}

	}
	public int getValue(){
		return maxc;
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

