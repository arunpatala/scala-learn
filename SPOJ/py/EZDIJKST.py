from sets import Set
N = int(raw_input())
for n in range(0,N):
	a = str.split(raw_input())
	V = int(a[0])
	K = int(a[1])
	edges = [[] for x in range(0,N+1)]
	for k in range(0,K):
		a = str.split(raw_input())
		u = int(a[0])
		v = int(a[1])
		w = int(a[2])
		edges[u].append((v,w))
		edges[v].append((u,w))
	print edges
	st = str.split(raw_input())
	u = int(st[0])
	v = int(st[1])
	dist = [1000 for x in range(N+1)]
	dist[u] = 0
	set = Set([u]):


	
