import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String str = br.readLine();
			if(str.equals("bye"))break;
			int N = str.length();
			int[] A = new int[N];
			for(int i=0;i<N;i++)
				A[i]=str.charAt(i);

		}
	}
}
