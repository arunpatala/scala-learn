#include<stdio.h>
#include <stdlib.h>
#define NMAX 1009 
#define ABS(X) ((X)>0?(X):-(X))
#define max(A,B) ((A)>(B)?(A):(B))
int C[NMAX][2];
int DP[NMAX][2];

int main(){
	int N,i;
	scanf("%d",&N);
	for(i=0;i<N;i++)
		scanf("%d %d",&C[i][0],&C[i][1]);
	DP[0][0]=C[0][1];
	DP[0][1]=C[0][0];
	printf("%d %d\n",DP[0][0],DP[0][1]);
	for(i=1;i<N;i++)
	{
		DP[i][0]=C[i][1]+max(DP[i-1][0]+ABS(C[i][0]-C[i-1][0]),DP[i-1][1]+ABS(C[i][0]-C[i-1][1]));
		DP[i][1]=C[i][0]+max(DP[i-1][0]+ABS(C[i][1]-C[i-1][0]),DP[i-1][1]+ABS(C[i][1]-C[i-1][1]));
		printf("%d %d\n",DP[i][0],DP[i][1]);
	}
	printf("%d\n",max(DP[N-1][0],DP[N-1][1]));
}


