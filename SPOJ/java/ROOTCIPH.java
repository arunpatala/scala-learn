import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		while(N--!=0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = parseLong(st.nextToken());
			long b = parseLong(st.nextToken());
			System.out.println(a*a-2*b);
		}
		br.close();
	}

}
