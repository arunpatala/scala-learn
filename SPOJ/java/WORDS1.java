import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = parseInt(br.readLine());
		for(int t=0;t<T;t++)
		{
			int N = parseInt(br.readLine());
			int[] C = new int[26];
			for(int i=0;i<N;i++)
			{
				String str = br.readLine();
				int s = str.charAt(0)-'a';
				int e = str.charAt(str.length()-1)-'a';
				C[s]++;C[e]--;
			}
			int s = 0,e = 0;
			for(int i=0;i<26;i++)
			{
				if(C[i]>0)s+=C[i];
				if(C[i]<0)e+=C[i];
			}
			boolean valid = (s==1)&&(e==-1);
			if(!valid) out.printf("The door cannot be opened.\n");
			else out.printf("Ordering is possible.\n");
		}
		out.flush();
		out.close();
		br.close();
	}

}
