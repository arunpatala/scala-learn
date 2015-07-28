import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;

class Main{

	public static void main(String[] args) throws IOException{	
		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			char[] S = br.readLine().toCharArray();
			int[] C = new int[26];
			char maxc='E';int max=0;
			for(char c:S)
				if(c!=' ')
				{
					C[c-'A']++;
					if(C[c-'A']>max)
					{
						max=C[(int)(c-'A')];
						maxc=c;
					}
				}
			int cnt = 0;
			for(int i:C)if(i==max)cnt++;
			if(cnt!=1){out.printf("NOT POSSIBLE\n");continue;}
			StringBuffer sb = new StringBuffer();
			int d = (maxc-'E'+26)%26;
			for(char c:S)
				if(c!=' ')
					sb.append((char)('A'+(c-'A'-d+26)%26));
				else sb.append(' ');
			out.printf("%d ",d);
			out.printf(sb.toString());
			out.printf("\n");

		}
		out.flush();
		out.close();
		br.close();
	}

}
