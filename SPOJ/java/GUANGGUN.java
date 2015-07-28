import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Main{
	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		for(int i=1;i<400;i++)
		{
			s+="1";
			BigInteger bi = new BigInteger(s);
			System.out.println(bi.multiply(bi));
		}
	}
}
