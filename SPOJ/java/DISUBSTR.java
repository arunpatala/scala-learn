import java.util.*;
import java.io.*;
import java.lang.*;
import static java.lang.Math.*;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			String s = br.readLine();
			SuffixArray a = new SuffixArray(s);
			System.out.println(a.LPA());
		}
		br.close();
	}
}

class SuffixArray{

	int N;
	Node[] A;

	public SuffixArray(String s){
		N = s.length();
		A = new Node[N];
		for(int i=0;i<N;i++)
			A[i]=new Node(i,s.substring(i));
		Arrays.sort(A, (u,v)->u.s.compareTo(v.s));
		//System.out.println(Arrays.toString(A));
	}

	public int LPA()
	{
		int[] P = new int[N];
		for(int i=1;i<N;i++)
			P[i]=LPA(A[i-1].s,A[i].s);
		int count = 0;
		for(int i=0;i<N;i++)
			count+=(A[i].s.length()-P[i]);
		return count;	
	}

	public int LPA(String A, String B)
	{
		int i=0;
		for(i=0;i<min(A.length(),B.length());i++)
			if(A.charAt(i)!=B.charAt(i))
				return i;
		return i;
	}

}

class Node{
	int index;
	String s;

	public Node(int i, String str)
	{
		s=str;
		index=i;
	}
	public String toString(){
		return index+":"+s;
	}
}
