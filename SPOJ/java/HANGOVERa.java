import java.util.*;

class Main{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(true){
			float d = in.nextFloat();
			if(d==0) break;
			float len = 0.5f;
			int n = 1;
			while(len<d){
				n++;
				len += (1.0f/(n+1));
			}
			System.out.println(n+" cards(s)");
		}
		in.close();
	}
}
