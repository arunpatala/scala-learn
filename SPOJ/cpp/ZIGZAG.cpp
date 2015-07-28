#include<cstdio>
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int get(int i, int j, int N)
{
	if(i+j<=N+1)
	{
		int c = i+j-1;
		int cstart = (c*(c-1))/2;
		if(c%2!=0) return cstart+j;
		else return cstart+c-j+1;
	}
	else{//j>i
		i=N-i+1;
		j=N-j+1;
		int c = i+j-1;
		int cstart = (c*(c-1))/2;
		if(c%2!=0) return (N*N+1)-(cstart+j);
		else return (N*N+1)-(cstart+c-j+1);

	}
}

int main(void){
	int N,K;
	string s;
	cin >> N >> K;
	cin >> s;
	int i=1,j=1;
	/*for(int ii=1;ii<=N;ii++)
	{
		for(int jj=1;jj<=N;jj++)
			cout << get(ii,jj,N) << ",";
		cout << endl;
	}*/
	long long sum = 1;
	for(int k=0;k<s.size();k++)
	{
		switch(s[k]){
			case 'U': i--;
			break;
			case 'D':i++;
			break;
			case 'L':j--;
			break;
			case 'R':j++;
			break;
		}
		//cout << i << "," << j << ":" << get(i,j,N) << endl;
		sum += get(i,j,N);
	}
	cout << sum << endl;
}
