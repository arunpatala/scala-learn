#include<stdio.h>
#include <stdlib.h>
#define NMAX 159 
#define INF (159*10009)
#define MIN(X,Y) ((X)<(Y)?(X):(Y))
#define MAX(X,Y) ((X)>(Y)?(X):(Y))
int P[NMAX][NMAX][NMAX];
int W[NMAX][NMAX];
int N,K,Q,T;

int main(){
	int i,j,k,ki,t,q,u,v;
	scanf("%d",&T);
	for(t=1;t<=T;t++){
		scanf("%d",&N);
		for(i=1;i<=N-1;i++)
			for(j=i+1;j<=N;j++)
			{
				scanf("%d",&W[i][j]);
				P[0][i][j]=W[i][j];
				if(W[i][j]==-1)P[0][i][j]=INF;
				W[j][i]=W[j][i];
				P[0][j][i]=P[0][i][j];
			}
		
		scanf("%d",&K);
		for(k=1;k<=K;k++)
		{
			scanf("%d",&ki);
			for(i=1;i<=N;i++)
			{
				for(j=1;j<=N;j++)
				{
					P[k][i][j]=MIN(P[k-1][i][j],P[k-1][i][ki]+P[k-1][ki][j]);
				}
			}

		}
		scanf("%d",&Q);
		printf("Case %d:",t);
		for(q=1;q<=Q;q++)
		{
			scanf("%d %d %d",&k,&u,&v);
			printf(" %d",P[k][u][v]);
		}
		printf("\n");
	}
}
