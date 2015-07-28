#include<stdio.h>

long long size(long N){
}

int main(){
	int T;
	long long S,N,steps;
	scanf("%d",&T);
	while(T--!=0){
		steps = 1;
		scanf("%lld",&N);
		S = 1;
		while(S<N){S<<=1;steps++;}
		N = ((N^(N-1))+1)/2;
		while(N){N>>=1;steps--;}
		printf("%lld %lld\n",S,steps);
	}
}


