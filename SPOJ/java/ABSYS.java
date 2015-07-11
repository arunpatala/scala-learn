import java.util.*;
import java.io.*;

class Main{

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		sc.nextLine();
		for(int ti=0;ti<t;ti++){
			sc.nextLine();
			String str = sc.nextLine();
			String[] s = str.split(" ");
			if(s[0].contains("m"))s[0]=(Integer.parseInt(s[4])-Integer.parseInt(s[2]))+"";
			else if(s[2].contains("m"))s[2]=(Integer.parseInt(s[4])-Integer.parseInt(s[0]))+"";
			else if(s[4].contains("m"))s[4]=(Integer.parseInt(s[0])+Integer.parseInt(s[2]))+"";
			
			out.printf("%s + %s = %s\n",s[0],s[2],s[4]);
		}
		out.flush();
		out.close();
		sc.close();

	}
}


