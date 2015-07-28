import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		char[][] GRID = new char[N][];
		br.readLine();
		for(int i=0;i<N;i++)
			GRID[i] = br.readLine().toCharArray();
		int i=0,j=N-1;
		char prev = ' ';
		for(int i=0;i<N;i++)
		{
			char curr = C[i][j];
			if(prev==curr) steps++;
			else {
				if(prev=='/') System.out.println("Up "+steps+" steps");
				if(prev=='_') System.out.println("Walk "+steps+" steps");
				if(prev=='\\') System.out.println("Down"+steps+" steps");
			}
			if(curr=='/')j++;
			if(curr=='\\')j--;

			prev = curr;
		}
	}

	public static boolean play(int K, int L, int N)
	{
		if(N<K) return N%2==1;
		else if(N<L) 
		
	}
}
