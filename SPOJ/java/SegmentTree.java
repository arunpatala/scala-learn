import java.lang.Math;

class SegmentTree{
	int N;
	int n;
	int[] A;
	Stats[] S;
	public SegmentTree(int[] Ac){
		A = Ac;
		n = A.length;
		N = 2*getSize(n);
		S = new Stats[N];
		update();
	}

	public void update(){
		for(int i=N-1;i>=1;i--)
		{
			if(i>=N/2){
				if(i-N/2<n)S[i] = new Stats(A[i-N/2]);
				else S[i] = new Stats(0);
			}
			else {
				S[i] = new Stats(S[2*i],S[2*i+1]);
			}
		}
	}

	public static int getSize(int n){
		int size = 1;
		while(size<n) size <<= 1;
		return size;
	}

	public String toString(){
		String ret = "";
		for(int i=1;i<N;i++){
			ret += S[i]+",";
			if(getSize(i+1)==(i+1))ret+="\n";
		}
		return ret;
	}

	public static void main(String[] args){
		SegmentTree ST = new SegmentTree(new int[]{19,3,36,25,1,7});
		System.out.println(ST);

	}


}

class Stats{
	int max;
	public Stats(int a){
		max = a;
	}
	public Stats(Stats s1, Stats s2){
		max = Math.max(s1.max,s2.max);
	}
	public String toString(){return max+"";}
}
