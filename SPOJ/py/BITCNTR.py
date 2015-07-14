for n in range(int(raw_input())):
	m = int(raw_input())
	s = 1;
	cnt = 0;
	while(s<=m):
		if(s&m==s):
			cnt = cnt + 1
		s = s<<1
	print cnt
