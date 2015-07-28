#include <cstdio>
#include <algorithm>
using namespace std;

int main(void){
	int T;
	scanf("%d",&T);
	while(T--){
		int N;
		scanf("%d",&N);
		int A[N];
		for(int i=0;i<N;i++)
			scanf("%d",&A[i]);
		bool flag = false;
		for(int i=N-2;i>=0;i--)
			if(A[i]<A[i+1])
			{
				int t=A[i];
				A[i]=A[i+1];
				A[i+1]=t;
				flag = true;
				sort(A+i+1,A+N);
				break;
			}
		if(flag){
			for(int i=0;i<N;i++)
				printf("%d",A[i]);
			printf("\n");
		}else printf("%d\n",-1);

	}

}
