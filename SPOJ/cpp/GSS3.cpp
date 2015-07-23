#include <cstdio>
#include <algorithm>

using namespace std;

struct SegmentTreeNode{
	int prefixSum, suffixSum, maxSum, sum;
	void merge(SegmentTreeNode& left, SegmentTreeNode& right)
	{
		sum = left.sum + right.sum;
		suffixSum = max(right.suffixSum, right.sum+left.suffixSum);
		prefixSum = max(left.prefixSum, left.sum+right.prefixSum);
		maxSum = max(left.maxSum,max(right.maxSum,max(sum,max(suffixSum,max(prefixSum,left.suffixSum+right.prefixSum)))));
	}
	void assignLeaf(int value){
		prefixSum= suffixSum = maxSum = sum = value;
	}
	int getValue(){
		return maxSum;	
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
	void update(int index, int  value) {
		update(1, 0, N-1, index, value);
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
	void update(int index, int lo, int hi, int i, int v){
		if(lo==hi) nodes[index].assignLeaf(v);
		else{
			int mid = (lo+hi)/2;
			if(i<=mid)update(2*index,lo,mid,i,v);
			else update(2*index+1,mid+1,hi,i,v);
			nodes[index].merge(nodes[2*index],nodes[2*index+1]);
		}
	}

	int getSize2(int l){
		int size = 1;
		while(size<l)
			size <<= 1;
		return 2*size;
	}
};


int main() {
	int N, i, A[50000], M, x, y, cmd;
	
	scanf("%d", &N);
	for (i = 0; i < N; ++i)
		scanf("%d", &A[i]);
	SegmentTree st(A, N);
	
	scanf("%d", &M);
	for (i = 0; i < M; ++i) {
		scanf("%d %d %d",&cmd, &x, &y);
		if(cmd==1)
			printf("%d\n", st.getValue(x-1, y-1));
		else st.update(x-1,y);
	}	
	
	return 0;
}
