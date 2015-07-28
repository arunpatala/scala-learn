#include<stdio.h>

int gcd(int a, int b){
	return (b==0)?a:gcd(b,a%b);
}

int main(){
	int T,A,B,i,a,ai,b,bi,ret,p,g;
	double d;
	scanf("%d",&T);
	while(T--){
		scanf("%lf",&d);
		a = (int)(d*10000);
		b = 10000;
		g = gcd(a,b);
		printf("%d\n",(b/g));
	}
}

