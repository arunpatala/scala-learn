import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = parseInt(st.nextToken());
			int W = parseInt(st.nextToken());
			if(H==0&&W==0)break;
			char[][] G = new char[H][0];
			for(int i=0;i<H;i++)
				G[i] = br.readLine().toCharArray();
			List<Integer> x = new LinkedList<>();
			List<Integer> y = new LinkedList<>();
			for(int i=0;i<H;i++)
				for(int j=0;j<W;j++)
					if(G[i][j]=='A')
					{
						x.add(i);
						y.add(j);
					}
			int k=0;
			for(k=1;k<26&&x.size()>0;k++)
			{
				List<Integer> xnew = new LinkedList<>();
				List<Integer> ynew = new LinkedList<>();
				while(x.size()>0)
				{
					int i = x.remove(0);
					int j = y.remove(0);
					for(int ii=i-1;ii<=i+1;ii++)
						for(int jj=j-1;jj<=j+1;jj++)
							if(ii>=0&&ii<H&&jj>=0&&jj<W)
								if(G[ii][jj]-'A'==k)
								{
									xnew.add(ii);
									ynew.add(jj);
								}
				}
				x=xnew;y=ynew;
			}
			System.out.println(k-1);
		}
	}

}
