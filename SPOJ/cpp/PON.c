#include<stdio.h>
#define N ((1<<64)-1)
P[];
int main(){
	int T;
	long l;
	scanf("%d",T);
	while(T--){
		scanf("%lld",l);
		if(P[l]) printf("YES\n");
		else printf("NO\n");
	}
}

