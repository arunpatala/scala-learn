import java.io.*;
import java.util.*;
import static java.lang.Math.min;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		int N = T;
		int[] A = new int[T];
		int[] B = new int[T];
		int[] C = new int[T];
		int[] D = new int[T];
		for(int t=0;t<T;t++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[t] = parseInt(st.nextToken());	
			B[t] = parseInt(st.nextToken());	
			C[t] = parseInt(st.nextToken());	
			D[t] = parseInt(st.nextToken());	
		}
		int[] ab = new int[N*N];
		for(int a=0;a<T;a++)
			for(int b=0;b<T;b++)
				ab[a*N+b] = (A[a]+B[b]);
		Arrays.sort(ab);
		int[] cd = new int[N*N];
		for(int a=0;a<T;a++)
			for(int b=0;b<T;b++)
				cd[a*N+b] = C[a]+D[b];
		Arrays.sort(cd);
		int ret =0;
		for(int i:ab)
			if(Arrays.binarySearch(cd,-i)>=0)ret++;
		System.out.println(ret);

		br.close();
	}

}
