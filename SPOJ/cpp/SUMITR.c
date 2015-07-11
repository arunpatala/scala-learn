#include<stdio.h>
#define M(X, Y) (((X) > (Y)) ? (X) : (Y))
int A[101];int B[2][101];
int main(){int t,i,m,N,j,a;scanf("%d",&t);
while(t--){scanf("%d",&N);m=0;for(i=0;i<=N;i++){if(i==0){B[0][i]=0;B[1][i]=0;}else for(j=1;j<=i;j++){scanf("%d",&a);B[i%2][j] = a+M(B[(i+1)%2][j],B[(i+1)%2][j-1]);m=M(m,B[N%2][j]);}}printf("%d\n",m);}}

