import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			int N = parseInt(br.readLine());
			Interval[] I = new Interval[N];
			for(int i=0;i<N;i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int s = parseInt(st.nextToken());
				int e = parseInt(st.nextToken());
				I[i] = new Interval(s,e);
			}
			Arrays.sort(I,(i1,i2)->(i1.start-i2.start));
			Arrays.sort(I,(i1,i2)->(i1.end-i2.end));
			System.out.println(Arrays.toString(I));
			int[] DP = new int[N];
			DP[0]=1;
			for(int i=1;i<I.length;i++)
			{
				Interval s = new Interval(I[i].start,I[i].start);
				int j = Arrays.binarySearch(I, s,  (u,v)->(u.end-v.end));
				if(j<0)j=-2-j;
				//if(j>=0) System.out.println(I[j]);
				//else System.out.println(-1);
				if(j<0)DP[i]=max(1,DP[i-1]);
				else DP[i]=max(1+DP[j],DP[i-1]);
				System.out.println(I[i]+","+DP[i]);
			}

		}
	}
}

class Interval{
        int start;
        int end;
        public Interval(int s, int e)
        {
                start = s;
                end = e;
        }
	public String toString(){
		return start+":"+end;
	}
}  
