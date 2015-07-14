lst = []
while(True):
	try:
		st = str.split(raw_input())
		lst.append((-int(st[1]),st[0]))
	except (EOFError):
		break
lst.sort()
for i in lst:
	print i[1]
