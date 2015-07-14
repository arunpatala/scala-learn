N = int(raw_input())
for n in range(0,N):
	M = int(raw_input())
	lst = []
	for m in range(0,M):
		lst.append(raw_input())
	lst.sort()
	for l in lst:
		print l
