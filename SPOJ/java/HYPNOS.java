import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static int brk(int n){
		int ret = 0;
		while(n>0){
			ret += ((n%10)*(n%10));
			n = n/10;
		}
		return ret;
	}

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = parseInt(br.readLine());
		int steps = 0;
		boolean[] S = new boolean[1000];
		if(t>=1000){
			 t = brk(t);
			 steps++;
		}
		while(t!=1){
			int temp = brk(t);
			if(S[temp]) {steps=-1;break;}
			S[temp] = true;
			t = temp;
			steps++;
		}
		System.out.println(steps);
		br.close();
	}

}

