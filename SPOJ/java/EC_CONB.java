import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int N = parseInt(br.readLine());
		while(N--!=0)
		{
			int A = parseInt(br.readLine());
			if(A%2==0){
				String s = Integer.toBinaryString(A);
				StringBuffer sb = new StringBuffer(s);
				sb.reverse();
				int B = Integer.parseInt(sb.toString(), 2);
				System.out.println(B);
			}
			else System.out.println(A);
		}
	}
}
