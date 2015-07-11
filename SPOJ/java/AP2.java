import java.util.*;
import java.io.*;

class Main{

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		for(int ti=0;ti<t;ti++){
			long a3 = sc.nextLong();
			long an_3 = sc.nextLong();
			long sum = sc.nextLong();
			long n = sum*2L/(a3+an_3);
			long d = (an_3-a3)/(n-5L);
			long a = a3-2L*d;
			out.printf("%d",a);
			for(long i=a+d;i<=a+(n-1)*d;i+=a)out.printf(" %d",i);
			out.printf("\n");
		}
		out.flush();
		out.close();
		sc.close();

	}
}


