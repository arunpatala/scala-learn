import java.io.*;
import java.util.*;
import static java.lang.Math.min;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = parseInt(st.nextToken());
			int B = parseInt(st.nextToken());
			if(A==-1&&B==-1)break;
			if(A<B){int t=A;A=B;B=t;}
			if(A%(B+1)==0) System.out.println(A/(B+1));
			else System.out.println((A/(B+1))+1);
		}

		br.close();
	}

}
