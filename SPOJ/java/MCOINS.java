import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = parseInt(st.nextToken();
		int L = parseInt(st.nextToken();
		int M = parseInt(st.nextToken();
		int[] N = new int[M];
		for(int i=0;i<N;i++)
			N[i] = parseInt(st.nextToken());
		for(int i=0;i<N;i++)
			if(play(N[i]))System.out.print("A");
			else System.out.print("B");
	}

	public static boolean play(int K, int L, int N)
	{
		if(N<K) return N%2==1;
		else if(N<L) 
		
	}
}
