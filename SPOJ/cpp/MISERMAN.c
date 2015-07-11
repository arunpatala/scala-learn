#include<stdio.h>
#define MIN(X, Y) (((X) < (Y)) ? (X) : (Y))
#define INT_MAX (101*101*101)

int B[2][105];
int main(){
		int n,m,i,j,aij,ret;
		scanf("%d%d",&n,&m);
		for(j=0;j<=m+1;j++){
			B[0][j]=INT_MAX;
			B[1][j]=INT_MAX;
		}
		ret = INT_MAX;
		for(j=1;j<=m;j++){
			scanf("%d",&aij);
			B[0][j] = aij;
			ret = MIN(ret,B[0][j]);
		}
		for(i=1;i<n;i++)
		{
			ret = INT_MAX;
			for(j=1;j<=m;j++)
			{
				scanf("%d",&aij);
				B[i%2][j] = aij+MIN(B[(i+1)%2][j-1],MIN(B[(i+1)%2][j],B[(i+1)%2][j+1]));
				ret = MIN(ret,B[i%2][j]);
			}

		}
		printf("%d\n",ret);	
}

