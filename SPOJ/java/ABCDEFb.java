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
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				for(int k=0;k<N;k++)
				{
					int abc = A[i]*A[j]+A[k];
					if(!map.containsKey(abc))map.put(abc,0);
					map.put(abc,map.get(abc)+1);
				}


		int ret = 0;

		for(int a=0;a<T;a++)
			for(int b=0;b<T;b++)
				for(int c=0;c<T;c++)
					if(A[c]!=0)
					{
						int abc = (A[a]+A[b])*A[c];
						if(map.containsKey(abc))
							ret += map.get(abc);
					}



		System.out.println(ret);

		br.close();
	}

}
