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
		for(int t=0;t<T;t++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[t] = parseInt(st.nextToken());	
		}
		int labc = 0;
		int[] abc = new abc[N*N*N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				for(int k=0;k<N;k++)
					abc[labc++]= A[i]*A[j]+A[k];
		Arrays.sort(abc);
		int[] abc2 = new abc[N*N*N];
		int n = 1; abc2[0] = 1;
		for(int i=1;i<labc;i++)
		{
			if(abc[i]==abc[n-1])
		}


		int ldef = 0;
		int[] def= new def[N*N*N];
		for(int a=0;a<T;a++)
			for(int b=0;b<T;b++)
				for(int c=0;c<T;c++)
					if(A[c]!=0)
						def[ldef++] = (A[a]+A[b])*A[c];
		Arrays.sort(def);



		System.out.println(ret);

		br.close();
	}

}
