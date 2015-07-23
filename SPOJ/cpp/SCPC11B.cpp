#include <cstdio>
#include <algorithm>
using namespace std;
#define NMAX 1500

int A[NMAX];

int main(void){
	while(true){
		int N;
		scanf("%d",&N);
		if(N==0)break;
		for(int i=0;i<N;i++)
			scanf("%d",&A[i]);
		sort(A,A+N);
		bool valid = true;
		for(int i=1;i<N;i++)
			if(A[i]-A[i-1]>200)
				valid = false;
		if(valid) printf("POSSIBLE\n");
		else printf("IMPOSSIBLE\n");
	}

}
