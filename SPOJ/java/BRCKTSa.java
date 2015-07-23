import java.io.*;
import java.lang.*;
import java.util.*;
import static java.lang.Integer.parseInt;

class Node{
	int left;
	int right;
	char c;
	public Node(){};
	public Node(char cc){
		c=cc;
		update();
	}
	public Node(Node l, Node r){
		int min = Math.min(l.right,r.left);
		left = l.left+r.left-min;
		right = l.right+r.right-min;
	}
	public void flip(){
		c=(char)('('+')'-c);	
		update();
	}
	public void update(){
		if(c==')'){left=1;right=0;}
		else if(c=='(') {left=0;right=1;}
	}
	public boolean query(){
		return left==0&&right==0;
	}
	public String toString(){
		return left+","+right;
	}
}
class Tree{
	Node[] nodes;
	int N,L;
	public Tree(char[] C){
		L = C.length;
		int N = size(L);
		nodes = new Node[N];
		build(C);
	}
	public void build(char[] C){build(C,1,0,C.length-1);}
	public void build(char[] C, int i, int lo, int hi){
		if(lo==hi)nodes[i]=new Node(C[lo]);
		else{
			int mid = (lo+hi)/2, l=2*i, r=2*i+1;
			build(C,l,lo,mid);
			build(C,r,mid+1,hi);
			nodes[i] = new Node(nodes[l],nodes[r]);
		}
	}
	public void update(int j){update(1,0,L-1,j);}
	public void update(int i, int lo, int hi, int j){
		if(lo==hi)nodes[i].flip();
		else{
			int mid = (lo+hi)/2, l=2*i, r=2*i+1 ;
			if(j<=mid)update(l,lo,mid,j);
			else update(r,mid+1,hi,j);
			nodes[i]= new Node(nodes[l],nodes[r]);
		}
	}
	public String query(){
		if(nodes[1].query())
			return "YES";
		else return "NO";
	}
	public int size(int N){
		int size = 1;
		while(size<N)size<<=1;
		return size<<1;
	}
}
class Main{

        public static void main(String[] args) throws IOException{

                PrintWriter out = new PrintWriter(System.out);
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;t++){
			out.printf("Test %d:\n",t);
			int N = parseInt(br.readLine());
			char[] S = br.readLine().toCharArray();
			Tree ST = new Tree(S);
			int M = parseInt(br.readLine());
			while(M--!=0)
			{
				int c = parseInt(br.readLine());
				if(c==0)
					out.printf(ST.query()+"\n");
				else {
					ST.update(c-1);
				}
				//System.out.println(ST);
			}
		}
                out.flush();
                out.close();
                br.close();
        }

}

