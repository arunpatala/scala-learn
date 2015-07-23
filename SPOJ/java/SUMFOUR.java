import java.io.*;
import java.util.*;
import static java.lang.Math.min;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		int N = T;
		int NN = N*N;
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
		int[] ab = new int[NN];
		for(int a=0;a<T;a++)
			for(int b=0;b<T;b++)
				ab[a*N+b] = (A[a]+B[b]);
		Arrays.sort(ab);
		int[] cd = new int[NN];
		for(int a=0;a<T;a++)
			for(int b=0;b<T;b++)
				cd[a*N+b] = -(C[a]+D[b]);
		Arrays.sort(cd);
		int ret = 0;
		int i=0, j=0;
		while(i<NN&&j<NN)
		{
			if(ab[i]<cd[j])i++;
			else if(ab[i]>cd[j])j++;
			else{
				int e = ab[i];
				int e1 = 0, e2 =0;
				while(ab[i]==e){i++;e1++;}
				while(cd[j]==e){j++;e2++;}
				ret += (e1*e2);
			}
		}
		System.out.println(ret);
		br.close();
	}

}
