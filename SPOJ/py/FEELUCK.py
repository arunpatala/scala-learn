N = int(raw_input())
for n in range(0,N):	
	lst = []	
	for i in range(0,10):
		a = str.split(raw_input())
		lst.append((int(a[1]),-i,a[0]))
	lst.sort()
	lst.reverse()
	print "Case #"+str(n+1)+":"
	for l in lst:
		if(l[0]==lst[0][0]):
			print l[2]
