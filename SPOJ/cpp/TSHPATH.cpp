#include<cstdio>
#include<cstring>
#include<iostream>
#include<vector>
#include<algorithm>
#include<map>
using namespace std;
#define NMAX 10009
map<string,int> cityMap;
vector<vector<int>> edges;


bool icompare(Interval const& l, Interval const& r){ return  l.end<r.end;}

int main(void){
	int T;
	cin >> T;
	while(T--){
		int N;
		cin >> N;
		cityMap.clear();
		edges.clear();
		for(int i=1;i<=N;i++)
		{
			string name;
			cin >> name;
			cityMap[name]=i;
			int M;
			cin >> M;
			vector<int> e;
			for(int j=0;j<M;j++)
			{
				int u,w;
				cin >> u >> w;
				e.push_back(u);
				e.push_back(w);
			}
			edges.push_back(e);
		}
		int M;
		cin >> M;
		for(int i=0;i<M;i++)
		{
			string a,b;
			cin >> a >> b;
			
		}
	}
}
