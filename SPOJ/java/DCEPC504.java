import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			long N = parseLong(st.nextToken());
			long K = parseLong(st.nextToken())-1;
			long D = 1L<<62;
			boolean curr = true;
			while(D>0)
			{
				System.out.println(D);
				if((D&K)!=0){
					curr=!curr;
				}
				D>>=1;
			}
			if(curr) System.out.println("Male");
			else System.out.println("Female");
		}
	}
}
