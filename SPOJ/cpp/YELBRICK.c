#include<stdio.h>
#define NMAX  1001
int IN[NMAX][3];

int GCD(int a,int b){
	return (b==0)?a:GCD(b,a%b);
}

int main(){
	int N,G,i,j;
	long long SUM = 0;
	while(1){
		scanf("%d",&N);
		if(N==0)break;
		for(i=0;i<N;i++)
			for(j=0;j<3;j++)
				scanf("%d",&IN[i][j]);
		G = IN[0][0];
		for(i=0;i<N;i++)
			for(j=0;j<3;j++)
				G = GCD(G,IN[i][j]);
		SUM = 0;
		for(i=0;i<N;i++)
			SUM += ((IN[i][0]/G)*(IN[i][1]/G)*(IN[i][2]/G));
		printf("%lld\n",SUM);

	}
}

