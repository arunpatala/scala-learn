import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static long toLong(String s)
	{
		long ret = 0;
		char[] C = s.toCharArray();
		for(int i=0;i<C.length;i++)
		{
			int r;
			switch(C[i]){
				case 'A':r=0;break;
				case 'C':r=1;break;
				case 'T':r=2;break;
				default :r=3;break;
			}
			ret = (ret*4)+r;
		}
		return ret;
	}

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			int K = parseInt(st.nextToken());
			if(N==0&&K==0)break;
			long[] A = new long[N];
			for(int i=0;i<N;i++)
				A[i]=toLong(br.readLine());
			Arrays.sort(A);
			int[] C = new int[N+1];
			for(int i=0;i<N;)
			{
				long a = A[i++];
				int ac = 1;
				while(i<N&&A[i]==a){ac++;i++;}
				C[ac]++;
			}
			for(int i=1;i<=N;i++)
				out.printf("%d\n",C[i]);
		}
		out.flush();
		out.close();
		br.close();
	}
}
