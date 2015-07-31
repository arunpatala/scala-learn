import java.util.*;
import java.io.*;
import java.lang.*;

class Main{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		SuffixArray a = new SuffixArray(s+"$");
		br.close();
	}
}

class SuffixArray{

	int N;
	Node[] A,B,C;

	public SuffixArray(String s){
		N = s.length();
		A = new Node[N];
		B = new Node[N];
		C = new Node[N];
		for(int i=0;i<N;i++){
			A[i]=new Node(i,s);
			B[i]=A[i];
		}
		Arrays.sort(B);
		for(int i=0;i<N;i++){
			if(i==0||s.charAt(B[i].idx)!=s.charAt(B[i-1].idx))
				B[i].b=new Bucket(i);
			else B[i].b=B[i-1].b;
		}
		for(int i=1;i<N;i<<=2)
			solve(i);
		for(int i=0;i<N;i++)
			System.out.println(B[i].idx);

	}

	public void solve(int h){
		for(int i=0;i<N;i++)
		{
			int j=B[i].idx-h;
			if(j>=0){
				int k=A[j].b.idx++;
				C[k]=A[j];
				C[k].b2=B[i].b;
			}
		}
		for(int i=0;i<N;i++)
			if(C[i]==null)
				{
					C[i]=B[i];
					C[i].b=new Bucket(i);
				}
		B=C;
		B[0].b.idx=0;
		System.out.println(this);
		for(int i=1;i<N;i++)
		{
			if(B[i].b==B[i-1].b&&B[i].b2==B[i-1].b2)
				B[i].b=B[i-1].b;	
			else B[i].b=new Bucket(i);
		}
	}

	public String toString(){
		return Arrays.toString(B);
	}

}

class Bucket{
	int idx;
	public Bucket(int i){
		idx=i;
	}
}

class Node implements Comparable<Node>{
	int idx;
	String s;
	Bucket b;
	Bucket b2;

	public Node(int i, String str)
	{
		s=str;
		idx=i;
	}
	public String toString(){
		return idx+":"+substring()+":"+b.idx+":"+(b2==null?-1:b2.idx);
	}
	public String substring(){
		return s.substring(idx);
	}
	public int compareTo(Node that)
	{
		return s.charAt(idx)-that.s.charAt(that.idx);
	}
}
