import java.util.*;
import java.io.*;
import java.lang.*;

class Main{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		SuffixArray a = new SuffixArray(s1+"$"+s2);
		br.close();
	}
}

class SuffixArray{

	int N;
	Node[] A,B;

	public SuffixArray(String s){
		N = s.length();
		A = new Node[N];
		B = new Node[N];
		for(int i=0;i<N;i++){
			A[i]=new Node(i,s);
			B[i]=A[i];
		}
		power();
	}

	public void power()
	{
		for(int i=1;i<=N;i*=2)
		{
			sortAndRank();
			for(int j=0;j<N;j++)
			{
				A[j].rank1=A[j].rank;
				if(i+j<N)
					A[j].rank2=A[i+j].rank;
				else A[j].rank2=-1;
			}
		}
	}

	public void sortAndRank(){
		Arrays.sort(B);
		for(int i=1;i<N;i++)
			if(B[i].compareTo(B[i-1])==0)
				B[i].rank=B[i-1].rank;
			else B[i].rank=B[i-1].rank+1;
		System.out.println(Arrays.toString(B));
	}

}

class Node implements Comparable<Node>{
	int i;
	String s;
	int rank,rank1,rank2;

	public Node(int idx, String str)
	{
		s=str;
		i=idx;
		rank1=s.charAt(i)-'a';
		rank2=0;
	}
	public String toString(){
		return i+":"+substring()+":"+rank;
	}
	public String substring(){
		return s.substring(i);
	}
	public int compareTo(Node that)
	{
		if(this.rank1==that.rank1)
			return this.rank2-that.rank2;
		else return this.rank1-that.rank1;
	}
}
