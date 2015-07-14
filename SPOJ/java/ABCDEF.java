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


		int[] fe = new int[N*N*N];
		int cnt = 0;
		for(int a=0;a<T;a++)
			for(int b=0;b<T;b++)
				for(int c=0;c<T;c++)
					fe[cnt++] = (A[a]+A[b])*A[c];

		Arrays.sort(fe);
		System.out.println(Arrays.toString(fe));
		int ret = 0;
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				for(int k=0;k<N;k++)
				{
					int abc = A[i]*A[j]+A[k];
					int ai = Arrays.binarySearch(fe,abc);
					if(ai>=0)
					{
						while(ai>=0 && fe[ai]==abc)ai--;
						ai++;
						while(ai<N*N*N && fe[ai]==abc){ai++; ret++;}
					}
					System.out.println(abc+" "+ret);
				}

		System.out.println(ret);

		br.close();
	}

}
