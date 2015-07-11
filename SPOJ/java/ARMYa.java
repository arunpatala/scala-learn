import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;



class Main{

	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = parseInt(br.readLine());
		while(t--!=0){
			br.readLine();
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int nmax = 0;
			while(st.hasMoreTokens()){
				int ni = parseInt(st.nextToken());
				if(ni>nmax) nmax = ni;
			}
			int mmax = 0;
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()){
				int mi = parseInt(st.nextToken());
				if(mi>mmax) mmax = mi;
			}
			if(nmax>=mmax)out.printf("Godzilla\n");
			else out.printf("MechaGodzilla\n");
		}
		out.flush();
		out.close();
		br.close();
	}

}

