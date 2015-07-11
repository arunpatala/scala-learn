#include<stdio.h>
#define MIN(X, Y) (((X) < (Y)) ? (X) : (Y))
#define MIN3(X, Y, Z) (MIN((X),(MIN((Y),(Z)))))
#define MIN4(W, X, Y, Z) (MIN((W),MIN3((X),(Y),(Z))))
#define INT_MAX 1000000

int B[2][3];
int main(){
	int t,i,m,N,j,a;
	m=1;
	while(1){
		scanf("%d",&N);
		if(N==0) break;
		scanf("%d",&B[0][0]);B[0][0]=INT_MAX;
		scanf("%d",&B[0][1]);
		scanf("%d",&a); B[0][2] = a+B[0][1];
		for(i=1;i<N;i++)
		{
			scanf("%d",&a);
			B[i%2][0] = a+MIN(B[(i+1)%2][0],B[(i+1)%2][1]);
			scanf("%d",&a);
			B[i%2][1] = a+MIN4(B[i%2][0],B[(i+1)%2][0],B[(i+1)%2][1],B[(i+1)%2][2]);
			scanf("%d",&a);
			B[i%2][2] = a+MIN3(B[i%2][1],B[(i+1)%2][1],B[(i+1)%2][2]);
			printf("%d,%d,%d\n",B[i%2][0],B[i%2][1],B[i%2][2]);
		}
		printf("%d. %d\n",m++,B[(N+1)%2][1]);
	}
}
