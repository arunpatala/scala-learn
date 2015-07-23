import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = br.readLine();
			if(s.equals("00e0"))break;
			int n = ((s.charAt(0)-'0')*10+(s.charAt(1)-'0'))*((int)(Math.pow(10,s.charAt(3)-'0')));
			System.out.println(n);
			int c=1;
			while (c<=n)
				 c<<=1;
			int ans=((n-(c>>1))<<1)+1;
			System.out.println(ans);
		}
		br.close();
	}

	public static int jo(int N, int K){
		if(N==1) return 1;
		return (jo(N-1,K) + K-1 )%N + 1;
	}

	public static int jo2(int N, int K){
		int ret = 1;
		for(int i=2;i<=N;i++)
				ret = (ret+K-1)%N + 1;
		return ret;
	}

}
