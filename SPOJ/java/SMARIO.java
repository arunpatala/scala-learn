import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;
import java.lang.Math;

class Main{

	public static void main(String[] args) throws IOException{	

		PrintWriter out = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = parseInt(st.nextToken());
			int M = parseInt(st.nextToken());
			if(N==0&&M==0)break;
			char[][] GRID = new char[N][2*M-1];
			for(int i=0;i<N;i++)
			{
				char[] c = br.readLine().toCharArray();
				for(int j=0;j<M;j++)
				{
					GRID[i][j] = c[2*j];
				}
			}
			boolean[][] VISIT = new boolean[N][M];
			List<Integer> sizes = new LinkedList<Integer>();
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
					if(GRID[i][j]=='1' && !VISIT[i][j])
			{
			List<Integer> x = new LinkedList<Integer>();
			List<Integer> y = new LinkedList<Integer>();
			VISIT[i][j]=true;
			x.add(i);y.add(j);
			int size = 0;
			while(x.size()>0){
				int xi = x.remove(0);
				int yi = y.remove(0);
				size++;
				System.out.println(xi+","+yi+","+GRID[xi][yi]);
				if(xi!=0 && !VISIT[xi-1][yi] && GRID[xi-1][yi]=='1')
				{
					VISIT[xi-1][yi]=true;
					x.add(xi-1);
					y.add(yi);
				}
				if(yi!=0 && !VISIT[xi][yi-1] && GRID[xi][yi-1]=='1')
				{
					VISIT[xi][yi-1]=true;
					x.add(xi);
					y.add(yi-1);
				}
				if(xi!=N-1 && !VISIT[xi+1][yi] && GRID[xi+1][yi]=='1')
				{
					VISIT[xi+1][yi]=true;
					x.add(xi+1);
					y.add(yi);
				}
				if(yi!=M-1 && !VISIT[xi][yi+1] && GRID[xi][yi+1]=='1')
				{
					VISIT[xi][yi+1]=true;
					x.add(xi);
					y.add(yi+1);
				}
			}
			//System.out.println("SIZE:"+i+","+j+","+size);
			sizes.add(size);

			}
			System.out.println(sizes.size());
			Collections.sort(sizes);
			System.out.println(sizes);
			int s = sizes.get(0);
			int c = 0;
			for(int i=0;i<sizes.size();i++){
				if(sizes.get(i)==s) c++;
				else { 
					System.out.println(s+" "+c);
					s = sizes.get(i);c=1;
					}
			}
			System.out.println(s+" "+c);
		}
		out.flush();
		out.close();
		br.close();
	}

}

