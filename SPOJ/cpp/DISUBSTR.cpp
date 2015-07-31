#include<iostream>
#include<stdio.h>
#include<algorithm>
#include<string>

using namespace std;

int lcp(string A, string B)
{
	int i=0;
	for(;i<min(A.size(),B.size());i++)
		if(A[i]!=B[i])
			return i;
	return i;
}

int main() {
	int T; 
	scanf("%d",&T);
	while(T--)
	{
		string A;
		cin >> A;
		int N = A.size();
		string B[N];
		for(int i=0;i<N;i++)
			B[i]=A.substr(i);
		sort(B,B+N);
		for(int i=0;i<N;i++)
			cout << B[i] << endl;
		int cnt=B[0].size();
		for(int i=1;i<N;i++)
			cnt+=(B[i].size()-lcp(B[i-1],B[i]));
		cout << cnt << endl;
	}
}
