import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int W = parseInt(st.nextToken());
			int H = parseInt(st.nextToken());
			int M = parseInt(st.nextToken());
			int[] X = new int[M+2];
			X[0]=0;X[M+1]=W+1;
			int[] Y = new int[M+2];
			Y[0]=0;Y[M+1]=H+1;
			for(int i=1;i<=M;i++)
			{
				st = new StringTokenizer(br.readLine());
				X[i] = parseInt(st.nextToken());
				Y[i] = parseInt(st.nextToken());
			}
			Arrays.sort(X);
			Arrays.sort(Y);
			int xmax=0,ymax=0;
			for(int i=1;i<=M+1;i++)
			{
				xmax = max(xmax,X[i]-X[i-1]-1);
				ymax = max(ymax,Y[i]-Y[i-1]-1);
			}
			System.out.println(xmax*ymax);
			
		}
	}
}

