import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;
import static java.lang.Math.max;

class Main{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String A = br.readLine();
			if(A==null)break;
			int N = A.length();
			int[] T = lps(reverse(A)+A);
			int L = T[2*N-1];
			System.out.println(A+reverse(A.substring(0,max(0,N-L))));
		}
	}

	public static String reverse(String str){
                StringBuffer buffer = new StringBuffer(str);
               buffer.reverse();
               return buffer.toString();
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
}

