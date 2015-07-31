import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;

class Main{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		for(int t=1;t<=T;t++)
		{
			br.readLine();
			String needle = br.readLine();
			System.out.println("Test case #"+t);
			lps(needle);
			System.out.println();
		}

	}

	public static int[] lps(String needle)
	{
		int N = needle.length();
		int[] T = new int[N];
		int[] K = new int[N];
		char[] A = needle.toCharArray();
		int j = 0, i = 0;
		K[0]=1;
		T[i++]=0;
		while(i<N)
		{
			if(A[i]==A[j]){
				j++;
				T[i]=j;
				int l = i-(j-1);
				if((1+K[j-1])*l==(i+1))
					K[i]=1+K[j-1];
				else K[i]=1;
				i++;
			}else if(j==0)
			{
				T[i]=0;
				K[i]=1;
				i++;
			}
			else {
				j=T[j-1];
			}
		}
		for(i=0;i<N;i++)
			if(K[i]>1)
				System.out.println((i+1)+" "+K[i]);
		return T;
	}
}
