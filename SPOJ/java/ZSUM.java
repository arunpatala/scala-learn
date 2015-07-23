import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	static int mod = 10000007;
	public static int pow(int a, int b){
		int ret = 1;
		while(b>0){
			if(b%2==1) ret = (ret*a)%mod;
			a = (a*a)%mod;
			b = b/2;
		}
		return ret;

	}

	public static int f(int n, int k)
	{
		return (pow(n,n)+pow(n,k))%mod;
	}
	public static int fun2(int n, int k)
	{
		return ((f(n,k)-f(n-1,k))+2*(f(n-1,k)-f(n-2,k)))%mod;
	}

	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = parseInt(st.nextToken());
			int k = parseInt(st.nextToken());
			if(n==0&&k==0)break;
			//Z(n)-Z(n-1) = n^k + n^n
			System.out.println(fun2(n,k));

		}
		br.close();
	}

}
