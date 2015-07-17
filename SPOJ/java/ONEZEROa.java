import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;
import java.math.BigInteger;

class Main{

	public static BigInteger convert(int n){
		int size = 1;
		BigInteger ten = new BigInteger("1");
		BigInteger ret = new BigInteger("0");
		while(size<=n){
			if((n & size)==size) ret = ret.add(ten);
			size <<=1;
			ten = ten.multiply(new BigInteger("10"));
		}
		return ret;
	}

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			String Astr = br.readLine();
			int A = parseInt(Astr);
			int i = 1;
			while(convert(i).intValue()<A)i++;
			while(convert(i).mod(new BigInteger(Astr)).intValue()!=0)i++;
			System.out.println(convert(i));
		}
		br.close();
	}

}
