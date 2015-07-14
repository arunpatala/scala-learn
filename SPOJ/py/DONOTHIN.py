while(True):
	st = [int(x) for x in str.split(raw_input())]
	N = st[0]
	M = st[1]
	if(N==-1 and M==-1):
		break
	else:
		lst = [int(x) for x in str.split(raw_input())]
		lst1 = [sum(lst[:x]) for x in range(N)]
		print sum(lst1)*M

	
