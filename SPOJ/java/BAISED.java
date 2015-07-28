import java.io.*;
import java.util.*;
import static java.lang.Math.abs;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			br.readLine();
			int N = parseInt(br.readLine());
			int[] A = new int[N];
			for(int i=0;i<N;i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				A[i]=parseInt(st.nextToken());
			}
			Arrays.sort(A);
			long sum = 0;
			for(int i=1;i<=N;i++)
				sum+=abs(i-A[i-1]);
			System.out.println(sum);
		}
	}
}
