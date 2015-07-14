N = int(raw_input())
def get():
	for i in range(0,N):
		yield int(raw_input())
L = list(get())
for i in sorted(L):
	print i
