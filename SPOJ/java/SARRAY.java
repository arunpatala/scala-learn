import java.util.*;
import java.io.*;
import java.lang.*;

class Main{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		SuffixArray a = new SuffixArray(s);
		br.close();
	}
}

class SuffixArray{

	int N;
	String s;
	Node[] A,B;

	public SuffixArray(String s){
		this.s=s;
		N = s.length();
		A = new Node[N];
		B = new Node[N];
		for(int i=0;i<N;i++){
			A[i]=new Node(i,s);
			B[i]=A[i];
		}
		power();
		for(int i=0;i<N;i++)
			System.out.println(B[i].i);
	}

	public void power()
	{
		sort1();
		calcNext(1);
		//System.out.println(Arrays.toString(B));
		for(int i=2;i<=N;i*=2)
		{
			sortAndRank();
			//System.out.println(Arrays.toString(B));
			calcNext(i);
		}
	}

	public void calcNext(int i)
	{
		for(int j=0;j<N;j++)
			{
				A[j].rank1=A[j].rank;
				if(i+j<N)
					A[j].rank2=A[i+j].rank;
				else A[j].rank2=-1;
			}
	}

	public void sortAndRank(){
		//Arrays.sort(B);
		csort(B);
		bsort(B);
		rank(B);
	}

	public void rank(Node[] B){
		for(int i=1;i<N;i++)
			if(B[i].compareTo(B[i-1])==0)
				B[i].rank=B[i-1].rank;
			else B[i].rank=B[i-1].rank+1;
	}

	public void sort1(){
		asort(B);
		rank(B);
	}
	public void asort(Node[] C){
		int size = 'z'-'0';
		//List<Node>[] lst = (List<Node>[])(new Object[size]);
		List<Node>[] lst = new LinkedList[size];

		for(int i=0;i<size;i++)lst[i]=new LinkedList<>();
		for(Node c:C)
			lst[s.charAt(c.i)-'0'].add(c);
		int i=0,j=0,k=0;
		for(j=0;j<size;j++)
		{
			for(Node c:lst[j])
			{
				c.rank=i;
				C[k++]=c;
			}
			if(lst[j].size()>0)i++;
		}
	}
	public void bsort(Node[] C)
	{
		int size = N;
		List<Node>[] lst = new LinkedList[size];
		for(int i=0;i<size;i++)lst[i]=new LinkedList<>();
		for(Node c:C)
			lst[c.rank1].add(c);
		int i=0,j=0,k=0;
		for(j=0;j<size;j++)
		{
			for(Node c:lst[j])
			{
				c.rank=i;
				C[k++]=c;
			}
			if(lst[j].size()>0)i++;
		}
	}
	public void csort(Node[] C)
	{
		int size = N+1;
		List<Node>[] lst = new LinkedList[size];
		for(int i=0;i<size;i++)lst[i]=new LinkedList<>();
		for(Node c:C)
			lst[c.rank2+1].add(c);
		int i=0,j=0,k=0;
		for(j=0;j<size;j++)
		{
			for(Node c:lst[j])
			{
				c.rank=i;
				C[k++]=c;
			}
			if(lst[j].size()>0)i++;
		}
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
