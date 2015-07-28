import java.util.*;
import java.io.*;

class Main{


	public static long mergesort(int[] A, int i, int j){
		if(i>=j) return 0;
		long cnt = 0;
		int mid = (i+j)/2;
		cnt+=mergesort(A,i,mid);	
		cnt+=mergesort(A,mid+1,j);	
		int[] B = new int[j-i+1];
		int ki = i, kj=mid+1, kb = 0;
		while(ki<=mid&&kj<=j)
		{
			if(A[ki]<A[kj]){
				cnt+=(A[ki]*(j-kj+1));
				B[kb++]=A[ki++];
			}
			else {B[kb++]=A[kj++];}
		}
		while(ki<=mid)B[kb++]=A[ki++];
		while(kj<=j)B[kb++]=A[kj++];
		for(int k=i;k<=j;k++)A[k]=B[k-i];
		return cnt;
	}

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		for(int ti=0;ti<t;ti++){
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			long cnt = mergesort(arr,0,arr.length-1);
			//System.out.println(Arrays.toString(arr));
			System.out.println(cnt);
		}
		out.flush();
		out.close();
		sc.close();

	}
}


