import java.io.*;
import java.util.*;
import static java.lang.Math.min;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			String str1 = br.readLine();
			if(str1==null) break;
			String str2 = br.readLine();
			int[] A = new int[26];
			for(char a:str1.toCharArray())
				A[a-'a']++;
			int[] B = new int[26];
			for(char b:str2.toCharArray())
				B[b-'a']++;
			for(char c='a';c<='z';c++)
				for(int i=0;i<min(A[c-'a'],B[c-'a']);i++)
					out.printf("%c",c);
			out.printf("\n");

		}
		out.flush();
		out.close();
		br.close();
	}

}
