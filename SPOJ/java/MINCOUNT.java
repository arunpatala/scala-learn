import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int N = parseInt(br.readLine());
		while(N--!=0)
		{
			long H = parseLong(br.readLine());
			/*
			// odd  5 : 5-1, 4-2, 3-3, 
			if(H%2==1){
				//H-1, H-1-2, ..., H-(k-1)-k = 0
				k = (H-1)/2;
				//0, 2, 4, .... H-1
				(k*(k+1))/2;
			}
			// even 4 : 4-2, 3-3
			*/
			System.out.println(solve(H));
			
		}
		
		br.close();
	}
	public static long solve( long N )
	    {
		if( (N&1)==0)
		    return ( N >> 1 ) * ( N + 1 )/3 ;
		else
		    return ( ( N + 1 ) >> 1 ) * N/3 ;
	    }

}
