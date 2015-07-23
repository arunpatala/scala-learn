import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;
import java.math.BigInteger;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = parseInt(st.nextToken());
			int B = parseInt(st.nextToken());
			int G = GCD(A,B);
			System.out.println((B/G)+" "+(A/G));
		}
	}

	public static int GCD(int a, int b){
		if(b==0) return a;
		else return GCD(b,a%b);

	}

}
