#include <cstdio>
#include <algorithm>
using namespace std;
#define NMAX 100001


int main(void){
		int N,K;
		scanf("%d %d",&N,&K);
		int A[N];
		for(int i=0;i<N;i++)
			scanf("%d",&A[i]);
		sort(A,A+N);
		int ret = 0;
		for(int i=0;i<N;i++)
			if(binary_search(A,A+N,A[i]+K))
				ret++;
		printf("%d\n",ret);
}
