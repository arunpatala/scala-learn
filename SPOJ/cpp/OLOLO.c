#include<stdio.h>
int main(void){
	int t,i,xor;
	scanf("%d",&t);
	xor = 0;
	while(t--){
		scanf("%d",&i);
		xor = xor^i;
	}
	printf("%d\n",xor);
	return 0;
}

