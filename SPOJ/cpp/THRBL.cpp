#include <cstdio>
#include <algorithm>

using namespace std;

struct SegmentTreeNode{
	int m;
	void merge(SegmentTreeNode& left, SegmentTreeNode& right)
	{
		m = max(right.m, left.m);
	}
	void assignLeaf(int value){
		m=value;
	}
	int getValue(){
		return m;	
	}

};

class SegmentTree{
	SegmentTreeNode* nodes;
	int N;
public:
	SegmentTree(int arr[], int N){
		this->N = N;
		nodes = new SegmentTreeNode[getSize2(N)];
		build(arr,1,0,N-1);
	}
	~SegmentTree(){
		delete[] nodes;
	}
	int getValue(int lo, int hi){
		return getValue(1,0,N-1,lo,hi).getValue();
		
	}
private:

	void build(int A[], int index, int lo, int hi)
	{
		if(hi==lo) {nodes[index].assignLeaf(A[hi]);return;}
		int mid = (hi+lo)/2;
		build(A,2*index,lo,mid);
		build(A,2*index+1,mid+1,hi);
		nodes[index].merge(nodes[2*index],nodes[2*index+1]);
	}
	SegmentTreeNode getValue(int index, int left, int right, int lo, int hi){
		if(left==lo && right==hi) return nodes[index];
		int mid = (left+right)/2;
		if(mid<lo) return getValue(2*index+1,mid+1,right,lo,hi);
		if(hi<=mid)return getValue(2*index,left,mid,lo,hi);

		SegmentTreeNode l = getValue(2*index, left, mid, lo, mid);
		SegmentTreeNode r = getValue(2*index+1,mid+1,right, mid+1, hi);
		SegmentTreeNode ret;
		ret.merge(l,r);
		return ret;
	}

	int getSize2(int l){
		int size = 1;
		while(size<l)
			size <<= 1;
		return 2*size;
	}
};


int main() {
	int N, i, A[50009], M, x, y,ret,G;
	
	scanf("%d %d", &N, &M);
	for (i = 0; i < N; ++i)
		scanf("%d", &A[i]);
	SegmentTree st(A, N);
	
	for (i = 0; i < M; ++i) {
		scanf("%d %d", &x, &y);
		//printf("%d\n", st.getValue(x-1, y-1));
		G = st.getValue(x-1,y-2);
		if(G<=A[x-1])ret++;
	}	
	printf("%d\n",ret);
	
	return 0;
}
