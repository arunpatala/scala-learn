n = 0
while(True):
	try:
		s = raw_input()
		a = [int(x) for x in str.split(s)]
		ret = 0
		cnt = 0
		for i in range(0,3):
			if(a[i]!=0):
				cnt = cnt + 1
				ret = ret + a[i] + (a[3+i]-1)*20*60
		print "team "+str(n)+": "+str(cnt)+", "+str(ret)
		n = n + 1
	except (EOFError):
		break
