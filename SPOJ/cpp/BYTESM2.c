#include<stdio.h>
#define MAX(X, Y) (((X) > (Y)) ? (X) : (Y))

int B[2][105];
int main(){
	int t;
	scanf("%d",&t);
	while(t--){
		int n,m,i,j,aij,ret;
		scanf("%d%d",&n,&m);
		for(j=0;j<=m+1;j++){
			B[0][j]=0;
			B[1][j]=0;
		}
		ret = 0;
		for(i=0;i<n;i++)
		{
			for(j=1;j<=m;j++)
			{
				scanf("%d",&aij);
				B[i%2][j] = aij+MAX(B[(i+1)%2][j-1],MAX(B[(i+1)%2][j],B[(i+1)%2][j+1]));
				ret = MAX(ret,B[i%2][j]);
			}

		}
		printf("%d\n",ret);	
	}
}

