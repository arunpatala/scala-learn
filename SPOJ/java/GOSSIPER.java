import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			int M = parseInt(st.nextToken());
			if(N==0&&M==0)break;
			Map<String,Integer> map = new HashMap<>();
			BitSet[] bs = new BitSet[N];
			for(int i=0;i<N;i++)
			{
				bs[i] = new BitSet(N);
				bs[i].set(i);
				map.put(br.readLine(),i);
			}
			for(int i=0;i<M;i++)
			{
				st = new StringTokenizer(br.readLine());
				String A = st.nextToken();
				String B = st.nextToken();
				int a = map.get(A);
				int b = map.get(B);
				bs[a].or(bs[b]);
				bs[b].or(bs[a]);
			}
			boolean valid = true;
			for(int i=0;i<N&&valid;i++)
				for(int j=0;j<N&&valid;j++)
					if(!bs[i].get(j))
						valid=false;
			if(valid)System.out.println("YES");
			else System.out.println("NO");
			br.readLine();
		}
	}
}
