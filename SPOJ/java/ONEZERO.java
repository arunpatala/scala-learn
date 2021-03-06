import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Math.pow;

class Main{

	public static long convert(long n){
		long size = 1;
		long ten = 1;
		long ret = 0;
		while(size<=n){
			if((n & size)==size) ret = ret + ten;
			size <<=1;
			ten = ten * 10;
		}
		return ret;
	}

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			long A = parseLong(br.readLine());
			long i = 1;
			while(convert(i)<A)i++;
			while(convert(i)%A!=0)i++;
			System.out.println(convert(i));
		}
		br.close();
	}

}

