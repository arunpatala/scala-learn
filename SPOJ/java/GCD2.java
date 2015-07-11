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
			String A = st.nextToken();
			BigInteger Ai = new BigInteger(A);
			String B = st.nextToken();
			BigInteger Bi = new BigInteger(B);
			if(A=="0") System.out.println(0);
			else{
				int b = Bi.mod(Ai).intValue();
				int a = Ai.intValue();
				System.out.println(GCD(a,b));
			}
		}
	}

	public static int GCD(int a, int b){
		if(b==0) return a;
		else return GCD(b,a%b);

	}

}
