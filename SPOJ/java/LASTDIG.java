import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static int lastdig(int a, int b){
		int ret = 1;
		while(b>0){
			if(b%2==1) ret = (ret*a)%10;
			else {
				ret = (ret*a*a)%10;
			}
			b = b/2;
		}
		return ret;

	}



	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		for(int i=0;i<N;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = parseInt(st.nextToken());
			int b = parseInt(st.nextToken());
			System.out.println(lastdig(a,b));
		}
		br.close();
	}

}
