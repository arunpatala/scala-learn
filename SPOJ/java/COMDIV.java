import java.io.*;
import java.util.*;
import static java.lang.Math.min;
import static java.lang.Math.sqrt;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	
		int N = 3000;
		boolean[] primes = new boolean[N+1];
		for(int i=2;i<=N;i++)
			primes[i] = true;
		for(int i=2;i<=sqrt(N);i++)
			if(primes[i])
				for(int j=i*i;j<=N;j+=i)
					primes[j]=false;


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		for(int t=0;t<T;t++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = parseInt(st.nextToken());	
			int B = parseInt(st.nextToken());	
			int ret = 1;
			for(int i=2;i<=N;i++)
				if(primes[i])
				{
					int a = A; int ac = 0;
					while(a%i==0){a=a/i;ac++;}
					int b = B; int bc = 0;
					while(b%i==0){b=b/i;bc++;}
					ret = ret * (min(ac,bc)+1);
				}
			System.out.println(ret);
		}
		br.close();
	}

}
