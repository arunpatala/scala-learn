import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static String meth(int n){
		if(n==1) return "2(0)";
		else if(n==2) return "2";
		else if(n==3) return "2+2(0)";
		else if(n%2==0) return "2("+meth(n/2)+")";
		else return "2("+meth(n/2)+")+2(0)";
	}

	public static void main(String[] args) throws IOException{	
		int[] A = {137, 1315, 73, 136, 255, 1384, 16385};
		//int[] A = {1,2,3,4,5,6,7,8,9,10};
		for(int a:A){
			System.out.println(a+"="+meth(a));	
		}
	
	}
}
