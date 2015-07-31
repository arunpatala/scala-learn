import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;

class Main{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = parseInt(st.nextToken());
		int M = parseInt(st.nextToken());
		String[] S = new String[N];
		for(int i=0;i<N;i++)S[i]=br.readLine();
		for(int i=0;i<M;i++){
			String needle = br.readLine();
			int[] lps = lps(needle);
			int cnt = 0;
			for(int j=0;j<N;j++)
			{
				String hay = S[j];
				if(search(hay,needle,lps))
					cnt++;
			}
			System.out.println(cnt);
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


	public static boolean search(String hay, String needle, int[] T)
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

			if(j==B.length){return true;}
		}
		return false;
	}
}
