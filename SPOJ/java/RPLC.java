import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		for(int t=1;t<=T;t++)
		{
			int N = parseInt(br.readLine());
			int min = 0;
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
			{
				sum+= parseInt(st.nextToken());
				if(sum<min) min = sum;
			}
			System.out.println("Scenario #"+t+":"+((-min)+1));
		}
	}
}
