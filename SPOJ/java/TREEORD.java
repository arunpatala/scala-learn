import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			A[i] = parseInt(st.nextToken());
		int[] B = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			B[i] = parseInt(st.nextToken());
		int[] C = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			C[i] = parseInt(st.nextToken());
		br.close();
	}


}
