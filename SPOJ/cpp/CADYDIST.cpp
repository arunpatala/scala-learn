#include <cstdio>
#include <algorithm>
using namespace std;
#define NMAX 100001

int A[NMAX];
int B[NMAX];

int main(void){
	while(true){
		int N,u;
		scanf("%d",&N);
		if(N==0)break;
		for(int i=0;i<N;i++)
			scanf("%d",&A[i]);
		for(int i=0;i<N;i++)
			scanf("%d",&B[i]);
		sort(A,A+N);
		sort(B,B+N);
		long long ret = 0;
		for(int i=0;i<N;i++)
		{
			long long a = A[i];
			long long b = B[N-i-1];
			ret += (a*b);
		}
		printf("%lld\n",ret);
	}

}
