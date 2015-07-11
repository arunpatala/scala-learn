import java.io.*;
import java.util.*;
import static java.lang.Math.min;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = parseInt(st.nextToken());
			int m = parseInt(st.nextToken());
			if(n==0&&m==0) break;
			st = new StringTokenizer(br.readLine());
			int nmin = Integer.MAX_VALUE;
			for(int i=0;i<n;i++)
				nmin=min(nmin,parseInt(st.nextToken()));
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<m;i++)
				if(parseInt(st.nextToken())<=nmin)
					cnt++;
			if(cnt>=2)
				out.printf("N\n");
			else out.printf("Y\n");
		}
		out.flush();
		out.close();
		br.close();
	}

}

