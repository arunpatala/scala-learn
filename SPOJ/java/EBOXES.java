import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = parseInt(br.readLine());
		while(M--!=0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			int K = parseInt(st.nextToken());
			int T = parseInt(st.nextToken());
			int F = parseInt(st.nextToken());
			int ret = (N+(F-N)*K/(K-1));
			System.out.println(ret);
		}
	}

}
