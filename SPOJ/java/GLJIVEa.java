import java.io.*;
import java.util.*;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 10;
		int M = 200;
		boolean[] Z = new boolean[M+1];
		Z[0] = true;
		for(int n=0;n<N;n++)
		{
			int A = parseInt(br.readLine());
			for(int m=M;m>=0;m--)
			if(Z[m] && m+A<=M)
				Z[m+A]=true;
		}
		int ret = 0;
		for(int m=0;m<=M;m++)
			if(Z[m])
			{
				System.out.print(m+",");
				if(abs(100-m)<=abs(100-ret))
					ret=m;
			}
		System.out.println();
		System.out.println(ret);
		br.close();
	}

}

