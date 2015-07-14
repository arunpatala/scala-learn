print "Ready"
while(True):
	s = raw_input()
	if(s=="  "):
		break
	else:
		if(s=="pq" or s=="qp" or s=="db" or s=="bd"):
			print "Mirrored pair"
		else:
			 print "Ordinary pair"
