#include<cstdio>
#include<cstring>
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
#define NMAX 100009
#define CMAX 1009
int C[CMAX];


int main(void){
	int T;cin>>T;
	for(int t=1;t<=T;t++)
	{
		int N,X,A;cin >> X >> N;
		for(int i=0;i<=CMAX;i++)
			C[i]=0;
		long long sum = 0;
		for(int i=0;i<N;i++)
		{
			cin >> A;
			int Y = X-A;
			if(Y>=0){
				sum+=C[Y];
			}
			C[A]++;
		}
		printf("%d. %lld\n",t,sum);
	}
}
