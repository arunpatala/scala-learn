#include <stdio.h>


int tree_size(int N){
	int size = 1;
	while(size<N)size<<=1;
	return size;
}
struct Tree{
	int max;
}

void build(int[] A, int n){
	int i,l,r;
	int N = tree_size(n);
	struct Tree tree[N];
	for(i=N;i>=0;i--)
	{
		if(i>N/2) tree[i].max = A[i];
		else{
			l=2*i+1;
			r=2*i+2;
			tree[i]=MAX(tree[l],tree[r]);
		}
	}
	
}

int main(){
	int a;
	while(1){
		scanf("%d",&a);
		printf("%d\n",tree_size(a));
	}

}


