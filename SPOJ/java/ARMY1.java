import java.io.*;
import java.util.*;



class Main{

	public static void main(String[] args) throws IOException{	

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		while(t--!=0){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int nmax = 0;
			for(int i=0;i<n;i++){
				int ni = sc.nextInt();
				if(ni>nmax) nmax = ni;
			}
			int mmax = 0;
			for(int i=0;i<m;i++){
				int mi = sc.nextInt();
				if(mi>mmax) mmax = mi;
			}
			if(nmax>=mmax)out.printf("Godzilla\n");
			else out.printf("MechaGodzilla\n");
		}
		out.flush();
		out.close();
		sc.close();
	}

}

