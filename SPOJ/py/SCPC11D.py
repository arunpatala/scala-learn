while(True):
	s = raw_input()
	if(s=="0 0 0"):
		break
	else:
		a = [int(x) for x in str.split(s)]
		a.sort()
		print a
		if(a[0]*a[0]+a[1]*a[1]==a[2]*a[2]):
			print "right"
		else:
			print "wrong"
