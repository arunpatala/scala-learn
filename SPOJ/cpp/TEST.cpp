#include <cstdio>
#include <algorithm>

using namespace std;

int main() {
	char A[30000];
	int N,M,C;
	for(int t=0;t<10;t++)
	{
		scanf("%d", &N);
		scanf("%s", A);
		scanf("%d", &M);
		for(int i=0;i<M;i++)
		{
			scanf("%d",&C);
			if(C==0){
				printf("%s\n",A);
			}else{
				A[C-1]='('+')'-A[C-1];
			}
		}
	}		
	return 0;
}
