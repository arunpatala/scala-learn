#include<cstdio>
#include<vector>
using namespace std;

vector<int> adj[2001];
int g[2001];

bool DFS(int i, int gi){
	g[i] = gi;
	for(int k=0;k<adj[i].size();k++)
	{
		int j=adj[i][k];
		if(g[j]==0){if(!DFS(j,-gi)) return false;}
		else if(g[j]!=-g[i]) return false;
	}
	return true;

}


int main(void){
	int t = 0; 
	scanf("%d",&t);
	for(int ti=1;ti<=t;ti++){
		printf("Scenario #%d:\n",ti);
		int N, M; scanf("%d%d",&N,&M);
		for(int i=1;i<=N;i++){
			adj[i].clear();
			g[i]=0;
		}
		for(int i=0;i<M;i++){
			int u, v; 
			scanf("%d%d",&u,&v);
			adj[u].push_back(v);
			adj[v].push_back(u);
		}
		bool valid = true;
		for(int i=1;i<=N && valid;i++)
			if(g[i]==0) valid = valid && DFS(i,1);
			
		if(!valid) printf("Suspicious bugs found!\n");
		else printf("No suspicious bugs found!\n");
	}

}
