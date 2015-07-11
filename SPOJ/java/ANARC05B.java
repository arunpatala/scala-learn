import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			if(N==0) break;
			int[] A = new int[N];
			for(int i=0;i<N;i++)A[i]=parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int M = parseInt(st.nextToken());
			int[] B = new int[M];
			for(int i=0;i<M;i++)B[i]=parseInt(st.nextToken());

			int i=0,j=0,sumA=0,sumB=0,sum=0;
			while(i<N&&j<M)
			{
				//System.out.println(i+","+j+","+sum);
				if(A[i]==B[j]) {sum += (A[i]+max(sumA,sumB)); sumA=0;sumB=0;i++;j++;}
				else if(A[i]<B[j]) sumA+=A[i++];
				else if(A[i]>B[j]) sumB+=B[j++];
			}
			while(i<N)sumA+=A[i++];
			while(j<M)sumB+=B[j++];
			sum += max(sumA,sumB);
			out.printf("%d\n",sum);
		}
		out.flush();
		out.close();
		br.close();
	}

}
