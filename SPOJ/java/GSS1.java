import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import static java.lang.Math.*;

class Main{



	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N+1];
		int[] S = new int[N+1];
		for(int i=1;i<=N;i++) {
			A[i] = parseInt(st.nextToken());
			S[i] = S[i-1]+A[i];
		}

		System.out.println(new Node(A,0,A.length-1));
		int M = parseInt(br.readLine());
		/*(while(M--!=0)
		{
			st = new StringTokenizer(br.readLine());
			int x = parseInt(st.nextToken());
			int y = parseInt(st.nextToken());
			int mx = Integer.MIN_VALUE;
			int xs = ceil(sqrt(x));
			int ys = ceil(sqrt(y));
			for(int si=xs;si<ys;si++)
				sum += sA[si];
			for(int xi=x;xi<xs*sqrtN;xi++)
				sum 
			System.out.println(mx);
		}*/
		out.flush();
		out.close();
		br.close();
	}

}

class Node{

	Node left;
	Node right;
	int i,j;
	int[] A;
	int sum;
	public Node(int[] A, int i, int j){
		this.i = i;
		this.j = j;
		this.A = A;
		for(int k=i;k<=j;k++)sum+=A[k];
		if(i!=j){
			int mid = (i+j)/2;
			left = new Node(A,i,mid);
			right = new Node(A,mid+1,j);
		}
	}

	public String toString(){
		return "("+left+"["+i+","+j+"]"+right+")";
	}

}

