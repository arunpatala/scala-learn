for n in range(int(raw_input())):
	m = int(raw_input())
	s = 1
	ret = 0
	steps = 1
	while(s<=m):
		if(s&m==s):
			ret = ret + (5**steps)
		s = s<<1
		steps = steps + 1
	print ret
