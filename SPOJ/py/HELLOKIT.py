while True:
	a = str.split(raw_input())
	if len(a)==1:
		break
	else:
		n = int(a[1])
		s = a[0]*n
		for i in range(0,len(a[0])):
			print s
			s = s[1:]+s[:1]

