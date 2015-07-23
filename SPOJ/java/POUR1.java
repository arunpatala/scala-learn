import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static int solve(int A, int B, int C)
	{
		boolean[][] V = new boolean[A+1][B+1];
		List<Integer> a = new LinkedList<>();
		List<Integer> b = new LinkedList<>();
		a.add(0);
		b.add(0);
		V[0][0] = true;
		boolean notfound = true;
		int steps = 0;
		while(notfound && a.size()>0)
		{
			List<Integer> anew = new LinkedList<>();
			List<Integer> bnew = new LinkedList<>();
			while(a.size()>0 && notfound)
			{
				int ai = a.remove(0);
				int bi = b.remove(0);
				int[] aa = {0, ai,  A, ai,     0, ai+bi-B,       A};
				int[] bb = {bi, 0, bi,  B, bi+ai,       B, ai+bi-A};
				for(int i=0;i<aa.length;i++)
				{
					if(aa[i]>=0&&aa[i]<=A&&bb[i]>=0&&bb[i]<=B&&!V[aa[i]][bb[i]])
					{
						anew.add(aa[i]);
						bnew.add(bb[i]);
						V[aa[i]][bb[i]]=true;
						if(aa[i]==C||bb[i]==C) notfound = false;
					}
				}
			}
			a = anew;
			b = bnew;
			steps = steps+1;
		}
		if(notfound) return -1;
		else return steps;
	}

	public static void main(String[] args) throws IOException{	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		while(N--!=0)
		{
			int A = parseInt(br.readLine());
			int B = parseInt(br.readLine());
			int C = parseInt(br.readLine());
			System.out.println(solve(A,B,C));
		}
		br.close();
	}

}
