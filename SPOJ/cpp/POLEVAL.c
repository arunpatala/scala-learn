#include<stdio.h>
#define NMAX 1000 
#define KMAX 100
int C[NMAX];
int K[KMAX];

int main(){
	int T=1,M,i,j,k,K,N;
	long long ret;
	while(1){
		scanf("%d",&N);
		if(N==-1)break;
		for(i=0;i<=N;i++)
			scanf("%d",&(C[i]));
		printf("Case %d:\n",T);
		scanf("%d",&M);
		for(k=0;k<M;k++)
		{
			scanf("%d",&K);
			ret = 0;
			for(i=0;i<=N;i++)
				ret = (ret*K)+C[i];
			printf("%lld\n",ret);
		}
		T++;
	}
}

