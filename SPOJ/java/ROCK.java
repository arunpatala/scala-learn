import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0){
			int N = parseInt(br.readLine());
			char[] A = br.readLine().toCharArray();
			int[] V = new int[N];
			for(int i=0;i<N;i++)
				if(A[i]=='1')V[i]=1;
				else V[i]=-1;
			int[] DP = new int[N];
			int[] LP = new int[N];
			DP[0]=V[0];
			LP[0]=1;
			for(int i=1;i<N;i++)
			{
				DP[i] = max(DP[i-1]+V[i],V[i]);
				if(DP[i]==DP[i-1]+V[i])LP[i]=LP[i-1]+1;
				else LP[i]=1;
			}
			for(int i=0;i<N;i++)
				System.out.print(DP[i]);
			System.out.println();
			for(int i=0;i<N;i++)
				System.out.print(LP[i]);
			System.out.println();
		}
		br.close();
	}

}
