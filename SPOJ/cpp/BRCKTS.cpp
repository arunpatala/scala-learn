#include <cstdio>
#include <algorithm>

using namespace std;

struct SegmentTreeNode{
	int l,r;
	char c;
	void merge(SegmentTreeNode& left, SegmentTreeNode& right)
	{
		if(left.r>right.l){
			l=left.l;
			r=right.r+left.r-right.l;
		}else{
			r=right.r;
			l=left.l+right.l-left.r;
		}

	}
	void assignLeaf(char value){
		c=value;
		if(value=='(') {r=1;l=0;}
		else {r=0;l=1;}
	}
	void update(){
		assignLeaf('('+')'-c);
	}
	bool getValue(){
		return (l+r)==0;
	}

};

class SegmentTree{
	SegmentTreeNode* nodes;
	int N;
public:
	SegmentTree(char arr[], int N){
		this->N = N;
		nodes = new SegmentTreeNode[getSize2(N)];
		build(arr,1,0,N-1);
	}
	~SegmentTree(){
		delete[] nodes;
	}
	bool getValue(){
		return getValue(0,N-1);
	}
	bool getValue(int lo, int hi){
		return getValue(1,0,N-1,lo,hi).getValue();
		
	}
	void update(int index) {
		update(1, 0, N-1, index);
	}
private:

	void build(char A[], int index, int lo, int hi)
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
	void update(int index, int lo, int hi, int i){
		if(lo==hi) nodes[index].update();
		else{
			int mid = (lo+hi)/2;
			if(i<=mid)update(2*index,lo,mid,i);
			else update(2*index+1,mid+1,hi,i);
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
	char A[30000];
	int N,M,C;
	for(int t=0;t<10;t++)
	{
		scanf("%d", &N);
		scanf("%s", A);
		scanf("%d", &M);
		SegmentTree tree(A,N);
		for(int i=0;i<M;i++)
		{
			scanf("%d",&C);
			if(C==0){
				//printf("%s\n",A);
				if(tree.getValue())printf("YES\n");
				else printf("NO\n");

			}else{
				//A[C-1]='('+')'-A[C-1];
				tree.update(C-1);
			}
		}
	}		
	return 0;
}
