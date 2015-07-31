#include<iostream>
#include<stdio.h>
#include<algorithm>
#include<string>

using namespace std;

int main() {
	int N; 
	while(scanf("%d",&N)!=EOF)
	{
		string A;
		cin >> A;
		string B;
		cin >> B;
		int M = B.size();
		int T[N];
		int len=0,i=0;
		T[i++]=0;
		while(i<N)
		{
			if(A[i]==A[len]){
				len++;
				T[i]=len;
				i++;
			}else if(len==0){
				T[i]=0;
				i++;
			}else{
				len=T[len-1];
			}
		}
		i=0;int j=0;
		while(i<M){
			if(B[i]==A[j]){
				i++;j++;
			}else if(j==0){i++;}
			else{
				j=T[j-1];
			}
			if(j==N)cout << i-j << endl;
		}
		cout << endl;
	}
	
	return 0;
}
