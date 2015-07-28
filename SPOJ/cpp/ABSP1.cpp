#include <cstdio>
#include <vector>
#include <cmath>
#include <algorithm>
#include <string>
using namespace std;


int main(){
	int T;
	scanf("%d",&T);
	while(T--){
		int N;
		scanf("%d",&N);
		long long sum = 0,lsum=0;
		for(int i=0;i<N;i++)
		{
			int A;
			scanf("%d",&A);
			sum+= (i*A-lsum);
			lsum+=A;
		}
		printf("%lld\n",sum);
	}
}


