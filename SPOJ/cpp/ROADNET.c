#include<stdio.h>
#define N 201
int D[N][N];

int main(){
	int T,M,i,j,k;
	scanf("%d",&T);
	while(T--){
		scanf("%d",&M);
		for(i=1;i<=M;i++)
			for(j=1;j<=M;j++)
				scanf("%d",&(D[i][j]));
		for(i=1;i<=M;i++)
			for(j=i+1;j<=M;j++)
			{
				int valid = 1;
				for(k=1;k<=M;k++)
					if(i!=k && j!=k)
						if(D[i][k]+D[k][j]==D[i][j])
							valid = 0;
				if(valid)
					printf("%d %d\n",i,j);
			}

	}
}

