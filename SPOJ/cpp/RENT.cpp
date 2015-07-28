#include<cstdio>
#include<cstring>
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
#define NMAX 10009
struct Interval{
	int start;
	int end;
	int cost;
};

Interval I[NMAX];

bool icompare(Interval const& l, Interval const& r){ return  l.end<r.end;}
bool operator <(Interval const& l, int const& r){ return  l.end<r;}

int main(void){
	int T;cin>>T;
	while(T--){
		int N;cin >> N;
		for(int i=0;i<N;i++)
		{
			int start,dur,cost;
			cin >> start >> dur >> cost;
			I[i].start = start;
			I[i].end = start+dur;
			I[i].cost = cost;
		}
		sort(I,I+N,&icompare);
		for(int i=0;i<N;i++)
		{
			//cout << I[i].start << "," << I[i].end << endl;
			Interval* in = lower_bound(I,I+N,I[i].start);
			cout << in-I << endl;
		}
	}
}
