#include<cstdio>
#include<cstring>
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
#define NMAX 100009
bool DP[NMAX];
int A[109];

int main(void){
	int T;
	cin >> T;
	while(T--){
		int N;cin >> N;
		memset(DP,false,NMAX);
		DP[0]=true;
		int sum=0;
		for(int i=0;i<N;i++)
		{
			int a;cin >> a;
			sum+=a;
			for(int j=sum;j>=a;j--)
			{
				if(DP[j-a])DP[j]=true;
			}
		}
		long long ret = 0;
		for(int i=0;i<=sum;i++)
			if(DP[i])
				ret += i;
		cout << ret << endl;

	}
}
