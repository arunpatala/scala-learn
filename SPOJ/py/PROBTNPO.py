def steps(n):
	steps = 1;
	while n!=1:
		if(n%2==1):
			n = 3*n+1
		else:
			n = n/2
		steps = steps + 1
	return steps


while(True):
	try:
		st = [int(x) for x in str.split(raw_input())]
		i = st[0]
		j = st[1]
		if(i>j):
			print "%d %d" % (i,j)
		else:
			stps = [steps(x) for x in range(i,j+1)]
			print "%d %d %d"%(i,j,max(stps))
	except (EOFError):
		break
