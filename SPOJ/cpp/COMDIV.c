#include<stdio.h>
#define N 1021
#define min(A,B) (((A)<(B))?(A):(B))
int P[N];
int PP[N];
int PSIZE = 0;

void primes(){
	int i,j;
	for(i=2;i<=N;i++)
		P[i]=1;
	for(i=2;i*i<=N;i++)
		if(P[i])
			for(j=i*i;j<=N;j+=i)
				P[j]=0;
	for(i=2;i<=N;i++)
		if(P[i]) PP[PSIZE++] = i;
	for(i=0;i<PSIZE;i++)
		printf("%d,",PP[i]);
	printf("\n");

}

int gcd(int a, int b){
	return (b==0)?a:gcd(b,a%b);
}

int main(){
	int T,A,B,i,a,ai,b,bi,ret,p,g;
	primes();
	scanf("%d",&T);
	while(T--){
		scanf("%d%d",&A,&B);
		ret = 1;
		g = gcd(A,B);
		for(i=0;i<PSIZE&&PP[i]<=g;i++)
			{
				p = PP[i];
				a=g;ai=0;
				while((a%p)==0){ai++;a/=p;}
				ret *= (ai+1);
			}
		printf("%d\n",ret);
	}
}

