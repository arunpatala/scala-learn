N = int(raw_input())
for i in range(0,N):
	a = str.split(raw_input());
	m = int(a[0])-1
	s = a[1]
	print str(i+1)+" "+s[:m]+s[m+1:]
