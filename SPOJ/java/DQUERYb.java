import java.io.*;
import java.lang.*;
import java.util.*;
import static java.lang.Integer.parseInt;


class Node{
	int sum = 0;
	public Node(int a){
		sum = a;
	}
	public Node(Node l, Node r){
		sum = l.sum + r.sum;
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
	public void build(int[] C){build(C,1,0,C.length-1);}
	public void build(int[] C, int i, int lo, int hi){
		if(lo==hi)nodes[i]=new Node(C[lo]);
		else{
			int mid = (lo+hi)/2, l=2*i, r=2*i+1;
			build(C,l,lo,mid);
			build(C,r,mid+1,hi);
			nodes[i] = new Node(nodes[l],nodes[r]);
		}
	}
	public int query(int i, int j){return query(1,0,L-1,i,j).sum;}
	public Node query(int idx, int lo,int hi, int i, int j){
		if(lo==i&&j==hi)return nodes[idx];
		else{
			int mid = (lo+hi)/2, l=2*idx, r=2*idx+1;
			if(j<=mid) return query(l,lo,mid,i,j);
			if(mid<i) return query(r,mid+1,hi,i,j);
			Node left = query(l,lo,mid,i,mid);
			Node right = query(r,mid+1,hi,mid+1,j);
			return new Node(left,right);
		}
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
		int N = parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			A[i] = parseInt(st.nextToken());

	for (int i = 0; i < n; ++i) {
		if (posOfLast[a[i]] != -1)
			cnt[posOfLast[a[i]]]--;
		posOfLast[a[i]] = i;
		cnt[posOfLast[a[i]]]++;

		Tree ST = new Tree(A);
		int M = parseInt(br.readLine());
		while(M--!=0)
		{
			st = new StringTokenizer(br.readLine());
			int i = parseInt(st.nextToken());
			int j = parseInt(st.nextToken());
			out.printf(ST.query(i-1,j-1)+"\n");
			//System.out.println(ST);
		}
                out.flush();
                out.close();
                br.close();
        }

}

