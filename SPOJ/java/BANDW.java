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
			String A = st.nextToken();
			String B = st.nextToken();
			if(A.equals("*")&&B.equals("*")) break;
			boolean insame=true;
			int cnt = 0;
			for(int i=0;i<A.length();i++)
			{
				if(A.charAt(i)==B.charAt(i)){
					if(!insame) cnt++;
					insame=true;
				}
				else{
					insame=false;
				}
			}
			if(!insame)cnt++;
			System.out.println(cnt);
		}
	}

}
