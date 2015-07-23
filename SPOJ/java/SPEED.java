import java.io.*;
import java.util.*;
import static java.lang.Math.abs;
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
			int G = GCD(abs(A),abs(B)); 
			System.out.println(abs(A-B)/G);
		}
	}

	public static int GCD(int a, int b){
		if(b==0) return a;
		else return GCD(b,a%b);

	}

}
