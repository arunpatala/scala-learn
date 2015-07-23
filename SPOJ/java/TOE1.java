import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{

	public static void main(String[] args) throws IOException{	
		TOE t = new TOE();
		boolean[][] G = t.BFS();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		while(T--!=0)
		{
			String row1 = br.readLine();
			String row2 = br.readLine();
			String row3 = br.readLine();
			TOE ti = new TOE(row1+row2+row3);
			int e = TOE.toInt(ti.E);
			int x = TOE.toInt(ti.X);
			if(G[e][x]) System.out.println("yes");
			else System.out.println("no");
			br.readLine();
		}
	}
}
//E empty
//X O
class TOE{
	static int N = 9;
	BitSet E = new BitSet(N);
	BitSet X = new BitSet(N);
	boolean playX;
	public TOE(){
		E = new BitSet(N);
		E.set(0,N,true);
		X = new BitSet(N);
		playX=true;
	}
	public TOE(String s){
		char[] C = s.toCharArray();
		E = new BitSet(N);
		X = new BitSet(N);
		for(int i=0;i<9;i++)
			if(C[i]=='.')E.set(i);
			else{
				if(C[i]=='X')X.set(i);
				else X.clear(i);
			}
	}
	//public List<TOE> BFS(){
	public boolean[][] BFS(){
		boolean[][] V = new boolean[1<<10][1<<10];
		List<TOE> ret = new LinkedList<>();
		List<TOE> lst = new LinkedList<>();
		lst.add(this);
		while(lst.size()>0)
		{
			TOE t = lst.remove(0);
			ret.add(t);
			if(!t.solved())
			for(TOE ti:t.next())
			if(!V[toInt(ti.E)][toInt(ti.X)])
			{
				lst.add(ti);
				V[toInt(ti.E)][toInt(ti.X)]=true;
			}
		}
		//return ret;
		return V;
	}
	public TOE(BitSet e, BitSet x,boolean p){
		X=x;E=e;playX=p;
	}
	public List<TOE> next(){
		List<TOE> ret = new LinkedList<TOE>();
		for(int i=0;i<N;i++)
			if(E.get(i))
			{
				BitSet e = (BitSet)(E.clone());	
				e.clear(i);
				BitSet x = (BitSet)(X.clone());
				if(playX)x.set(i);
				else x.clear(i);
				ret.add(new TOE(e,x,!playX));
			}
		return ret;
	}
	public boolean solved(){
		for(int i=0;i<3;i+=3)
			if(check(i,i+1,i+2)) return true;
		for(int j=0;j<3;j+=3)
			if(check(j,j+3,j+6)) return true;
		if(check(0,4,8)) return true;
		if(check(2,4,6)) return true;
		return false;
	}
	public boolean check(int i, int j , int k){
		if(E.get(i)||E.get(j)||E.get(k)) return false;
		boolean xi = X.get(i);
		boolean xj = X.get(j);
		boolean xk = X.get(k);
		if(xi==xj&&xj==xk&&xk==xi)
			return true;
		return false;
	}
	public String toString(){
		String s = "";
		for(int i=0;i<9;i++)
			if(E.get(i)) s+=".";
			else {
				if(X.get(i)) s+="X";
				else s+="O";
			}
		return s;
	}
	public static int toInt(BitSet b){
		int size = 1;
		int ret = 0;
		for(int i=0;i<b.size();i++)
		{
			if(b.get(i)) ret += size;
			size<<=1;
		}
		return ret;
	}
}
