import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

class Main{
	static int N = 3000;
	static List<Integer> P = new LinkedList<>();
	static List<Integer> PL = new LinkedList<>();

	public static void primes(){
		int N = 500 * 500;
		boolean[] p = new boolean[N+1];
		for(int i=2;i<=N;i++)p[i]=true;
		for(int i=2;i*i<=N;i++)
			if(p[i])
			{
				for(int j=i*i;j<=N;j+=i)
					p[j]=false;
				P.add(i);
			}
	}

	public static void lucky(){
		boolean[] L = new boolean[N+1];
		for(int pi:P)
			for(int pj:P)
				for(int pk:P)
					if(pi!=pj&&pj!=pk&&pk!=pi)
					{
							int pijk = pi*pj*pk;
							for(int i=pijk;i<=N;i+=pijk)
								L[i]=true;
					}
		for(int i=2;i<=N;i++)
			if(L[i])PL.add(i);


	}


	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		primes();
		lucky();
		/*for(int l:P)
			System.out.print(l+",");
		System.out.println();
		System.out.println();
		System.out.println();
		for(int l:PL)*/
		for(int i=0;i<1000;i++)
			System.out.print(PL.get(i)+",");
		System.out.println();
		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			int A = parseInt(br.readLine());
			System.out.println(PL.get(A-1));
			
		}
		br.close();
	}

}
