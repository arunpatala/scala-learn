#include<stdio.h>
#include <stdlib.h>
#define NMAX 59 
#define MIN(X,Y) ((X)<(Y)?(X):(Y))
#define MAX(X,Y) ((X)>(Y)?(X):(Y))
#define BW(x1,x,x2) (MIN(x1,x2)<=(x) && (x)<=MAX(x1,x2))
int P[NMAX][2];
int N,A,B;


int solve(int px, int py, int x1, int y1, int x2, int y2){
	int xy = ((px-x1)*(py-y2))-((px-x2)*(py-y1));
	printf("%d %d %d\n",px,py,xy);
	if(xy!=0)return 0;
	if(BW(x1,px,x2) && BW(y1,py,y2)) return 1;
	else return 0;
}

int main(){
	int T,N,M,i,j;
	int x1,y1,x2,y2;
	scanf("%d",&T);
	while(T--){
		scanf("%d",&N);
		scanf("%d",&M);
		for(i=0;i<N;i++)
			scanf("%d %d",&P[i][0],&P[i][1]);
		for(i=0;i<M;i++)
		{
			int ret = 0;
			scanf("%d %d %d %d",&x1,&y1,&x2,&y2);
			for(j=0;j<N;j++)
				if(solve(P[j][0],P[j][1],x1,y1,x2,y2))
					ret++;
			printf("%d\n",ret);
		}
	}
}


