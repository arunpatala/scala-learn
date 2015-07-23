import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Main{
	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String s = br.readLine();
			if(s.equals("0 0"))break;
			StringTokenizer st = new StringTokenizer(s);
			System.out.println(new BigInteger(st.nextToken()).pow(java.lang.Integer.parseInt(st.nextToken())));
		}
	}
}
