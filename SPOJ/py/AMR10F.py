N = int(raw_input())
for i in range(0,N):
	a = str.split(raw_input())
	N = int(a[0])
	A = int(a[1])
	D = int(a[2])
	res = N*A + ((N-1)*(N)*D)/2
	print res
