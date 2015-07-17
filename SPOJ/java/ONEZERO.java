import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

class Main{

	public static int convert(int n){
		int size = 1;
		int ten = 1;
		int ret = 0;
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
			int A = parseInt(br.readLine());
			int i = 1;
			while(convert(i)<A)i++;
			while(convert(i)%A!=0)i++;
			System.out.println(convert(i));
		}
		br.close();
	}

}
