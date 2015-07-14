import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;

class Main{

	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine()," /");
			int N = parseInt(st.nextToken());
			if(N==0)break;
			Node[] A = new Node[N];
			for(int i=0;i<N;i++)
			{
				String sc = st.nextToken();
				int ic = parseInt(st.nextToken());
				A[i] = new Node(ic,sc);
			}
			Arrays.sort(A, (a,b) -> b.i-a.i);
			for(int i=1;i<N;i++)
				A[0].insert(A[i]);
			System.out.println(A[0]);	
		}
		out.flush();
		out.close();
		br.close();
	}

}



class Node{
	int i;
	String s;
	Node left;
	Node right;
	public Node(int ic, String sc){
		i = ic; s = sc;
	}
	public void insert(Node n){
		if(n.s.compareTo(s)<0){
			if(left==null) left = n;
			else left.insert(n);
		}else{

			if(right==null) right = n;
			else right.insert(n);
		}
	}
	public String toString(){
		return "("+(left==null?"":left.toString())+""+s+"/"+i+(right==null?"":right.toString())+")";
	}

}
