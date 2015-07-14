S = [(x,raw_input()) for x in range(1,6)]
SF = [ str(y[0]) for y in S if "FBI" in y[1] ]
if(len(SF)==0):
	print "HE GOT AWAY!"
else:
	print ' '.join(SF)

