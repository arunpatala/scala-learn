import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = parseInt(st.nextToken());
		int K = parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for(int i=0;i<N;i++)
			A[i] = parseInt(st.nextToken());
		Arrays.sort(A);
		int i=0,j=0,ret=0;
		while(i<N&&j<N)
		{
			if(A[i]>A[j]+K)j++;
			else if(A[i]<A[j]+K)i++;
			else{
				ret++;
				i++;j++;
			}
		}
		System.out.println(ret);
	}

}
