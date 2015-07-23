import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = br.readLine();
			if(s.equals("0 0"))break;
			StringTokenizer st = new StringTokenizer(s);
			int N = parseInt(st.nextToken());
			int D = parseInt(st.nextToken());
			System.out.println(N+" "+D+" "+meth(N,D));
		}
		br.close();
	}

	public static int meth(int n,int i)
	{
		if(n==1)return 1;
		else{
		if(n%2==0){
			if(i==1)
			{
				return(2*meth((n/2),1));
			}
			else{
				return(2*meth((n/2),2)-1);
			}
		}
		else
		{
			if(i==1)
			{
				return(2*meth(((n-1)/2),2));
			}
			else{
				return(2*meth(((n+1)/2),1)-1);
			}
		}
		}
	}
}
