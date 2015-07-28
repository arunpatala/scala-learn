#include<cstdio>
#include<cstring>
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
#define NMAX 39 
int C[NMAX];
int N,A,B;
int D[1<<18];
int d=0;

void solve1(int sum, int i, int M)
{
	
	if(i==M)
		D[di++]=sum;
	else
	{
		solve1(sum+C[i],i+1,M);
		solve1(sum,i+1,M);
	}
}

long long solve2(int sum, int i, int M)
{
	
	if(i==N)
	{
		//A<=sum+X<=B
		lower_bound(D,D+d,A-sum);
		upper_bound(D,D+d,B-sum);
	}
	else
	{
		long long ret = 0;
		ret += solve2(sum+C[i],i+1,M);
		ret += solve2(sum+C[i],i+1,M);
		return ret;
	}
}

int main(){
	int i.mid;
	scanf("%d %d %d",&N,&A,&B);
	for(i=0;i<N;i++)
		scanf("%d",&C[i]);
	mid=N/2;
	solve1(0,0,mid);
	sort(D,D+d);
	
}


