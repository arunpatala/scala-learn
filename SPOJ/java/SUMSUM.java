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
		int[] XOR = new int[N-1];
		int[] OR = new int[N-1];
		int[] AND = new int[N-1];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			A[i] = parseInt(st.nextToken());
		for(int i=0;i<N-1;i++){
			XOR[i] = A[i] ^ A[i+1];
			AND[i] = A[i] & A[i+1];
			OR[i] = A[i] | A[i+1];
		}
		Node ST_XOR = new Node(XOR);
		Node ST_AND = new Node(AND);
		Node ST_OR = new Node(OR);
		while(M--!=0)
		{
			st = new StringTokenizer(br.readLine());
			int cmd = parseInt(st.nextToken());
			if(cmd==2){
				String op = (st.nextToken());
				int x = parseInt(st.nextToken());
				int y = parseInt(st.nextToken());
				if(op.equals("OR")){
					System.out.println(ST_OR.query(x-1,y-2).getValue()+(A[x-1]|A[y-1]));
				}
				if(op.equals("XOR")){
					System.out.println(ST_XOR.query(x-1,y-2).getValue()+(A[x-1]^A[y-1]));
				}
				if(op.equals("AND")){
					System.out.println(ST_AND.query(x-1,y-2).getValue()+(A[x-1]&A[y-1]));
				}

			}
			else {
				int y = parseInt(st.nextToken());
				int x = parseInt(st.nextToken())-1;
				A[x] = y;
				if(x+1<N){
					ST_OR.update(x,A[x]|A[x+1]);
					ST_XOR.update(x,A[x]^A[x+1]);
					ST_AND.update(x,A[x]&A[x+1]);
				}
				if(x-1>=0){
					ST_OR.update(x-1,A[x]|A[x-1]);
					ST_XOR.update(x-1,A[x]^A[x-1]);
					ST_AND.update(x-1,A[x]&A[x-1]);
				}
			}
			System.out.println(ST_OR);
		}
		out.flush();
		out.close();
		br.close();
	}

}

class Stat{
	int sum;
	public Stat(int a){
		sum = a;
	}
	public Stat(Stat l, Stat r){
		sum = l.sum + r.sum;
		//System.out.println(sum +"="+ l.sum +"+"+ r.sum);
	}
	public int getValue(){
		return sum;
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

