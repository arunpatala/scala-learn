#include<cstdio>
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main(void){
	int t = 0; 
	scanf("%d",&t);
	while(t--){
		int N,a; 
		int A[N],B[N];
		scanf("%d",&N);
		for(int i=0;i<N;i++)
		{
			scanf("%d",&a);
			A[a]=i;
		}
		for(int i=0;i<N;i++)
		{
			scanf("%d",&a);
			B[i] = A[a];
		}
		int C[N];
		C[0]=B[0];
		int j=1;
		for(int i=1;i<N;i++)
		{
			if(B[i]>C[j-1])C[j++]=B[i];
			else {
				int* k = upper_bound(C,C+j,B[i]);
				*k=B[i];
			}
		}
		printf("%d\n",j);
	}

}
