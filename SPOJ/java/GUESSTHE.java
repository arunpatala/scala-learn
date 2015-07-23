import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String s = (br.readLine());
			if(s.equals("*"))break;
			char[] C = s.toCharArray();
			boolean[] div = new boolean[21];
			boolean valid = true;
			if(C[0]=='N')valid=false;
			for(int i=2;i<=C.length&&i<=20&&valid;i++)
			{
				if(C[i-1]=='Y') {
					for(int j=i;j<=20;j+=i)
						div[j]=true;
				}
				else{
					if(div[i])valid=false;
				}
			}
			if(valid)
			{
				int lcm = 1;
				for(int i=2;i<=C.length&&i<=20;i++)
					if(div[i])
						lcm = LCM(lcm,i);
				System.out.println(lcm);
			}
			else 
				System.out.println(-1);
		}
	}
	 public static int LCM(int a, int b){
		return (a*b)/GCD(a,b);
	}
	 public static int GCD(int a, int b){
                if(b==0) return a;
                else return GCD(b,a%b);

        }

}
