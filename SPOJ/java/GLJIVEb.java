import java.io.*;
import java.util.*;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 10;
		int sum = 0;
		int ret = 0;
		for(int n=0;n<N;n++)
		{
			int A = parseInt(br.readLine());
			sum = sum+A;
			if(abs(100-sum)<=abs(100-ret))
				ret = sum;
		}
		System.out.println(sum);
		br.close();
	}

}

