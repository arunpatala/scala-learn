for n in range(int(raw_input())):
	st = str.split(raw_input())
	cnt = [ 0 for x in range(26)]
	for s in st[0]:
		cnt[ord(s)-ord('a')] = cnt[ord(s)-ord('a')] + 1
	for s in st[1]:
		cnt[ord(s)-ord('a')] = cnt[ord(s)-ord('a')] - 1
	sm = [ x for x in cnt if x!=0]
	if(len(sm)==0):
		print "YES"
	else:
		print "NO"
