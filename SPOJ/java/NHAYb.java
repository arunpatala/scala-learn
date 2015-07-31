import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;

class Main{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			if(br.readLine()==null)break;
			String needle = br.readLine();
			List<Integer> lst = search(br,needle,lps(needle));
			for(int i:lst)
				System.out.println(i);
			System.out.println();
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


	public static List<Integer> search(BufferedReader br,String needle, int[] T) throws IOException
	{
		List<Integer> lst = new LinkedList<>();
		char A = (char)(br.read());
		char[] B = needle.toCharArray();
		int j = 0, i = 0;
		while(A!='\n')
		{
			if(A==B[j]){j++;A=(char)(br.read());i++;}
			else if(j==0){A=(char)(br.read());i++;}
			else j=T[j-1];

			if(j==B.length){lst.add(i-j);j=T[j-1];}
		}
		return lst;
	}
}
