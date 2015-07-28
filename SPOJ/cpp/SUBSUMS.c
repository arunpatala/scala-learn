#include<stdio.h>
#include <stdlib.h>

#define NMAX 39 
int C[NMAX];
int N,A,B;

long long solve(int sum, int i)
{
	
	if(i==N)
	{
		if(A<=sum&&sum<=B) return 1;
		else return 0;
	}
	else
	{
		if(sum>B) return 0;
		long long ret = 0;
		ret+=solve(sum+C[i],i+1);
		ret+=solve(sum,i+1);
		return ret;
	}
}



int cmpfunc (const void * a, const void * b)
{
   return ( *(int*)a - *(int*)b );
}

int main(){
	int i;
	scanf("%d %d %d",&N,&A,&B);
	for(i=0;i<N;i++)
		scanf("%d",&C[i]);
	qsort(C, N, sizeof(int), cmpfunc);
	printf("%lld\n",solve(0,0));
	
}


