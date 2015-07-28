#include<cstdio>
#include<cstring>
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
#define NMAX 100000
bool DP[NMAX*100];

int main(void){
	int T;
	cin >> T;
	while(T--){
		int N;
		cin >> N;
		cout << "N:" << N << endl;
		memset(DP,false,N*100+1);
		DP[0]=true;
		int sum=0;
		bool found = false;
		for(int i=0;i<N;i++)
		{
			int a;cin >> a;
			sum+=a;
			for(int j=sum;j>=a&!found;j--)
			{
				if(DP[j-a])DP[j]=true;
				if(j%2==0&&DP[j]&&DP[j/2]){
					found=true;
					cout << j << "," << j/2 << endl;
				}
			}
		}
		if(found)cout << "YES" << endl;
		else cout << "NO" << endl;

	}
}
