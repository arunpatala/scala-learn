#include<cstdio>
#include<vector>
using namespace std;

vector<int> adj[100000];
bool g[100000];

void DFS(int i){
	g[i]=true;
	for(int j=0;j<adj[i].size();j++){
		int k = adj[i][j];
		if(!g[k])DFS(k);
	}
}

int main(void){
	int t = 0; 
	scanf("%d",&t);
	while(t--){
		int N, M; 
		scanf("%d",&N);
		scanf("%d",&M);
		for(int i=0;i<N;i++){
			adj[i].clear();
			g[i]=false;
		}
		for(int i=0;i<M;i++){
			int u, v; 
			scanf("%d%d",&u,&v);
			adj[u].push_back(v);
			adj[v].push_back(u);
		}
		int ret = 0;
		for(int i=0;i<N;i++)
			if(!g[i]){
				ret++;
				DFS(i);
			}
		printf("%d\n",ret);
	}

}
