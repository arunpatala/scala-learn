import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			char c = st.nextToken().toLowerCase().charAt(0);
			if(c=='*')break;
			boolean valid = true;
			while(valid && st.hasMoreTokens())
				if(c != st.nextToken().toLowerCase().charAt(0))
					valid = false;
			if(valid)System.out.println("YES");
			else System.out.println("NO");
		}
	}
	
}
