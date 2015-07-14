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
				if(i-N/2<n)S[i] = new Stats(A[i-N/2],i-N/2);
				else S[i] = new Stats(0,i-N/2);
			}
			else {
				S[i] = new Stats(S[2*i],S[2*i+1]);
			}
		}
	}
	public void query(int i, int j){
		Stats s = S[1].query(i,j);
		System.out.println(s);
	}
	//zero indexed and including i and j
	/*public void query(int i, int j){ 
		int ni = (N/2)+i;
		int nj = (N/2)+j;
		while(ni!=nj){
			int pi = ni/2;
			if(2*pi==ni)
			int pj = nj/2;

		}
	}*/

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
		SegmentTree ST = new SegmentTree(new int[]{-2,1,-3,4,-1,2,1,-5,4});
		System.out.println(ST);
		ST.query(2,5);

	}


}

class Stats{
	int i;
	int j;
	int max;
	int leftSum;
	int rightSum;
	int sum;
	Stats left;
	Stats right;
	public Stats(int a, int ai){
		i = ai;
		j = ai;
		max = a;
		leftSum = a;
		rightSum = a;
		sum = a;
	}
	public Stats(Stats l, Stats r){
		left = l;
		right = r;
		i = l.i;
		j = r.j;
		max = Math.max(l.max,Math.max(r.max,l.rightSum+r.leftSum));
		sum = l.sum+r.sum;
		if(r.rightSum==r.sum)
			rightSum = Math.max(r.rightSum+l.rightSum,r.rightSum); 
		else rightSum = r.rightSum;
		if(l.leftSum==l.sum)
			leftSum = Math.max(r.leftSum+l.leftSum,l.leftSum); 
		else leftSum = r.leftSum;
	}
	public Stats query(int qi, int qj){
		if(inside(qi,qj)) {
			System.out.println(qi+","+qj+","+this);
			return this;
		}
		else if(left.intersects(qi,qj)&&right.intersects(qi,qj)) 
			return new Stats(left.query(qi,qj),right.query(qi,qj));
		else if(left.intersects(qi,qj)) return left.query(qi,qj);
		else return right.query(qi,qj);
		//else if(right.intersects(qi,qj)) return right.query(qi,qj);
	}
	public boolean intersects(int qi){
		return intersects(qi,i,j);
	}
	public static boolean intersects(int qi, int i, int j)
	{	
		return i<=qi && qi<=j;
	}
	public boolean intersects(int qi, int qj)
	{
		return intersects(qi) || intersects(qj);
	}
	public boolean inside(int qi, int qj)
	{
		return intersects(i,qi,qj) && intersects(j,qi,qj);
	}
	public String toString(){return "(["+i+","+j+"]"+leftSum+","+max+","+rightSum+")";}
}
