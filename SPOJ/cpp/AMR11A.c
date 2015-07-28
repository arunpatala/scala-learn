#include<stdio.h>
#include <stdlib.h>
#define NMAX 509
#define INF (1<<30)
#define MIN(X,Y) ((X)<(Y)?(X):(Y))
#define MAX(X,Y) ((X)>(Y)?(X):(Y))
int P[NMAX][NMAX];
int Q[NMAX][NMAX];
int W[NMAX][NMAX];
int N,M,T;


int solve(int E)
{
	int i,j;
	W[0][0]=E;
	for(i=0;i<N;i++)
	{
		for(j=0;j<M;j++)
		{
			if(i==0&&j==0)P[i][j]=0;
			else if(i==0)P[i][j]=P[i][j-1];
			else if(j==0)P[i][j]=P[i-1][j];
			else P[i][j]=MAX(P[i-1][j],P[i][j-1]);

			if(P[i][j]==-INF)P[i][j]=-INF;
			else P[i][j]+=W[i][j];
			if(P[i][j]<=0)P[i][j]=-INF;

			printf("%d,",P[i][j]);
		}
		printf("\n");
	}
	return P[N-1][M-1]!=-INF;
}

int search()
{
	int lo=0,hi=100,mid;
	while(lo<hi)
	{
		mid = (lo+hi)/2;
		printf("%d %d %d\n",lo,mid,hi);
		if(solve(mid))hi=mid;
		else lo=mid+1;
	}
	return hi;
}


int main(){
	int i,j,k,ki,t,q,u,v,d;
	scanf("%d",&T);
	for(t=1;t<=T;t++){
		scanf("%d %d",&N,&M);
		for(i=0;i<N;i++)
			for(j=0;j<M;j++)
			{
				scanf("%d",&W[i][j]);
			}
		d = search();
		printf("%d\n",d);

		}
}
