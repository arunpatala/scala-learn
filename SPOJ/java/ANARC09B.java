import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;
import java.math.BigInteger;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = parseInt(st.nextToken());
			int B = parseInt(st.nextToken());
			if(A==0&&B==0)break;
			// A * a = B * b
			// ac * G * a = bc * G * b
			int G = GCD(A,B);
			System.out.println((A/G)*(B/G));

		}
	}

	public static int GCD(int a, int b){
		if(b==0) return a;
		else return GCD(b,a%b);

	}

}
