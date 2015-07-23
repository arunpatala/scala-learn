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
			int N = parseInt(br.readLine());
			Node[] V = new Node[2*N];
			for(int i=0;i<N;i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int S = parseInt(st.nextToken());
				int E = parseInt(st.nextToken());
				V[2*i] = new Node(0,S);
				V[2*i+1] = new Node(1,E);
			}
			Arrays.sort(V,(u,v)->u.time-v.time);
			int max = 0;
			int cnt = 0;
			for(Node v:V)
			{
				if(v.type==0) cnt++;
				else cnt--;
				if(cnt>max) max = cnt;
			}
			System.out.println(max);
		}
	}

}

class Node{
	int type;
	int time;
	public Node(int ctype, int ctime)
	{
		type = ctype;
		time = ctime;
	}
}
