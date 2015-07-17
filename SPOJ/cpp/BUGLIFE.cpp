#include<cstdio>
#include<vector>
using namespace std;

vector<int> adj[2001];
int g[2001];

bool DFS(int i, int gen){
	g[i] = gen;
	for(int j=0;j<adj[i].size();j++){
		int k = adj[i][j];
		if(g[k]==0){if(!DFS(j,-gen)) return false;}
		else {if(g[i]!=-g[k])return false; }
	}
	return true;
}

int main(void){
	int t = 0; 
	scanf("%d",&t);
	while(t--){
		int N, M; scanf("%d%d",&N,&M);
		for(int i=0;i<N;i++){
			adj[i].clear();
			g[i]=0;
		}
		for(int i=0;i<M;i++){
			int u, v; 
			scanf("%d%d",&u,&v);
			adj[u].push_back(v);
			adj[v].push_back(u);
		}
		for(int i=0;i<N;i++){
			if(g[i]==0)
				if(!DFS(i,1))printf("Suspicious bugs found!\n");
		}
		printf("No suspicious bugs found!\n");
	}

}
