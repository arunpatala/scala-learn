import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;

class Main{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String hay = br.readLine();
			if(hay==null)break;
			String needle = br.readLine();
			System.out.println(search(hay,needle,lps(needle)));
		}

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


	public static int search(String hay, String needle, int[] T)
	{
		int C=0;
		char[] A = hay.toCharArray();
		char[] B = needle.toCharArray();
		int j = 0, i = 0;
		while(i<hay.length())
		{
			if(A[i]==B[j]){
				j++;i++;
				if(j==B.length){
					C++;
					j=T[j-2];
				}
			}
			else if(j==0)i++;
			else j=T[j-1];

		}
		return C;
	}
}
