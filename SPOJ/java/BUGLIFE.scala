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
		for(int i=0;i<N;i++)A[i]=parseInt(st.nextToken());
		int K = parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i=0;i<N;i++)
		{
			for(Object a:queue.toArray())
				System.out.print(a+" ");
			System.out.println();
			if(i-K>=0){
				queue.remove(-A[i-K]);
				out.printf("%d ",-queue.peek());
			}
			queue.add(-A[i]);
		}
		out.flush();
		out.close();
		br.close();
	}

}
