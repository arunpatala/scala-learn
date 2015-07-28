#include<stdio.h>
#define NMAX  100
char S[NMAX][NMAX];
int C[NMAX][27];
int A[26];
int main(){
	int N,M,K,i,j,k,cnt;
	scanf("%d %d %d",N,M,K);
	for(i=0;i<N;i++)
		scanf("%s",S[i]);
	for(i=0;i<M;i++)
		for(j=0;j<K;j++)
		{
			k=S[j][i]-'A';
			C[j][k]++;
		}
	for(i=0;i<K;i++)
		for(j=0;j<26;j++)
		{
			if(A[k]==0&&C[i][k]!=0)cnt++;
			A[k]+=C[i][k];
		}
//repeat this N-K times
	for(i=K;i<N;i++)
	{
		for(j=0;j<26;j++)
		{
			if(A[j]!==0&&A[j]==C[i-K][j])cnt--;
			A[j]-=C[i-K][j];
		}
		for(j=0;j<26;j++)
		{
			if(A[j]==0&&C[i][j]!=0)cnt++;
			A[j]+=C[i][j];
		}
	}
	for(i=0;i<M;i++)
	{
		k=S[0][i]-'A';

	}


}

