import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{
	public static String reverse(String str){
		StringBuffer buffer = new StringBuffer(str);
	       buffer.reverse();
	       return buffer.toString();
	}


	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= parseInt(br.readLine());
		for(int i=0;i<N;i++){
			String s = br.readLine();
			System.out.println(s);
			System.out.println(reverse(s));
			if(s.equals(reverse(s)))System.out.println("YES");
			else System.out.println("NO");
		}
		br.close();
	}

}
