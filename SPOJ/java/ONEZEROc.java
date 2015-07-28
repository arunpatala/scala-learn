import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Math.pow;

class Main{


	public static long next(long n){
		long ret = 0;
		int carry= 1;
		long pow = 1;
		while(n!=0){
			long i=n%10;
			ret = pow*((carry+i)%2)+ret;
			if(carry==1&&i==1)carry=1;
			else carry =0;
			n=n/10;
			pow = pow*10;
		}
		ret = pow*carry+ret;
		return ret;
	}

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		List<Long> li = new LinkedList<>();
		long i = 1;
		while(i<(1L<<62)){
			li.add(i);
			i = next(i);
		}
		System.out.println(li.size());
		while(T--!=0)
		{
			long A = parseLong(br.readLine());
			System.out.println(i);
		}
		br.close();
	}

}

