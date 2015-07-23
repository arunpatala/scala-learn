import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int prev=0;
			int max=0;
			int cnt=0;
			while(st.hasMoreTokens())
			{
				int len = st.nextToken().length();
				if(prev==len)cnt++;
				else {prev=len;cnt=1;}
				if(max<cnt)max=cnt;
			}
			System.out.println(max);
		}

	}
}
