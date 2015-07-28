#include <cstdio>
#include <vector>
#include <cmath>
#include <algorithm>
#include <string>
using namespace std;
int mod = 10000007;
long long pow(long long a, long long b){
	long long ret = 1;
	while(b>0){
		if(b%2==1) ret = (ret*a)%mod;
		a = (a*a)%mod;
		b = b/2;
	}
	return ret;
}

long long f(long long n, long long k)
{
	return (pow(n,n)+pow(n,k))%mod;
}
long long fun2(long long n, long long k)
{
	return (f(n,k)+2*f(n-1,k))%mod;
}



int main(){
	int T;
	long long n,k;
	while(true){
		scanf("%lld %lld",&n,&k);
		if(n==0&&k==0)break;
		printf("%lld\n",fun2(n,k));
	}
}


