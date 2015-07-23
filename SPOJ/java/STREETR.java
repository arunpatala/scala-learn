import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		int[] A = new int[N];
		for(int i=0;i<N;i++)
			A[i] = parseInt(br.readLine());
		int[] B = new int[N-1];
		for(int i=0;i<N-1;i++)
			B[i] = A[i+1]-A[i];
		int G = B[0];
		for(int i=0;i<N-1;i++)
			G = GCD(B[i],G);
		int ret = 0;
		for(int i=0;i<N-1;i++)
			ret += ((B[i]/G)-1);
		System.out.println(ret);
		br.close();
	}
	public static int GCD(int a, int b){
		if(b==0) return a;
		else return GCD(b,a%b);

	}

}



