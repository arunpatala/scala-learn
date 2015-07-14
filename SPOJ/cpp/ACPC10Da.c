#include<stdio.h>
#define MIN(X, Y) X < Y ? X : Y
#define INT_MAX 1000000
#define MAX 1000005
int A[MAX][3];
int B[2][3];
int main(){
	int t,i,m,N,j,a;
	m=1;
	while(1){
		scanf("%d",&N);
		if(N==0) break;
		for(i=0;i<N;i++)
			for(j=0;j<3;j++)
				scanf("%d",&A[i][j]);
		B[0][0]=INT_MAX;
		B[0][1]=A[0][1];
		B[0][2]=A[0][1]+A[0][2];
		for(i=1;i<N;i++)
		{
			B[i%2][0] = MIN(B[(i-1)%2][0],B[(i-1)%2][1]);
			B[i%2][0] += A[i][0];
			B[i%2][1] = MIN(B[i][0],B[(i-1)%2][0]);
			B[i%2][1] = MIN(B[i][1],B[(i-1)%2][1]);
			B[i%2][1] = MIN(B[i][1],B[(i-1)%2][2]);
			B[i%2][1] += A[i][1];
			B[i%2][2] = MIN(B[i][1],B[(i-1)%2][1]);
			B[i%2][2] = MIN(B[i][2],B[(i-1)%2][2]);
			B[i%2][2] += A[i][2];
		}
		printf("%d. %d\n",m++,B[(N-1)%2][1]);
	}
}
