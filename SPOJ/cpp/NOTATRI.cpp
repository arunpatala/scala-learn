#include <cstdio>
#include <algorithm>
using namespace std;
#define NMAX 2001

int A[NMAX];
int B[NMAX];

int main(void){
	while(true){
		int N,u;
		scanf("%d",&N);
		if(N==0)break;
		for(int i=0;i<N;i++)
			scanf("%d",&A[i]);
		sort(A,A+N);
		int sol = 0;
		for (int i = N-1; i > 1; --i) {
		    int j = 0, k = i-1;
		    while(j<k) {
			while(j<k && A[j]+A[k] >= A[i]) k--;
			sol += k-j;
			++j;
		    }
		}
		printf("%d\n", sol);

	}

}
