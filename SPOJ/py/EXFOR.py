N = int(raw_input())
for n in range(0,N):
	A = []
	zeros = 0
	ones = 0
	a = [int(x) for x in str.split(raw_input())]
	zeros= [ x for x in a if x==0]
	Z = len(zeros)
	#10C2+10C3 - ZC3+ZC2
	ret = ((10*9)/2+(10*9*8)/6) - ((Z*(Z-1)*(Z-2))/6 + (Z*(Z-1))/2)
	print ret%2
	
