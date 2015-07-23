import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		for(int i=0;i<T;i++)
		{
			int N = parseInt(br.readLine());
			String[] A = new String[N];
			for(int j=0;j<N;j++)
				A[j] = br.readLine();
			for(int j=A[0].length()-1;j>=0;j--)
				if(A[0].charAt(j)!=' ')
					sort(A,j);
			for(int j=0;j<A.length;)
			{
				int cnt = 0;
				String s = A[j];
				while(j<A.length && s.equals(A[j])){cnt++;j++;}
				System.out.println(s+" "+cnt);
			}
			br.readLine();
		}
		br.close();
	}

	public static void sort(String[] A, int c){
		List<String>[] B = new List[10];
		for(int i=0;i<10;i++) B[i] = new LinkedList<>();	
		for(int i=0;i<A.length;i++)
			B[A[i].charAt(c)-'0'].add(A[i]);
		int ci = 0;
		for(int i=0;i<10;i++)
		{
			for(String s:B[i])
				A[ci++] = s;
		}
	}

}
