import java.io.*;
import java.util.*;
import static java.lang.Math.min;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		int N14=0,N12=0,N34=0;
		for(int i=0;i<N;i++){
			String S=br.readLine();
			if(S.equals("1/2"))N12++;
			else if(S.equals("1/4"))N14++;
			else if(S.equals("3/4"))N34++;
		}
		int total = 0;
		if(N14<=N34){
			total = total + N14;
			N14 = 0;
			N34 = N34-N14;
		}
		else{
		//if(N14>N34){
			total = total + N34;
			N14 = N14-N34;
			N34 = 0;
		}
		if(2*N12<=N14){
			total = total + N12;
			N14 = N14-2*N12;
			N12 = 0;
		}
		else{
		//if(2*N12>N14){
			total = total + N14/2;
			N14 = N14%2;
			N12 = N12-N14/2;
		}
		if(N12>=2){
			total = total + N12/2;
			N12 = N12%2;
		}
		if(N14>=4){
			total = total + N14/4;
			N12 = N12%4;
		}

		total = total + N34 + N12 + N14 + 1;
		System.out.println(total);
		br.close();
	}

}
