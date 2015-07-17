import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

class Main{

	static boolean[] prime = primes(10000);

	public static boolean[] primes(int N){
		boolean[] p = new boolean[N+1];
		for(int i=2;i<=N;i++)p[i]=true;
		for(int i=2;i*i<=N;i++)
			if(p[i])
			for(int j=i*i;j<=N;j+=i)
				p[j]=false;
		return p;
	}

	public static List<Integer> neigh(int at){
		List<Integer> ret = new LinkedList<Integer>();
		for(int i = 0; i < 4;i++)
		{
			for(int j = 0; j < 10;j++)
			{
				int pow = (int)(pow(10,i));
				int num = at%pow + j*pow + (at/(pow*10))*pow*10;
				if(num>=1000&&prime[num])
					ret.add(num);
			}
		}
		return ret;
	}
	public static int BFS(int A, int B)
	{
		boolean[] V = new boolean[10000];
		List<Integer> q = new LinkedList<Integer>();
		q.add(A);
		V[A] = true;
		int steps = 0;
		while(q.size()>0 ){
			List<Integer> qnew = new LinkedList<Integer>();
			for(int C:q)
			{
				if(C==B) return steps;
				for(int ci:neigh(C))
					if(!V[ci]){
						V[ci] = true;
						qnew.add(ci);
					}
			}
			q = qnew;
			steps = steps + 1;
			//System.out.println(q);
		}
		return -1;
	}

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = parseInt(st.nextToken());
			int B = parseInt(st.nextToken());
			int ret = BFS(A,B);
			if(ret==-1) System.out.println("Impossible");
			else System.out.println(ret);
		}
		br.close();
	}

}
