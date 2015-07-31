import java.util.*;
import java.io.*;
import java.lang.*;
import static java.lang.Math.*;
import static java.lang.Integer.parseInt;




class Main{

        public static void main(String[] args) throws IOException
        {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int T = parseInt(br.readLine());
                while(T--!=0)
                {
                        String s = br.readLine();
                        SuffixArray a = new SuffixArray(s);
                        System.out.println(a.LPA());
                }
                br.close();
        }
}


class SuffixArray{

	int N;
	Node[] A,B;

	public SuffixArray(String s){
		N = s.length();
		A = new Node[N];
		B = new Node[N];
		for(int i=0;i<N;i++){
			A[i]=new Node(i,s);
			B[i]=A[i];
		}
		power();
		A=B;
	}

	public void power()
	{
		for(int i=1;i<=2*N;i*=2)
		{
			sortAndRank();
			for(int j=0;j<N;j++)
			{
				A[j].rank1=A[j].rank;
				if(i+j<N)
					A[j].rank2=A[i+j].rank;
				else A[j].rank2=-1;
			}
		}
	}

	public void sortAndRank(){
		Arrays.sort(B);
		for(int i=1;i<N;i++)
			if(B[i].compareTo(B[i-1])==0)
				{
					B[i].rank=B[i-1].rank;
					B[i].cnt++;
				}
			else B[i].rank=B[i-1].rank+1;
		System.out.println(Arrays.toString(B));
	}

        public int LPA()
        {
                int count = 0;
                for(int i=0;i<N;i++)
                        count+=(N-A[i].i-A[i].cnt);
                return count;
        }

}

class Node implements Comparable<Node>{
	int i;
	String s;
	int rank,rank1,rank2;
	int cnt=0;

	public Node(int idx, String str)
	{
		s=str;
		i=idx;
		rank1=s.charAt(i)-'a';
		rank2=0;
	}
	public String toString(){
		return i+":"+substring()+":"+rank;
	}
	public String substring(){
		return s.substring(i);
	}
	public int compareTo(Node that)
	{
		if(this.rank1==that.rank1)
			return this.rank2-that.rank2;
		else return this.rank1-that.rank1;
	}
}
