import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		while(N--!=0)
		{
			int K = parseInt(br.readLine())+1;
			System.out.println(solve(K).substring(1));
		}
		br.close();
	}

	public static String solve(int K){
		if(K==0) return "";
		if(K%2==0) return solve(K/2)+"5";
		else return solve(K/2)+"6";
	}

}
