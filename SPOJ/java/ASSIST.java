import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

class Main{

	public static List<Integer> primes(int N){
		boolean[] p = new boolean[N+1];
		for(int i=2;i<=N;i++)p[i]=true;
		for(int i=2;i<=N;i++)
			if(p[i])
			{
				int c = i;
				for(int j=i+1;j<=N;j++)
				{
					if(p[j]){c--;}
					if(c==0){p[j]=false;c=i;}
				}
			}
		List<Integer> lst = new LinkedList<>();
		for(int i=2;i<=N;i++)
			if(p[i])
				lst.add(i);
		return lst;
	}

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> lucky = primes(40000);
		System.out.println(lucky.size());
		while(true)
		{
			int N = parseInt(br.readLine());
			if(N==0)break;
			System.out.println(lucky.get(N-1));
		}
		br.close();
	}

}
