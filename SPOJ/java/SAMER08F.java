import java.util.*;

class Main{

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		String s;
		while((s=sc.nextLine())!=null){
			int i = Integer.parseInt(s);
			if(i==0) break;
			if(1<=i && i<=100)
			{	
				int sum = 0;
				for(int j=1;j<=i;j++)
					sum += (j*j);
				System.out.println(sum);
			}
		}
		sc.close();

	}
}


