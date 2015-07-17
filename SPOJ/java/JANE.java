import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;
import static java.lang.Math.abs;

class Main{

	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = parseInt(st.nextToken());
		int D = parseInt(st.nextToken());
		int[] A = new int[N];
		for(int i=0;i<N;i++)
			A[i]=parseInt(br.readLine());
		boolean[][] VISIT = new boolean[N][N];
		boolean[][] VALID = new boolean[N][N];
		for(int n1=0;n1<N;n1++)
			for(int n2=0;n2<N;n2++)
			if(!VISIT[n1][n2])
			{
		List<Integer> x = new LinkedList<Integer>();
		List<Integer> y = new LinkedList<Integer>();
		x.add(n1);y.add(n2);
		VISIT[n1][n2]=true;
		boolean[][] COMP = new boolean[N][N];
		COMP[n1][n2]=true;
		while(x.size()>0)
		{
			int i = x.remove(0);
			int j = y.remove(0);
			int[] ii = new int[]{i-1,i-1,i+1,i+1};
			int[] jj = new int[]{j-1,j+1,j-1,j+1};
			for(int k=0;k<4;k++)
				if(ii[k]>=0 && jj[k]>=0 && ii[k]<N && jj[k]<N && abs(A[ii[k]]-A[jj[k]])<=D && !VISIT[ii[k]][jj[k]])// && i-1!=j-1)
					{
						x.add(ii[k]);
						y.add(jj[k]);
						VISIT[ii[k]][jj[k]]=true;
						COMP[ii[k]][jj[k]]=true;
					}
			//System.out.println(i+","+j);
			/*
			if(i!=0 && j!=0 && abs(A[i-1]-A[j-1])<=D && !VISIT[i-1][j-1])// && i-1!=j-1)
			{x.add(i-1);y.add(j-1);VISIT[i-1][j-1]=true;}
			if(i!=0 && j!=N-1 && abs(A[i-1]-A[j+1])<=D && !VISIT[i-1][j+1])// && i-1!=j+1 )
			{x.add(i-1);y.add(j+1);VISIT[i-1][j+1]=true;}
			if(i!=N-1 && j!=0 && abs(A[i+1]-A[j-1])<=D && !VISIT[i+1][j-1])// && i+1!=j-1)
			{x.add(i+1);y.add(j-1);VISIT[i+1][j-1]=true;}
			if(i!=N-1 && j!=N-1 && abs(A[i+1]-A[j+1])<=D && !VISIT[i+1][j+1])// && i+1!=j+1)
			{x.add(i+1);y.add(j+1);VISIT[i+1][j+1]=true;}
			*/
		}
		for(int i=0;i<N;i++)
			for(int j=i+1;j<N;j++)
				if(i!=j && COMP[i][j] && COMP[j][i])
					//System.out.println((i+1)+" "+(j+1));
					VALID[i][j] = true;
		}
		for(int i=0;i<N;i++)
			for(int j=i+1;j<N;j++)
				if(VALID[i][j])
					System.out.println((i+1)+" "+(j+1));
		
		br.close();
	}

}

