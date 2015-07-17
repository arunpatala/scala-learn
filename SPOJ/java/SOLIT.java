import java.io.*;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Integer.parseInt;

class Main{



	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] A = new int[8];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<8;i++)A[i]=parseInt(br.readLine());
		int[] B = new int[8];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<8;i++)B[i]=parseInt(br.readLine());
		Board start = new Board(A);
		Board end = new Board(A);
		List<Board> q = new LinkedList<>();
		while(q.size()>0){
			Board b = q.remove();
			for(Board bi:b.next())
				if(!q.contains(bi))
					q.add(bi);

		}

		br.close();
	}

}
//64C4 = 635376
class Board{
	BitSet bs = new BitSet(64);
	public Board(int[] xy){
		for(int i=0;i<xy.length;i+=2)
			set(xy[i],xy[i+1);
	}
	public List<Board> next(){
		for(int i=0;i<4;i++)
		{
		}
	}
	public void set(int i, int j){
		bs.set(ij(i,j));
	}
	public void clear(int i, int j){
		bs.clear(ij(i,j));
	}
	public boolean get(int i, int j){
		return bs.get(ij(i,j));
	}
	public int ij(int i, int j){
		return (i-1)*8+(j-1);
	}
	public String toString(){
		return bs.toString();
	}
	
}
