import java.io.*;
import java.util.*;
import static java.lang.Math.min;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		int N = 100;
		int[] A = new int[N+1];
		for(int i=1;i<=N;i++)
			A[i] = i*i*i;
		for(int i=2;i<=N;i++)
		for(int j=2;j<=N;j++)
		for(int k=j;k<=N;k++)
		for(int l=k;l<=N;l++)
			if(A[i]==A[j]+A[k]+A[l])
				System.out.println("Cube = "+i+", Triple = ("+j+","+k+","+l+")");

	}

}
