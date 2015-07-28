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
			int M = parseInt(st.nextToken());
			int N = parseInt(st.nextToken());
			if(N==0&&M==0)break;
			StringBuffer sb = new StringBuffer();
			for(int i=0;i<N;i++)sb.append(br.readLine());
			TOE t = new TOE(sb.toString(),N,M);//.BFS();
			t.BFS();
			br.readLine();
		}
	}
}
class TOE{
	BitSet G;
	int N,M;
	TOE parent;
	int mx,my;
	public TOE(int Nc, int Mc, BitSet Gc){
		N=Nc;M=Mc;
		G=Gc;
	}
	public TOE(int Nc, int Mc){
		N=Nc;M=Mc;
		G=new BitSet(N*M);
	}
	public TOE(String s,int Nc, int Mc){
		this(Nc,Mc);
		char[] C = s.toCharArray();
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(C[i*M+j]=='1')G.set(i*M+j);
				else G.clear(i*M+j);
	}
	public void BFS(){
		boolean[] V = new boolean[1<<(N*M)];
		List<TOE> lst = new LinkedList<>();
		lst.add(this);
		V[this.toInt()]=true;
		TOE t = null;
		while(lst.size()>0)
		{
			t = lst.remove(0);
			//System.out.println(t);
			if(t.solved())break;
			for(TOE ti:t.next())
				if(!V[ti.toInt()])
				{
					ti.parent = t;
					lst.add(ti);
					V[ti.toInt()]=true;
				}
		}
		t.print(0);
	}
	public void print(int j){
		if(parent!=null)
		{
			parent.print(j+1);
			System.out.println((my+1)+" "+(mx+1));
		}
		else System.out.println(j);
	}
	public List<TOE> next(){
		List<TOE> ret = new LinkedList<TOE>();
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
			//if(G.get(i*M+j))
			{
				BitSet Gnew = (BitSet)(G.clone());
				int[] x = {0,1,-1,0, 0};
				int[] y = {0,0, 0,1,-1};
				for(int k=0;k<5;k++)
				{
					int xi = x[k];
					int yi = y[k];
					if((i+xi)>=0&&(i+xi)<N&&(j+yi)>=0&&(j+yi)<M)
					{
						Gnew.flip((i+xi)*M+(j+yi));
					}
				}
				TOE to = new TOE(N,M,Gnew);
				to.mx=i;to.my=j;
				ret.add(to);
			}
		return ret;
	}
	public boolean solved(){
		for(int j=0;j<N*M;j++)
			if(!G.get(j))return false;
		return true;
	}
	public String toString(){
		String s = "";
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
				if(G.get(i*M+j)) s+="1";
				else s+="0";
			s+="\n";
		}
		s+=(mx+","+my+"\n");
		return s;
	}
	public int toInt(){
		int size = 1;
		int ret = 0;
		for(int i=0;i<G.size();i++)
		{
			if(G.get(i)) ret += size;
			size<<=1;
		}
		return ret;
	}
}
