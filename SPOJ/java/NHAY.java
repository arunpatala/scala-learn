import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String N = br.readLine();
			if(N==null)break;
			String A = br.readLine();
			KMP kmp = new KMP(A.toCharArray());
			String B = br.readLine();
		}
	}
}

class KMP{
	
	public KMP(char[] A){
		int N = A.length;
		int[] T = new int[N];
		//T[i] contains such that 0...T[i] is suffix of 0....i
		T[0]=-1;
		int p=-1,i=1;
		while(i<N){
			System.out.println(i+","+p);
			if(A[p+1]==A[i]){T[i]=p+1;p++;i++;}
			else if(p==-1){T[i]=p;i++;}
			else p = T[p];
		}
		System.out.println(Arrays.toString(A));
	}

}
