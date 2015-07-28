import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			int N = parseInt(br.readLine());
			Cuboid[] C = new Cuboid[N];
			Ivl[] I = new Ivl[2*N];
			for(int i=0;i<N;i++)
			{
				Cuboid c =new Cuboid();
				StringTokenizer st = new StringTokenizer(br.readLine());
				c.b = parseInt(st.nextToken());
				c.h = parseInt(st.nextToken());
				c.l = parseInt(st.nextToken());
				c.w = parseInt(st.nextToken());
				C[i]=c;
				I[2*i]=new Ivl(true,c);
				I[2*i+1]=new Ivl(false,c);
			}
			Arrays.sort(I,(u,v)->u.h-v.h);
			int vol = 0;
			int area = 0;
			int h = 0;
			double hret = -1;
			int req=parseInt(br.readLine());
			for(int i=0;i<2*N;i++){
				int avol = (I[i].h-h)*area;
				if(vol+avol>=req){
					//vol+area*(hret-h)=req;
					hret = h+((double)(req-vol))/area;
					break;
				}
				vol+=avol;
				area += I[i].area();
				h = I[i].h;
				System.out.println(h+","+area+","+vol);
			}
			if(hret==-1)
				out.printf("OVERFLOW\n");
			else out.printf("%.2f\n",hret);
		}
		out.flush();
		out.close();
		br.close();
	}
}
class Ivl{
	boolean start;
	int h;
	Cuboid c;
	public Ivl(boolean s, Cuboid cc)
	{
		start = s;
		c=cc;
		if(s) h=cc.b;
		else h=cc.b+cc.h;
	}
	public int area(){
		if(start) return c.l*c.w;
		else return -(c.l*c.w);
	}
}
class Cuboid{
	int b,w,l,h;
}
