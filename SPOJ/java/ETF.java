import java.io.*;
import java.util.*;
import static java.lang.Math.min;
import static java.lang.Math.sqrt;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	
		int N = 1000;
		boolean[] primes = new boolean[N+1];
		for(int i=2;i<=N;i++)
			primes[i] = true;
		for(int i=2;i<=sqrt(N);i++)
			if(primes[i])
				for(int j=i*i;j<=N;j+=i)
					primes[j]=false;
		List<Integer> li = new LinkedList<Integer>();
		for(int i=2;i<=N;i++)if(primes[i]) li.add(i);


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		for(int t=0;t<T;t++)
		{
			int A = parseInt(br.readLine());
			int ret = A;
			for(int i:li)
				if(((A%i)==0))
				{
					ret = (ret*(i-1))/i;
				}
			System.out.println(ret);
		}
		br.close();
	}

}
