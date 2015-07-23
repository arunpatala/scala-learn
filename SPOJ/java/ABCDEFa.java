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


		int[] abc = new int[N*N*N];
		for(int i=0;i<N*N*N;i++)abc[i]=Integer.MAX_VALUE;
		int cnt = 0;
		for(int a=0;a<T;a++)
			for(int b=0;b<T;b++)
				for(int c=0;c<T;c++)
					if(A[c]!=0)
						abc[cnt++] = (A[a]+A[b])*A[c];
		int size1 = cnt;
		Arrays.sort(abc);

		cnt = 0;
		int[] def = new int[N*N*N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				for(int k=0;k<N;k++)
					def[cnt++] = A[i]*A[j]+A[k];
		Arrays.sort(def);

		int i=0;int j=0;
		int size2 = N*N*N;
		int ret = 0;
		while(i<size1 && j<size2)
		{
			if(abc[i]<def[j])i++;
			else if(abc[i]>def[j])j++;
			else{
				int a = abc[i];
				int d = def[j];
				int ai = 0;
				int di = 0;
				while(i<size1 && abc[i]==a){i++;ai++;}
				while(j<size2 && def[j]==d){j++;di++;}
				ret += (ai*di);
			}
		}
		System.out.println(ret);

	}

}
