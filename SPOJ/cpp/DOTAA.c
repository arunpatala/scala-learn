#include<stdio.h>
#define MAX(X, Y) (((X) > (Y)) ? (X) : (Y))

int B[2][105];
int main(){
	int t;
	scanf("%d",&t);
	while(t--){
		int n,m,D,i,A;
		scanf("%d %d %d",&n,&m,&D);
		int count=0;
		for(i=0;i<n;i++){
			scanf("%d",&A);
			if(A%D==0) count += ((A/D)-1);
			else count += (A/D);
		}
		if(count>=m) 
			printf("YES\n");
		else printf("NO\n");
	}
}

