import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = parseInt(st.nextToken());
			int B = parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] N = new int[A];
			for(int i=0;i<A;i++)
				N[i] = parseInt(st.nextToken());
			//sum: max sum < B ending at i
			int j=0,maxij=0,sum=0,maxSum=0;
			for(int i=0;i<A;i++){
				sum+=N[i];	
				while(sum>B)sum-=N[j++];
				if(maxij<i-j+1){ maxij=i-j+1;
				maxSum=sum;}
			}
			System.out.println(maxSum+" "+maxij);
		}
	}
}
