#include<cstdio>
#include<cstring>
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
#define NMAX 1001
int DP[NMAX][NMAX];
int P[NMAX][NMAX];

int main(void){
	while(true){
		int K;
		cin >> K;
		if(K==0)break;
		string A,B;
		cin >> A;
		cin >> B;
		int N = A.size(),M=B.size();
		for(int i=0;i<=A.size();i++)DP[0][i]=0;
		for(int i=0;i<=B.size();i++)DP[i][0]=0;
		for(int i=1;i<=A.size();i++)
		{
			for(int j=1;j<=B.size();j++)
			{
				DP[i][j]=0;
				if(A[i-1]==B[j-1])DP[i][j]=DP[i-1][j-1]+1;
				else DP[i][j]==0;
				//cout << DP[i][j] << ",";
			}
			//cout << endl;
		}
		for(int i=0;i<=A.size();i++)P[0][i]=0;
		for(int i=0;i<=A.size();i++)P[i][0]=0;
		for(int i=1;i<=A.size();i++)
		for(int i=1;i<=A.size();i++)
		for(int i=1;i<=A.size();i++)
		{
			for(int j=1;j<=B.size();j++)
			{
				P[i][j]=0;
				P[i][j]=max(P[i-1][j],P[i][j-1]);
				int k = DP[i][j];
				if(k>=K){
					for(int l=K;l<=k;l++)
						P[i][j]=max(P[i][j],P[i-l][j-l]+l);
				}
				//cout << i << "," << j << "," <<P[i][j] << ",";
			}
			//cout << endl;
		}
		cout << P[N][M] << endl;
	}
}
