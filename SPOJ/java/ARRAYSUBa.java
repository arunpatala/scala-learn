import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int N = parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i=0;i<N;i++){
			A[i]=parseInt(st.nextToken());
			queue.add(-A[i]);
		}
		int K = parseInt(br.readLine());
		for(int i=K-1;i<N;i++)
			out.printf("%d ",A[i]);
		out.printf("\n");
		out.flush();
		out.close();
		br.close();
	}

}
