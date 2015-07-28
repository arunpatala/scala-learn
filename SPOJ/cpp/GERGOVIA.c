#include <stdio.h>
#define NMAX 100009
#define ABS(X) (((X)<0)?-(X):(X))
int main(void) {
	int T,N,i,sum,a,ret;
	while(1){
		scanf("%d",&N);
		if(N==0)break;
		sum=0;
		ret=0;
		for(i=0;i<N;i++){
			scanf("%d",&a);
			sum+=a;
			ret+=ABS(sum);
		}
			
		printf("%d\n",ret);	
	}
	return 0;
}
