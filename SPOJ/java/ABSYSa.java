import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;


class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = parseInt(br.readLine());
		String[] s = new String[3];
		for(int ti=0;ti<t;ti++){
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			s[0] = st.nextToken();
			st.nextToken();
			s[1] = st.nextToken();
			st.nextToken();
			s[2] = st.nextToken();
			if(s[0].contains("m"))
				s[0]=(Integer.parseInt(s[2])-Integer.parseInt(s[1]))+"";
			else if(s[1].contains("m"))
				s[1]=(Integer.parseInt(s[2])-Integer.parseInt(s[0]))+"";
			else if(s[2].contains("m"))
				s[2]=(Integer.parseInt(s[0])+Integer.parseInt(s[1]))+"";
			
			out.printf("%s + %s = %s\n",s[0],s[1],s[2]);
		}
		out.flush();
		out.close();
		br.close();

	}
}


