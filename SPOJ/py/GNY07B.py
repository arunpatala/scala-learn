N = int(raw_input())
kg2lb = 2.2046
lb2kg = 0.4536
l2g = 0.2642
g2l = 3.7854
for i in range(0,N):
	a = str.split(raw_input())
	d = float(a[0])
	if(a[1]=="kg"):
		print (i+1),'{0:.4f} lb'.format(d*kg2lb)
	if(a[1]=="lb"):
		print (i+1),'{0:.4f} kg'.format(d*lb2kg)
	if(a[1]=="l"):
		print (i+1),'{0:.4f} g'.format(d*l2g)
	if(a[1]=="g"):
		print (i+1),'{0:.4f} l'.format(d*g2l)

