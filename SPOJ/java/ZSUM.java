import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

class Main{

	static long mod = 10000007;
	public static long pow(long a, long b){
		long ret = 1;
		while(b>0){
			if(b%2==1) ret = (ret*a)%mod;
			a = (a*a)%mod;
			b = b/2;
		}
		return ret;

	}

	public static long f(long n, long k)
	{
		return (pow(n,n)+pow(n,k))%mod;
	}
	public static long fun2(long n, long k)
	{
		return (f(n,k)+2*f(n-1,k))%mod;
	}

	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			long n = parseLong(st.nextToken());
			long k = parseLong(st.nextToken());
			if(n==0&&k==0)break;
			//Z(n)-Z(n-1) = n^k + n^n
			System.out.println(fun2(n,k));

			//System.out.println(pow(n,k));
		}
		br.close();
	}

}
