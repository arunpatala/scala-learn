import java.util.*;
import java.io.*;

class Main{

	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(lps("AABAACAABAA")));
		System.out.println(search("AABAACAADAABAAABAA","AABA",lps("AABA")));		
	}

	public static List<Integer> search(String hay, String needle)
	{
		List<Integer> ret = new LinkedList<>();
		for(int i=0;i<hay.length()-needle.length();i++)
		{
			boolean match = true;
			for(int j=0;j<needle.length()&&match;j++)
				if(needle.charAt(j)!=hay.charAt(i+j))
					match=false;
			if(match) ret.add(i);
		}
		return ret;
	}

	public static int[] lps(String needle)
	{
		int N = needle.length();
		int[] T = new int[N];
		char[] A = needle.toCharArray();
		int j = 0, i = 0;
		T[i++]=0;
		while(i<N)
		{
			if(A[i]==A[j]){
				j++;
				T[i]=j;
				i++;
			}else if(j==0)
			{
				T[i]=0;
				i++;
			}
			else {
				j=T[j-1];
			}
		}
		return T;
	}


	public static List<Integer> search(String hay, String needle, int[] T)
	{
		List<Integer> lst = new LinkedList<>();
		char[] A = hay.toCharArray();
		char[] B = needle.toCharArray();
		int j = 0, i = 0;
		while(i<hay.length())
		{
			if(A[i]==B[j]){j++;i++;}
			else if(j==0)i++;
			else j=T[j-1];

			if(j==B.length){lst.add(i-j);j=T[j-1];}
		}
		return lst;
	}

	public static int[] lps_old(String A)
	{
		int N = A.length();
		int[] D = new int[N];
		for(int i=0;i<N;i++)
		{
			for(int l=i;l>=0;l--)
			{
				boolean match = true;
				//check A[j-1..0] matches A[j..]
				for(int j=i;i-j<l;j--)
					if(A.charAt(j)!=A.charAt(l-(i-j+1)))match=false;
				if(match){ D[i]=l;break;}
			}
		}
		return D;
	}
}
