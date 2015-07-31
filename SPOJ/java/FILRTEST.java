import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;

class Main{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int N = parseInt(st.nextToken());
			if(N==-1)break;
			String A = st.nextToken();
			int M = A.length();
			int[] T = lps(A);
			int K = T[M-1];
			if(L<N)System.out.println(0);
			else if(M==K)System.out.println(N);
			else System.out.println(N/(M-K));
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
}
