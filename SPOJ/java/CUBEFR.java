import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

class Main{
	static int N = 100;
	static List<Integer> P = new LinkedList<>();
	static List<Integer> PL = new LinkedList<>();

	public static void primes(){
		boolean[] p = new boolean[N+1];
		for(int i=2;i<=N;i++)p[i]=true;
		for(int i=2;i*i<=N;i++)
			if(p[i])
			{
				for(int j=i*i;j<=N;j+=i)
					p[j]=false;
			}
		for(int i=2;i<=N;i++)
			if(p[i])P.add(i);
	}

	public static int[] toArray(List<Integer> lst)
        {
                int[] ret = new int[lst.size()];
		int c = 0;
		for(int l:lst)ret[c++]=l;
                return ret;
        }



	public static void lucky(){
		int M = 1000000;
		boolean[] L = new boolean[M+1];
		for(int pi:P)
		{
				int p3 = pi*pi*pi;
				for(int i=p3;i<=M;i+=p3)
					L[i]=true;
		}
		
		for(int i=1;i<=M;i++)
			if(!L[i])PL.add(i);


	}


	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		primes();
		lucky();
		int[] A = toArray(PL);
		int T = parseInt(br.readLine());
		int t = 1;
		while(T--!=0)
		{
			System.out.println("Case "+t+":");
			int ai = parseInt(br.readLine());
			int i  = Arrays.binarySearch(A,ai);
			if(i<0)System.out.println("Not Cube Free");
			else System.out.println(i+1);
			t++;
			
		}
		br.close();
	}

}
